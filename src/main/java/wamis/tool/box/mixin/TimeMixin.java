package wamis.tool.box.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.src.WorldServer;
import net.minecraft.src.World;
import net.minecraft.src.WorldProvider;
import btw.world.util.difficulty.Difficulty;
import wamis.tool.box.WamisToolBox;
import net.minecraft.src.*;

@Mixin(WorldServer.class)
abstract public class TimeMixin extends World{

    public TimeMixin(ISaveHandler sav,String str,WorldProvider wpr,WorldSettings wst,Profiler prof,ILogAgent ilag){
        super(sav, str, wpr, wst, prof, ilag);
    }

    //CREDIT TO .arminias FOR HELPING ME SO MUCH WITH THIS (i did edit it a bunch though!)
    int timeIncreaseIndex = 0;
    @Redirect(method = "Lnet/minecraft/src/WorldServer;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/WorldInfo;setWorldTime(J)V"))
    public void setWorldTimeRedirect(WorldInfo win, long par1){

        try{
            if(WamisToolBox.isSuperRelaxed(worldInfo.getDifficulty())){

                timeIncreaseIndex += 1;
                timeIncreaseIndex = timeIncreaseIndex % 4;

                // Make it slower (probability based) at day, faster at night
                int timeOfDay = (int)(worldInfo.getWorldTime() % 24000L);
                
                if (timeOfDay > 14000 && timeOfDay < 22000) {
                    // night
                    System.out.println("TIME HAS CHANGED AT NIGHT! " + timeOfDay);
                    if (timeIncreaseIndex != 1) {
                        worldInfo.setWorldTime(worldInfo.getWorldTime() + 2L);
                    } else {
                        worldInfo.setWorldTime(worldInfo.getWorldTime() + 1L);
                    }
                }
                else if (timeIncreaseIndex != 1) {
                    System.out.println("TIME HAS CHANGED AT DAY! " + timeOfDay);
                    worldInfo.setWorldTime(worldInfo.getWorldTime() + 1L);
                }
            }else{
                worldInfo.setWorldTime(worldInfo.getWorldTime() + 1L);
            }
        }catch(Exception e) {

        }


        //worldInfo.setWorldTime(worldInfo.getWorldTime() + 2L);
    }

}