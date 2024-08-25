package com.ytdd9527.networksexpansion.implementation.items.machines.autocrafters.advanced;

import com.ytdd9527.networksexpansion.api.helpers.SupportedEnhancedCraftingTableRecipes;
import com.ytdd9527.networksexpansion.core.items.machines.AbstractAdvancedAutoCrafter;
import io.github.sefiraat.networks.slimefun.tools.CraftingBlueprint;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Set;

public class AdvancedAutoEnhancedCraftingTableCrafter extends AbstractAdvancedAutoCrafter {
    public AdvancedAutoEnhancedCraftingTableCrafter(
            ItemGroup itemGroup,
            SlimefunItemStack item,
            RecipeType recipeType,
            ItemStack[] recipe,
            int chargePerCraft,
            boolean withholding
    ) {
        super(itemGroup, item, recipeType, recipe, chargePerCraft, withholding);
    }

    public Set<Map.Entry<ItemStack[], ItemStack>> getRecipeEntries() {
        return SupportedEnhancedCraftingTableRecipes.getRecipes().entrySet();
    }

    public boolean getRecipeTester(ItemStack[] inputs, ItemStack[] recipe) {
        return SupportedEnhancedCraftingTableRecipes.testRecipe(inputs, recipe);
    }

    public boolean isVaildBlueprint(SlimefunItem item) {
        return item instanceof CraftingBlueprint;
    }
}
