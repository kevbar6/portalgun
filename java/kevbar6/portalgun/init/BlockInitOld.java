package kevbar6.portalgun.init;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.objects.blocks.slab.BlockDoubleSlabBase;
import kevbar6.portalgun.objects.blocks.slab.BlockHalfSlabBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInitOld {
    public static BlockHalfSlabBase BWOOD_SLAB;
    public static BlockDoubleSlabBase BWOOD_SLAB_DOUBLE;

    public static void init(){
        BWOOD_SLAB = new BlockHalfSlabBase("bwood_slab", 2.5F, 4.5F);
        BWOOD_SLAB_DOUBLE = new BlockDoubleSlabBase("bwood_slab_double", 2.5F, 4.5F);
    }

    public static void register(){
        registerBlock(BWOOD_SLAB, new ItemSlab(BWOOD_SLAB, BWOOD_SLAB, BWOOD_SLAB_DOUBLE));
        ForgeRegistries.BLOCKS.register(BWOOD_SLAB_DOUBLE);
    }

    public static void registerBlock(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        block.setCreativeTab(Main.portaltab);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(item);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerBlock(Block block, ItemBlock itemblock)
    {
        ForgeRegistries.BLOCKS.register(block);
        block.setCreativeTab(Main.portaltab);
        itemblock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemblock);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
