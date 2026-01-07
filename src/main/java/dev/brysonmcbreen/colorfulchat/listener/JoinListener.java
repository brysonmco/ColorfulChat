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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class JoinListener implements Listener {
    private final ColorfulChat instance;
    private static final String PREFIX = ColorfulChat.getPrefix();
    private static final String CHANGE_COLOR_PERMISSION = "colorfulchat.change";
    private static final String COLOR_CODES_PERMISSION = "colorfulchat.codes";

    public JoinListener(ColorfulChat instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainer data = player.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(instance, "chatcolor");

        if (!data.has(key, PersistentDataType.STRING)) {
            data.set(key, PersistentDataType.STRING, instance.getDefaultColor().toString());

            // Inform player that they have access to the command
            if (player.hasPermission(CHANGE_COLOR_PERMISSION) && !instance.getInfoMsg().isEmpty()) {
                player.sendMessage(PREFIX + ChatColor.translateAlternateColorCodes('&', instance.getInfoMsg()));
            }

            // Inform player that they have access to color codes
            if (player.hasPermission(COLOR_CODES_PERMISSION) && !instance.getPermissionMsg().isEmpty()) {
                player.sendMessage(PREFIX + ChatColor.translateAlternateColorCodes('&', instance.getPermissionMsg()));
            }
        }
    }
}
