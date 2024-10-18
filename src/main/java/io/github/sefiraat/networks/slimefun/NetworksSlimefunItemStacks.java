package io.github.sefiraat.networks.slimefun;

import com.balugaq.netex.utils.NetworksVersionedEnchantment;
import com.ytdd9527.networksexpansion.utils.TextUtil;
import com.ytdd9527.networksexpansion.utils.itemstacks.ItemStackUtil;
import io.github.sefiraat.networks.Networks;
import io.github.sefiraat.networks.slimefun.network.NetworkQuantumStorage;
import io.github.sefiraat.networks.slimefun.tools.NetworkRemote;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.text.MessageFormat;

/**
 * Creating SlimefunItemStacks here due to some items being created in Enums so this will
 * act as a one-stop-shop for the stacks themselves.
 */
@UtilityClass
public class NetworksSlimefunItemStacks {

    // Materials
    public static final SlimefunItemStack SYNTHETIC_EMERALD_SHARD;
    public static final SlimefunItemStack OPTIC_GLASS;
    public static final SlimefunItemStack OPTIC_CABLE;
    public static final SlimefunItemStack OPTIC_STAR;
    public static final SlimefunItemStack RADIOACTIVE_OPTIC_STAR;
    public static final SlimefunItemStack SHRINKING_BASE;
    public static final SlimefunItemStack SIMPLE_NANOBOTS;
    public static final SlimefunItemStack ADVANCED_NANOBOTS;
    public static final SlimefunItemStack AI_CORE;
    public static final SlimefunItemStack EMPOWERED_AI_CORE;
    public static final SlimefunItemStack PRISTINE_AI_CORE;
    public static final SlimefunItemStack INTERDIMENSIONAL_PRESENCE;

    // Network Items
    public static final SlimefunItemStack NETWORK_CONTROLLER;
    public static final SlimefunItemStack NETWORK_BRIDGE;
    public static final SlimefunItemStack NETWORK_MONITOR;
    public static final SlimefunItemStack NETWORK_IMPORT;
    public static final SlimefunItemStack NETWORK_EXPORT;
    public static final SlimefunItemStack NETWORK_GRABBER;
    public static final SlimefunItemStack NETWORK_PUSHER;
    public static final SlimefunItemStack NETWORK_MORE_PUSHER;
    public static final SlimefunItemStack NETWORK_BEST_PUSHER;
    public static final SlimefunItemStack NETWORK_CONTROL_X;
    public static final SlimefunItemStack NETWORK_CONTROL_V;
    public static final SlimefunItemStack NETWORK_VACUUM;
    public static final SlimefunItemStack NETWORK_VANILLA_GRABBER;
    public static final SlimefunItemStack NETWORK_VANILLA_PUSHER;
    public static final SlimefunItemStack NETWORK_WIRELESS_TRANSMITTER;
    public static final SlimefunItemStack NETWORK_WIRELESS_RECEIVER;
    public static final SlimefunItemStack NETWORK_PURGER;
    public static final SlimefunItemStack NETWORK_GRID;
    public static final SlimefunItemStack NETWORK_CRAFTING_GRID;
    public static final SlimefunItemStack NETWORK_CELL;
    public static final SlimefunItemStack NETWORK_GREEDY_BLOCK;
    public static final SlimefunItemStack NETWORK_QUANTUM_WORKBENCH;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_0;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_1;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_2;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_3;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_4;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_5;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_6;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_7;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_8;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_9;
    public static final SlimefunItemStack NETWORK_QUANTUM_STORAGE_10;
    public static final SlimefunItemStack NETWORK_CAPACITOR_1;
    public static final SlimefunItemStack NETWORK_CAPACITOR_2;
    public static final SlimefunItemStack NETWORK_CAPACITOR_3;
    public static final SlimefunItemStack NETWORK_CAPACITOR_4;
    public static final SlimefunItemStack NETWORK_POWER_OUTLET_1;
    public static final SlimefunItemStack NETWORK_POWER_OUTLET_2;
    public static final SlimefunItemStack NETWORK_POWER_DISPLAY;
    public static final SlimefunItemStack NETWORK_RECIPE_ENCODER;
    public static final SlimefunItemStack NETWORK_AUTO_CRAFTER;
    public static final SlimefunItemStack NETWORK_AUTO_CRAFTER_WITHHOLDING;

    // Tools
    public static final SlimefunItemStack CRAFTING_BLUEPRINT;
    public static final SlimefunItemStack NETWORK_PROBE;
    public static final SlimefunItemStack NETWORK_REMOTE;
    public static final SlimefunItemStack NETWORK_REMOTE_EMPOWERED;
    public static final SlimefunItemStack NETWORK_REMOTE_PRISTINE;
    public static final SlimefunItemStack NETWORK_REMOTE_ULTIMATE;
    public static final SlimefunItemStack NETWORK_CRAYON;
    public static final SlimefunItemStack NETWORK_CONFIGURATOR;
    public static final SlimefunItemStack NETWORK_WIRELESS_CONFIGURATOR;
    public static final SlimefunItemStack NETWORK_RAKE_1;
    public static final SlimefunItemStack NETWORK_RAKE_2;
    public static final SlimefunItemStack NETWORK_RAKE_3;
    public static final SlimefunItemStack NETWORK_DEBUG_STICK;

