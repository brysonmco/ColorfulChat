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

package dev.brysonmcbreen.colorfulchat.command;

import dev.brysonmcbreen.colorfulchat.ColorfulChat;
import dev.brysonmcbreen.colorfulchat.menu.ColorGui;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class ChatColorCommand implements CommandExecutor {

    private final ColorfulChat instance;
    private static final String PREFIX = ColorfulChat.getPrefix();

    public ChatColorCommand(ColorfulChat instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            String[] args
    ) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "ERROR: You must be a player to run this command!");
            return true;
        }

        if (args.length < 1) {
            new ColorGui(p).open();
            return true;
        }

        PersistentDataContainer data = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(instance, "chatcolor");

        String color = args[0].toLowerCase();
        switch (color) {
            case "black" -> data.set(key, PersistentDataType.STRING, "BLACK");
            case "dark_blue" -> data.set(key, PersistentDataType.STRING, "DARK_BLUE");
            case "dark_green" -> data.set(key, PersistentDataType.STRING, "DARK_GREEN");
            case "dark_aqua" -> data.set(key, PersistentDataType.STRING, "DARK_AQUA");
            case "dark_red" -> data.set(key, PersistentDataType.STRING, "DARK_RED");
            case "dark_purple" -> data.set(key, PersistentDataType.STRING, "DARK_PURPLE");
            case "gold" -> data.set(key, PersistentDataType.STRING, "GOLD");
            case "gray" -> data.set(key, PersistentDataType.STRING, "GRAY");
            case "dark_gray" -> data.set(key, PersistentDataType.STRING, "DARK_GRAY");
            case "blue" -> data.set(key, PersistentDataType.STRING, "BLUE");
            case "green" -> data.set(key, PersistentDataType.STRING, "GREEN");
            case "aqua" -> data.set(key, PersistentDataType.STRING, "AQUA");
            case "red" -> data.set(key, PersistentDataType.STRING, "RED");
            case "pink" ->
                    data.set(key, PersistentDataType.STRING, "LIGHT_PURPLE"); // 'pink' is not available in ChatColor, using LIGHT_PURPLE instead
            case "yellow" -> data.set(key, PersistentDataType.STRING, "YELLOW");
            case "white" -> data.set(key, PersistentDataType.STRING, "WHITE");
            default -> {
                new ColorGui(p).open();
                return true;
            }
        }

        p.sendMessage(PREFIX + ChatColor.GREEN + "Your chat color has been successfully changed to " + ChatColor.valueOf(args[0].toUpperCase()) + args[0] + ChatColor.GREEN + "!");
        return true;
    }
}
