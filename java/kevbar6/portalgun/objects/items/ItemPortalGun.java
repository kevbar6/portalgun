
package kevbar6.portalgun.objects.items;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.commands.util.CustomTeleporter;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.Timer;

public class ItemPortalGun extends Item implements IHasModel {
    int dimension;
    public ItemPortalGun(String name, int dim) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(Main.portaltab);
        ItemInit.ITEMS.add(this);
        dimension = dim;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            if (playerIn.getPosition().getY() < 255) {
                CustomTeleporter.teleportToDimension((EntityPlayer) playerIn, dimension, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());

            }
            playerIn.getCooldownTracker().setCooldown(this, 100);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}