package kevbar6.portalgun.objects.blocks;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.init.BlockInit;
import kevbar6.portalgun.init.ItemInit;
import kevbar6.portalgun.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOreBase extends Block implements IHasModel {
    private String dimension;

    public BlockOreBase(String name, String dimension, Material material, SoundType soundType, float setLightLevel, float setHardness, float setResistance, String toolClass, int level) {
        super(material);
        setSoundType(soundType);
        setLightLevel(setLightLevel);
        setHardness(setHardness);
        setResistance(setResistance);
        setHarvestLevel(toolClass, level);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.portaltab);

        this.dimension = dimension;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
