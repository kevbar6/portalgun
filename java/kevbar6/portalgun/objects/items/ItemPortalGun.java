
package kevbar6.portalgun.objects.items;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.commands.CommandTeleportDimension;
import kevbar6.portalgun.commands.util.CustomTeleporter;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.command.CommandException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
            MinecraftServer server = worldIn.getMinecraftServer();
            World world = server.getWorld(dimension);
            int i = 0;
            BlockPos blockPos = playerIn.getPosition();
            boolean a = true;
            while (i < 255 && a){
                i++;
                System.out.println(i);
                if (world.getBlockState(new BlockPos(playerIn.getPosition().getX(), i, playerIn.getPosition().getZ())).equals(Blocks.AIR.getDefaultState()) && world.getBlockState(new BlockPos(playerIn.getPosition().getX(), i + 1, playerIn.getPosition().getZ())).equals(Blocks.AIR.getDefaultState())&& world.getBlockState(new BlockPos(playerIn.getPosition().getX(), i + 2, playerIn.getPosition().getZ())).equals(Blocks.AIR.getDefaultState())){
                    a = false;
                    world.setBlockState(new BlockPos(playerIn.getPosition().getX(), i, playerIn.getPosition().getZ()), Blocks.GLOWSTONE.getDefaultState());
                    CustomTeleporter.teleportToDimension((EntityPlayer) playerIn, dimension, playerIn.getPosition().getX(), i + 1, playerIn.getPosition().getZ());
                    playerIn.getCooldownTracker().setCooldown(this, 100);
                }
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
