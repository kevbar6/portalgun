package kevbar6.portalgun.tabs;

import kevbar6.portalgun.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PortalTab extends CreativeTabs {

    public PortalTab(String label) {
        super("portaltab");
        this.setBackgroundImageName("portal.png");
    }
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.PORTALGUN);
    }
}
