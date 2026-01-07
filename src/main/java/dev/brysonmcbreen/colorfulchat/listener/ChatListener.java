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

package dev.brysonmcbreen.colorfulchat.listener;

import dev.brysonmcbreen.colorfulchat.ColorfulChat;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ChatListener implements Listener {
    private final ColorfulChat instance;
    private static final String CHANGE_COLOR_PERMISSION = "colorfulchat.change";
    private static final String COLOR_CODES_PERMISSION = "colorfulchat.codes";

    public ChatListener(ColorfulChat instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainer data = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(instance, "chatcolor");

        if (data.has(key, PersistentDataType.STRING) && player.hasPermission(CHANGE_COLOR_PERMISSION)) {
            e.setMessage(ChatColor.valueOf(data.get(key, PersistentDataType.STRING)) + e.getMessage());
        } else {
            e.setMessage(instance.getDefaultColor() + e.getMessage());
        }

        if (e.getPlayer().hasPermission(COLOR_CODES_PERMISSION)) {
            e.setMessage(e.getMessage().replace("&", "§"));
        }

    }

}
