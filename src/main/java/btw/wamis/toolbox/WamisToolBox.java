package btw.wamis.toolbox;

import btw.AddonHandler;
import btw.BTWAddon;
import wamis.tool.box.Recipes;
import wamis.tool.box.Items;

public class WamisToolBox extends BTWAddon {
    public static WamisToolBox instance;

    private WamisToolBox() {
        super("Wami's Toolbox!", "0.1.0", "WTB");
    }

    @Override
    public void initialize() {
        Items.initItems();
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }

    public static WamisToolBox getInstance() {
        if (instance == null)
            instance = new WamisToolBox();
        return instance;
    }

    @Override
    public void postInitialize() {
		Recipes.initRecipes();
    }
}
