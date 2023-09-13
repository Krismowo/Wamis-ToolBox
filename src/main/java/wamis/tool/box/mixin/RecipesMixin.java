package wamis.tool.box.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import btw.crafting.recipe.CraftingRecipeList;
import btw.item.BTWItems;
import net.minecraft.src.*;

@Mixin(CraftingRecipeList.class)
public class RecipesMixin {

    /*@Inject(method = "Vbtw/crafting/recipe/CraftingRecipeList;addAlternateVanillaRecipes()", at = @At("HEAD"), cancellable = true)
    private static void addRecipes(CallbackInfo info){
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
            RecipeManager.addShapelessRecipe(new ItemStack(BTWItems.sinew), new Object[]{
                    new ItemStack(meat),
                    new ItemStack(chisel)
            });
        }
    }
    }*/
}
