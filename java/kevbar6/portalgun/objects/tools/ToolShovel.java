package kevbar6.portalgun.objects.tools;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade implements IHasModel {
    public ToolShovel(String name, ToolMaterial material) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.portaltab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

