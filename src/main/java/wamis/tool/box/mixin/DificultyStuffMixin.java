package wamis.tool.box.mixin;

import btw.world.util.difficulty.Difficulty;
import wamis.tool.box.DifficultyInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Difficulty.class)
public abstract class DificultyStuffMixin extends Difficulty implements DifficultyInterface {
	protected DificultyStuffMixin(String blockID) {
		super(blockID);
	}
	
	@Override
	public boolean isSuperRel() {
		return false;
	}
}