    static {

        SYNTHETIC_EMERALD_SHARD = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_SYNTHETIC_EMERALD_SHARD",
                        new ItemStack(Material.LIME_DYE)
                ),
                Theme.CRAFTING
        );

        OPTIC_GLASS = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_OPTIC_GLASS",
                        new ItemStack(Material.GLASS)
                ),
                Theme.CRAFTING
        );

        OPTIC_CABLE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_OPTIC_CABLE",
                        new ItemStack(Material.STRING)
                ),
                Theme.CRAFTING
        );

        OPTIC_STAR = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_OPTIC_STAR",
                        new ItemStack(Material.NETHER_STAR)
                ),
                Theme.CRAFTING
        );

        RADIOACTIVE_OPTIC_STAR = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_RADIOACTIVE_OPTIC_STAR",
                        ItemStackUtil.getPreEnchantedItemStack(Material.NETHER_STAR, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.CRAFTING
        );

        SHRINKING_BASE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_SHRINKING_BASE",
                        ItemStackUtil.getPreEnchantedItemStack(Material.PISTON, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.CRAFTING
        );

        SIMPLE_NANOBOTS = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_SIMPLE_NANOBOTS",
                        new ItemStack(Material.MELON_SEEDS)
                ),
                Theme.CRAFTING
        );

        ADVANCED_NANOBOTS = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_ADVANCED_NANOBOTS",
                        ItemStackUtil.getPreEnchantedItemStack(Material.MELON_SEEDS, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.CRAFTING
        );

        AI_CORE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_AI_CORE",
                        new ItemStack(Material.BRAIN_CORAL_BLOCK)
                ),
                Theme.CRAFTING
        );

        EMPOWERED_AI_CORE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_EMPOWERED_AI_CORE",
                        new ItemStack(Material.TUBE_CORAL_BLOCK)
                ),
                Theme.CRAFTING
        );

        PRISTINE_AI_CORE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_PRISTINE_AI_CORE",
                        ItemStackUtil.getPreEnchantedItemStack(Material.TUBE_CORAL_BLOCK, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.CRAFTING
        );

        INTERDIMENSIONAL_PRESENCE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_INTERDIMENSIONAL_PRESENCE",
                        ItemStackUtil.getPreEnchantedItemStack(Material.ARMOR_STAND, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.CRAFTING
        );

        NETWORK_CONTROLLER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CONTROLLER",
                        new ItemStack(Material.BLACK_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_BRIDGE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_BRIDGE",
                        new ItemStack(Material.WHITE_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_MONITOR = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_MONITOR",
                        new ItemStack(Material.GREEN_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_IMPORT = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_IMPORT",
                        new ItemStack(Material.RED_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_EXPORT = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_EXPORT",
                        new ItemStack(Material.BLUE_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_GRABBER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_GRABBER",
                        new ItemStack(Material.MAGENTA_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_PUSHER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_PUSHER",
                        new ItemStack(Material.BROWN_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_MORE_PUSHER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_MOREPUSHER",
                        new ItemStack(Material.BROWN_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_BEST_PUSHER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_BESTPUSHER",
                        new ItemStack(Material.BROWN_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_CONTROL_X = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CONTROL_X",
                        new ItemStack(Material.WHITE_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_CONTROL_V = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CONTROL_V",
                        new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_VACUUM = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_VACUUM",
                        new ItemStack(Material.ORANGE_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_VANILLA_GRABBER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_VANILLA_GRABBER",
                        new ItemStack(Material.ORANGE_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_VANILLA_PUSHER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_VANILLA_PUSHER",
                        new ItemStack(Material.LIME_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_WIRELESS_TRANSMITTER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_NETWORK_WIRELESS_TRANSMITTER",
                        new ItemStack(Material.CYAN_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_WIRELESS_RECEIVER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_NETWORK_WIRELESS_RECEIVER",
                        new ItemStack(Material.PURPLE_STAINED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_PURGER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_TRASH",
                        new ItemStack(Material.OBSERVER)
                ),
                Theme.MACHINE
        );

        NETWORK_GRID = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_GRID",
                        new ItemStack(Material.NOTE_BLOCK)
                ),
                Theme.MACHINE
        );

        NETWORK_CRAFTING_GRID = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CRAFTING_GRID",
                        new ItemStack(Material.REDSTONE_LAMP)
                ),
                Theme.MACHINE
        );

        NETWORK_CELL = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CELL",
                        new ItemStack(Material.HONEYCOMB_BLOCK)
                ),
                Theme.MACHINE
        );

        NETWORK_GREEDY_BLOCK = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_GREEDY_BLOCK",
                        new ItemStack(Material.SHROOMLIGHT)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_WORKBENCH = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_WORKBENCH",
                        new ItemStack(Material.DRIED_KELP_BLOCK)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_0 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_0",
                        new ItemStack(Material.ORANGE_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_9 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_9",
                        new ItemStack(Material.YELLOW_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_10 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_10",
                        new ItemStack(Material.LIME_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_1 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_1",
                        new ItemStack(Material.WHITE_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_2 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_2",
                        new ItemStack(Material.LIGHT_GRAY_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_3 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_3",
                        new ItemStack(Material.GRAY_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_4 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_4",
                        new ItemStack(Material.BROWN_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_5 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_5",
                        new ItemStack(Material.BLACK_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_6 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_6",
                        new ItemStack(Material.PURPLE_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_7 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_7",
                        new ItemStack(Material.MAGENTA_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_QUANTUM_STORAGE_8 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_QUANTUM_STORAGE_8",
                        new ItemStack(Material.RED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_CAPACITOR_1 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CAPACITOR_1",
                        new ItemStack(Material.BROWN_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_CAPACITOR_2 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CAPACITOR_2",
                        new ItemStack(Material.GREEN_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_CAPACITOR_3 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CAPACITOR_3",
                        new ItemStack(Material.BLACK_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_CAPACITOR_4 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CAPACITOR_4",
                        new ItemStack(Material.GRAY_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_POWER_OUTLET_1 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_POWER_OUTLET_1",
                        new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_POWER_OUTLET_2 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_POWER_OUTLET_2",
                        new ItemStack(Material.RED_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_POWER_DISPLAY = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_POWER_DISPLAY",
                        new ItemStack(Material.TINTED_GLASS)
                ),
                Theme.MACHINE
        );

        NETWORK_RECIPE_ENCODER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_RECIPE_ENCODER",
                        new ItemStack(Material.TARGET)
                ),
                Theme.MACHINE
        );

        NETWORK_AUTO_CRAFTER = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_AUTO_CRAFTER",
                        new ItemStack(Material.BLACK_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        NETWORK_AUTO_CRAFTER_WITHHOLDING = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_AUTO_CRAFTER_WITHHOLDING",
                        new ItemStack(Material.WHITE_GLAZED_TERRACOTTA)
                ),
                Theme.MACHINE
        );

        CRAFTING_BLUEPRINT = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CRAFTING_BLUEPRINT",
                        new ItemStack(Material.BLUE_DYE)
                ),
                Theme.TOOL
        );

        NETWORK_PROBE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_PROBE",
                        new ItemStack(Material.CLOCK)
                ),
                Theme.TOOL
        );

        NETWORK_REMOTE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_REMOTE",
                        new ItemStack(Material.PAINTING)
                ),
                Theme.TOOL
        );

        NETWORK_REMOTE_EMPOWERED = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_REMOTE_EMPOWERED",
                        new ItemStack(Material.ITEM_FRAME)
                ),
                Theme.TOOL
        );

        NETWORK_REMOTE_PRISTINE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_REMOTE_PRISTINE",
                        new ItemStack(Material.GLOW_ITEM_FRAME)
                ),
                Theme.TOOL
        );

        NETWORK_REMOTE_ULTIMATE = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_REMOTE_ULTIMATE",
                        ItemStackUtil.getPreEnchantedItemStack(Material.GLOW_ITEM_FRAME, true, new Pair<>(NetworksVersionedEnchantment.GLOW, 1))
                ),
                Theme.TOOL
        );

        NETWORK_CRAYON = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CRAYON",
                        new ItemStack(Material.RED_CANDLE)
                ),
                Theme.TOOL
        );

        NETWORK_CONFIGURATOR = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_CONFIGURATOR",
                        new ItemStack(Material.BLAZE_ROD)
                ),
                Theme.TOOL
        );

        NETWORK_WIRELESS_CONFIGURATOR = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_WIRELESS_CONFIGURATOR",
                        new ItemStack(Material.BLAZE_ROD)
                ),
                Theme.TOOL
        );

        NETWORK_RAKE_1 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_RAKE_1",
                        new ItemStack(Material.TWISTING_VINES),
                        LoreBuilder.usesLeft(250)
                ),
                Theme.TOOL
        );

        NETWORK_RAKE_2 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_RAKE_2",
                        new ItemStack(Material.WEEPING_VINES),
                        LoreBuilder.usesLeft(1000)
                ),
                Theme.TOOL
        );

        NETWORK_RAKE_3 = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_RAKE_3",
                        ItemStackUtil.getPreEnchantedItemStack(Material.WEEPING_VINES, true, new Pair<>(NetworksVersionedEnchantment.LUCK_OF_THE_SEA, 1)),
                        LoreBuilder.usesLeft(9999)
                ),
                Theme.TOOL
        );

        NETWORK_DEBUG_STICK = Theme.themedSlimefunItemStack(
                Networks.getLocalizationService().getItem(
                        "NTW_DEBUG_STICK",
                        ItemStackUtil.getPreEnchantedItemStack(Material.STICK, true, new Pair<>(NetworksVersionedEnchantment.LUCK_OF_THE_SEA, 1))
                ),
                Theme.TOOL
        );
    }


}
