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
package dev.brysonmcbreen.colorfulchat.menu;

import dev.brysonmcbreen.colorfulchat.ColorfulChat;
import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ColorGui extends Gui {

    private final ColorfulChat instance = ColorfulChat.getInstance();
    private static final String PREFIX = ColorfulChat.getPrefix();

    public ColorGui(Player player) {
        super(player, "colors-gui", "Chat Colors", 4);
        //player, id, title, row
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        PersistentDataContainer data = event.getPlayer().getPersistentDataContainer();


        // Aqua
        addItem(0, new Icon(Material.CYAN_CONCRETE).setName(ChatColor.AQUA + "Aqua").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.AQUA + "aqua" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "AQUA");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.AQUA +
                            "Aqua" + ChatColor.YELLOW + "!"
            );
        }));

        // Black
        addItem(1, new Icon(Material.BLACK_CONCRETE).setName(ChatColor.BLACK + "Black").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.BLACK + "black" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLACK");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.BLACK +
                            "Black" + ChatColor.YELLOW + "!"
            );
        }));

        // Blue
        addItem(2, new Icon(Material.BLUE_CONCRETE).setName(ChatColor.BLUE + "Blue").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.BLUE + "blue" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "BLUE");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.BLUE +
                            "Blue" + ChatColor.YELLOW + "!"
            );
        }));

        // Dark Aqua
        addItem(3, new Icon(Material.CYAN_WOOL).setName(ChatColor.DARK_AQUA + "Dark Aqua").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_AQUA + "dark aqua" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_AQUA");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_AQUA +
                            "Dark Aqua" + ChatColor.YELLOW + "!"
            );
        }));

        // Dark Blue
        addItem(4, new Icon(Material.BLUE_CONCRETE).setName(ChatColor.DARK_BLUE + "Dark Blue").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_BLUE + "dark blue" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_BLUE");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_BLUE +
                            "Dark Blue" + ChatColor.YELLOW + "!"
            );
        }));

        // Dark Gray
        addItem(5, new Icon(Material.GRAY_CONCRETE).setName(ChatColor.DARK_GRAY + "Dark Gray").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_GRAY + "dark gray" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GRAY");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_GRAY +
                            "Dark Gray" + ChatColor.YELLOW + "!"
            );
        }));

        // Dark Green
        addItem(6, new Icon(Material.GREEN_CONCRETE).setName(ChatColor.DARK_GREEN + "Dark Green").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_GREEN + "dark green" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_GREEN");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_GREEN +
                            "Dark Green" + ChatColor.YELLOW + "!"
            );
        }));

        // Purple
        addItem(7, new Icon(Material.PURPLE_CONCRETE).setName(ChatColor.DARK_PURPLE + "Purple").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_PURPLE + "purple" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_PURPLE");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_PURPLE +
                            "Dark Purple" + ChatColor.YELLOW + "!"
            );
        }));

        // Dark Red
        addItem(8, new Icon(Material.RED_CONCRETE).setName(ChatColor.DARK_RED + "Dark Red").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.DARK_RED + "dark red" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "DARK_RED");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.DARK_RED +
                            "Dark Red" + ChatColor.YELLOW + "!"
            );
        }));

        // Gold
        addItem(9, new Icon(Material.GOLD_BLOCK).setName(ChatColor.GOLD + "Gold").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.GOLD + "gold" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GOLD");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.GOLD +
                            "Gold" + ChatColor.YELLOW + "!"
            );
        }));

        // Gray
        addItem(10, new Icon(Material.LIGHT_GRAY_CONCRETE).setName(ChatColor.GRAY + "Gray").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.GRAY + "gray" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GRAY");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.GRAY +
                            "Gray" + ChatColor.YELLOW + "!"
            );
        }));

        // Green
        addItem(11, new Icon(Material.LIME_CONCRETE).setName(ChatColor.GREEN + "Green").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.GREEN + "green" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "GREEN");
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.GREEN +
                            "Green" + ChatColor.YELLOW + "!"
            );
        }));

        // Pink
        addItem(12, new Icon(Material.PINK_CONCRETE).setName(ChatColor.LIGHT_PURPLE + "Pink").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.LIGHT_PURPLE + "pink" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "LIGHT_PURPLE");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.LIGHT_PURPLE +
                            "Pink" + ChatColor.YELLOW + "!"
            );
        }));

        // Red
        addItem(13, new Icon(Material.RED_WOOL).setName(ChatColor.RED + "Red").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.RED + "red" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "RED");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.RED +
                            "Red" + ChatColor.YELLOW + "!"
            );
        }));

        // White
        addItem(14, new Icon(Material.WHITE_CONCRETE).setName(ChatColor.WHITE + "White").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.WHITE + "white" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "WHITE");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.WHITE +
                            "White" + ChatColor.YELLOW + "!"
            );
        }));

        // Yellow
        addItem(15, new Icon(Material.YELLOW_CONCRETE).setName(ChatColor.YELLOW + "Yellow").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to change to " + ChatColor.YELLOW + "yellow" + ChatColor.YELLOW + "!"
        )).onClick(e -> {
            data.set(new NamespacedKey(instance, "chatcolor"), PersistentDataType.STRING, "YELLOW");
            e.getWhoClicked().closeInventory();
            player.sendMessage(
                    PREFIX + ChatColor.YELLOW + "You have set your chat color to " + ChatColor.YELLOW +
                            "Yellow" + ChatColor.YELLOW + "!"
            );
        }));

        addItem(31, new Icon(Material.BARRIER).setName(ChatColor.RED + "Close Menu").setLore(List.of(
                "",
                ChatColor.YELLOW + "Click to close the menu!"
        )).onClick(e -> e.getWhoClicked().closeInventory()));
    }

}
