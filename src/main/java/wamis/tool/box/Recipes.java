package wamis.tool.box;

import btw.block.BTWBlocks;
import btw.item.BTWItems;
import btw.crafting.recipe.RecipeManager;
import net.minecraft.src.*;


public class Recipes {

    public static void initRecipes(){

        replaceSinewRecipe();
    }


    public static void replaceSinewRecipe(){
        Item[] sinewMeats = {
            Item.porkRaw,
            Item.porkCooked,
            Item.beefRaw,
            Item.beefCooked,
            Item.chickenRaw,
            Item.chickenCooked,
            BTWItems.rawMutton,
            BTWItems.cookedMutton,
            BTWItems.rawWolfChop,
            BTWItems.cookedWolfChop,
            BTWItems.rawMysteryMeat,
            BTWItems.cookedMysteryMeat
        };
        
        Item[] sinewChisels = {
                BTWItems.sharpStone,
                BTWItems.ironChisel,
                BTWItems.diamondChisel
        };
    
        for (Item meat : sinewMeats) {
            for (Item chisel : sinewChisels) {
                RecipeManager.removeVanillaShapelessRecipe(new ItemStack(BTWItems.sinew), new Object[]{
                        new ItemStack(meat),
                        new ItemStack(chisel)
                });

                RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.sinew), new Object[]{
                    new ItemStack(meat),
                    new ItemStack(meat),
                    new ItemStack(chisel)
                });
            }
        }
    }
    
}
