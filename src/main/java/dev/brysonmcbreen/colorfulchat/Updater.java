/*
   Copyright 2026 Bryson McBreen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package dev.brysonmcbreen.colorfulchat;

import com.google.common.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Updater {

    private final String currentVersion;

    public Updater(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    record Version (
            String name,
            String versionNumber,
            String versionType,
            List<String> loaders,
            boolean featured
    ){}

    private List<Version> getVersions() throws IOException {
        URL url = URI.create("https://api.modrinth.com/v2/project/OvVrnX0V/version").toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP Error: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        Gson gson = new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type type = new TypeToken<List<Version>>(){}.getType();
        return gson.fromJson(content.toString(), type);
    }

    public boolean shouldUpdate() throws IOException {
        List<Version> versions = getVersions();

        Version latest = versions.stream()
                .filter(v -> v.featured)
                .findFirst().orElseThrow();

        return latest.versionNumber != null && !latest.versionNumber.equals(currentVersion);
    }

}
