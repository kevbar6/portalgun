package kevbar6.portalgun.objects.items;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Timer;

/**Kommentare beziehen sich immer auf die Zeile über ihnen**/

public class ItemPortalGun extends Item implements IHasModel {
    public ItemPortalGun(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(Main.portaltab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            Timer timer = new Timer();
            BlockPos pos = null;

            if (Objects.equals("north", playerIn.getHorizontalFacing().toString()) && playerIn.getPosition().getY() < 256 && playerIn.getPosition().getY() > 0) {
                pos = playerIn.getPosition().north(3);
                worldIn.setBlockState(pos, Blocks.PORTAL.getDefaultState());
            }
            if (Objects.equals("east", playerIn.getHorizontalFacing().toString()) && playerIn.getPosition().getY() < 256 && playerIn.getPosition().getY() > 0) {
                pos = playerIn.getPosition().east(3);
                worldIn.setBlockState(pos, Blocks.PORTAL.getDefaultState().withRotation(Rotation.CLOCKWISE_90));
            }
            if (Objects.equals("south", playerIn.getHorizontalFacing().toString()) && playerIn.getPosition().getY() < 256 && playerIn.getPosition().getY() > 0) {
                pos = playerIn.getPosition().south(3);
                worldIn.setBlockState(pos, Blocks.PORTAL.getDefaultState().withRotation(Rotation.CLOCKWISE_180));
            }
            if (Objects.equals("west", playerIn.getHorizontalFacing().toString()) && playerIn.getPosition().getY() < 256 && playerIn.getPosition().getY() > 0) {
                pos = playerIn.getPosition().west(3);
                worldIn.setBlockState(pos, Blocks.PORTAL.getDefaultState().withRotation(Rotation.COUNTERCLOCKWISE_90));
            }
            BlockPos finalPos = pos;
            timer.schedule(
                    new java.util.TimerTask() {
                        public void run() {
                            worldIn.setBlockState(finalPos, Blocks.AIR.getDefaultState());
                            timer.cancel();
                        }
                    },
                    5000
            );
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}