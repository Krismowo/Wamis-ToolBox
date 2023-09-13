package wamis.tool.box;

import btw.AddonHandler;
import net.fabricmc.api.ModInitializer;
import btw.world.util.difficulty.Difficulty;
import wamis.tool.box.DifficultyInterface;
import java.util.logging.Logger;

public class WamisToolBox implements ModInitializer {
	public static final Difficulty SUPERRELAXED = new SuperRelaxedDifficulty("suprelaxed");
	
	// That way, it's clear which mod wrote info, warnings, and errors.
	// public static final Logger LOGGER = Logger.getLogger("modid");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		AddonHandler.logMessage("Hello Fabric world!");
	}

	public static boolean isSuperRelaxed(Difficulty dif){
		boolean ret = false;
		try{
			return ((DifficultyInterface) dif).isSuperRel();
		} catch(Exception e){
			return false;
		}
		/*try {
            if(((DifficultyInterface) worldInfo.getDifficulty()).isSuperRel()){ 
                cir.setReturnValue(0f);
                //cir.setReturnValue(0f);
            }
        }catch(Exception e) {
            cir.setReturnValue(provider.calculateCelestialAngle(worldInfo.getWorldTime(), par1));
        }*/
	}

}
