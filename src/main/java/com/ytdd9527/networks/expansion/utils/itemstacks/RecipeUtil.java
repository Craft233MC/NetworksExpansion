package com.ytdd9527.networks.expansion.utils.itemstacks;

import com.ytdd9527.networks.expansion.core.data.RandomMachineRecipe;
import com.ytdd9527.networks.expansion.core.data.attributes.WorkingRecipe;
import com.ytdd9527.networks.expansion.core.interfaces.RecipeItem;
import com.ytdd9527.networks.expansion.core.items.unusable.ReplaceableCard;
import com.ytdd9527.networks.expansion.utils.ReflectionUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.Composter;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.Crucible;
import io.github.thebusybiscuit.slimefun4.implementation.items.tools.GoldPan;
import io.github.thebusybiscuit.slimefun4.implementation.items.tools.NetherGoldPan;
import io.github.thebusybiscuit.slimefun4.implementation.settings.GoldPanDrop;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Final_ROOT
 * @since 2.0
 */
public class RecipeUtil {
    public static void registerRecipeBySlimefunId(@Nonnull RecipeItem recipeItem, @Nonnull String slimefunId) {
        final SlimefunItem slimefunItem = SlimefunItem.getById(slimefunId);
        try {

            if (slimefunItem instanceof Composter || slimefunItem instanceof Crucible) {
                List<ItemStack> displayRecipes = ((RecipeDisplayItem) slimefunItem).getDisplayRecipes();
                RecipeUtil.registerRecipeBySimpleDisplayRecipe(recipeItem, displayRecipes);
                return;
            }

            Method method = ReflectionUtil.getMethod(slimefunItem.getClass(), "getMachineRecipes");
            if (method != null && method.getReturnType().equals(List.class)) {
                method.setAccessible(true);
                List<MachineRecipe> recipes = (List<MachineRecipe>) method.invoke(slimefunItem);
                if (recipes != null) {
                    for (MachineRecipe recipe : recipes) {
                        boolean disabled = false;
                        for (ItemStack itemStack : recipe.getOutput()) {
                            SlimefunItem sfItem = SlimefunItem.getByItem(itemStack);
                            if (sfItem != null && sfItem.isDisabled()) {
                                disabled = true;
                                break;
                            }
                        }
                        if (!disabled) {
                            recipeItem.registerRecipeInCard(0, recipe.getInput(), recipe.getOutput());
                        }
                    }
                }
                return;
            }

            method = ReflectionUtil.getMethod(slimefunItem.getClass(), "getRecipes");
            if (method != null) {
                method.setAccessible(true);
                List<ItemStack[]> recipes = (List<ItemStack[]>) method.invoke(slimefunItem);
                if (recipes != null) {
                    for (int i = 0; i * 2 + 1 < recipes.size(); i++) {
                        ItemStack[] inputs = recipes.get(i * 2);
                        ItemStack[] outputs = recipes.get(i * 2 + 1);

                        boolean disabled = false;
                        for (ItemStack itemStack : outputs) {
                            SlimefunItem sfItem = SlimefunItem.getByItem(itemStack);
                            if (sfItem != null && sfItem.isDisabled()) {
                                disabled = true;
                                break;
                            }
                        }

                        if (!disabled) {
                            recipeItem.registerRecipeInCard(0, inputs, outputs);
                        }
                    }
                }
                return;
            }

            if (slimefunItem instanceof RecipeDisplayItem) {
                List<ItemStack> displayRecipes = ((RecipeDisplayItem) slimefunItem).getDisplayRecipes();
                RecipeUtil.registerRecipeBySimpleDisplayRecipe(recipeItem, displayRecipes);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            recipeItem.clearRecipe();
            if (slimefunItem instanceof RecipeDisplayItem) {
                List<ItemStack> displayRecipes = ((RecipeDisplayItem) slimefunItem).getDisplayRecipes();
                RecipeUtil.registerRecipeBySimpleDisplayRecipe(recipeItem, displayRecipes);
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void registerRecipeByRecipeType(@Nonnull RecipeItem recipeItem, @Nonnull RecipeType recipeType) {
        List<SlimefunItem> list = Slimefun.getRegistry().getEnabledSlimefunItems();
        for (SlimefunItem slimefunItem : list) {
            if (!slimefunItem.isDisabled() && recipeType.equals(slimefunItem.getRecipeType())) {
                recipeItem.registerRecipeInCard(0, slimefunItem);
            }
        }
    }

    public static void registerRecipeBySimpleDisplayRecipe(@Nonnull RecipeItem recipeItem, List<ItemStack> displayRecipes) {
        for (int i = 0; i < displayRecipes.size(); i += 2) {
            boolean disabled = false;
            ItemStack itemStack = displayRecipes.get(i + 1);
            SlimefunItem sfItem = SlimefunItem.getByItem(itemStack);
            if (sfItem != null) {
                disabled = sfItem.isDisabled();
            }
            if (!disabled) {
                recipeItem.registerRecipeInCard(0, new ItemStack[]{displayRecipes.get(i)}, new ItemStack[]{displayRecipes.get(i + 1)});
            }
        }
    }


    public static void registerGoldPan(@Nonnull RecipeItem recipeItem) {
        GoldPan goldPan = SlimefunItems.GOLD_PAN.getItem(GoldPan.class);
        try {
            Field field = ReflectionUtil.getField(goldPan.getClass(), "drops");
            field.setAccessible(true);
            Set<GoldPanDrop> goldPanDrops = (Set<GoldPanDrop>) field.get(goldPan);
            List<RandomMachineRecipe.RandomOutput> randomOutputList = new ArrayList<>(goldPanDrops.size());
            for (GoldPanDrop goldPanDrop : goldPanDrops) {
                randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{goldPanDrop.getOutput()}, goldPanDrop.getValue()));
            }
            recipeItem.registerRecipe(new RandomMachineRecipe(new ItemStack[]{new ItemStack(goldPan.getInputMaterial())}, randomOutputList));
        } catch (Exception e) {
            e.printStackTrace();
            List<RandomMachineRecipe.RandomOutput> randomOutputList = new ArrayList<>();
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.FLINT)}, 40));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.CLAY_BALL)}, 20));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{SlimefunItems.SIFTED_ORE}, 35));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.IRON_NUGGET)}, 5));
            recipeItem.registerRecipe(new RandomMachineRecipe(new ItemStack[]{new ItemStack(goldPan.getInputMaterial())}, randomOutputList));
        }
    }

    public static void registerNetherGoldPan(@Nonnull RecipeItem recipeItem) {
        NetherGoldPan netherGoldPan = SlimefunItems.NETHER_GOLD_PAN.getItem(NetherGoldPan.class);
        try {
            Field field = ReflectionUtil.getField(netherGoldPan.getClass(), "drops");
            field.setAccessible(true);
            Set<GoldPanDrop> goldPanDrops = (Set<GoldPanDrop>) field.get(netherGoldPan);
            List<RandomMachineRecipe.RandomOutput> randomOutputList = new ArrayList<>(goldPanDrops.size());
            for (GoldPanDrop goldPanDrop : goldPanDrops) {
                randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{goldPanDrop.getOutput()}, goldPanDrop.getValue()));
            }
            recipeItem.registerRecipe(new RandomMachineRecipe(new ItemStack[]{new ItemStack(netherGoldPan.getInputMaterial())}, randomOutputList));
        } catch (Exception e) {
            e.printStackTrace();
            List<RandomMachineRecipe.RandomOutput> randomOutputList = new ArrayList<>();
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.FLINT)}, 40));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.CLAY_BALL)}, 20));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{SlimefunItems.SIFTED_ORE}, 35));
            randomOutputList.add(new RandomMachineRecipe.RandomOutput(new ItemStack[]{new ItemStack(Material.IRON_NUGGET)}, 5));
            recipeItem.registerRecipe(new RandomMachineRecipe(new ItemStack[]{new ItemStack(netherGoldPan.getInputMaterial())}, randomOutputList));
        }
    }

    /**
     * @return The #{@link ReplaceableCard} in #{@link ItemStack}
     */
    @Nullable
    public static ReplaceableCard getReplaceableCard(@Nullable ItemStack itemStack) {
        if (ItemStackUtil.isItemNull(itemStack) || ReplaceableCard.getByMaterial(itemStack.getType()) == null) {
            return null;
        }
        if (!ItemStackUtil.isItemSimilar(itemStack, new ItemStack(itemStack.getType()))) {
            return null;
        }
        return ReplaceableCard.getByMaterial(itemStack.getType());
    }

    public static int getCraftLevel(Map<ItemStack, Long> allItems, WorkingRecipe recipe, int maxAmount) {
        int maxCraftable = Integer.MAX_VALUE;

        // 计算可以合成的最大数量，并更新allItems
        for (Map.Entry<ItemStack, Integer> entry : recipe.getInputs().entrySet()) {
            ItemStack item = entry.getKey();
            int requiredAmount = entry.getValue();
            long availableAmount = allItems.getOrDefault(item, 0L);

            // 计算可以合成的最大数量
            if (requiredAmount <= 0) {
                continue;
            }
            long canCraft = availableAmount / requiredAmount;
            if (canCraft == 0) {
                // 如果无法合成任何一个recipe，直接返回
                return 0;
            }
            maxCraftable = (int) Math.min(maxCraftable, canCraft);
        }

        maxCraftable = Math.min(maxCraftable, maxAmount);
        return maxCraftable;
    }

    public static Map<ItemStack, Integer> getCraftOutputs(Map<ItemStack, Long> allItems, WorkingRecipe recipe, int maxCraftable) {
        if (maxCraftable == 0) {
            return new HashMap<>();
        }

        // 更新allItems，减去用于合成的物品数量，并增加合成的结果物品数量
        for (Map.Entry<ItemStack, Integer> entry : recipe.getInputs().entrySet()) {
            ItemStack item = entry.getKey();
            int requiredAmount = entry.getValue();
            allItems.put(item, allItems.get(item) - requiredAmount * maxCraftable);
        }
        Map<ItemStack, Integer> outputItem = recipe.outputItems();
        Map<ItemStack, Integer> outputs = new HashMap<>();
        for (Map.Entry<ItemStack, Integer> entry : outputItem.entrySet()) {
            outputs.put(entry.getKey(), entry.getValue() * maxCraftable);
        }
        return outputs;
    }
}
