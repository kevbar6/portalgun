package kevbar6.portalgun.objects.blocks;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.init.BlockInit;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class BlockBedrockOre extends Block implements IHasModel {

    public BlockBedrockOre(String name) {
        super(Material.ROCK);
        setSoundType(SoundType.METAL);
        setHardness(100f);
        setResistance(100f);
        setHarvestLevel("pickaxe", 5);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.portaltab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random ran, int fortune){
        return ItemInit.BEDROCK_SHARD;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return (int) (Math.random() * 2) + 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0) {
                i = 0;
            }
            return this.quantityDropped(random) * (i + 1);
        }
        else {
            return this.quantityDropped(random);
        }
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
