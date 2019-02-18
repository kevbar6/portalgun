package kevbar6.portalgun.init;

import kevbar6.portalgun.objects.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BDIRT = new BlockDirtBase("bdirt");

    public static final Block YDIAMOND_END_ORE = new BlockYDiamondOre("ydiamond_end_ore");
    public static final Block YDIAMOND_OVERWORLD_ORE = new BlockYDiamondOre("ydiamond_overworld_ore");
    public static final Block YDIAMOND_NETHER_ORE = new BlockYDiamondOre("ydiamond_nether_ore");

    public static final Block BEDROCK_ORE = new BlockBedrockOre("bedrock_ore");

    public static final Block WHIREIRON_OVERWORLD_ORE = new BlockOreBase("whiteiron_overworld_ore",  "overworld", Material.ROCK, SoundType.STONE, 1F, 3.0F,5.0F, "pickaxe", 3);
    public static final Block WHITEIRON_NETHER_ORE = new BlockOreBase("whiteiron_nether_ore",  "overworld", Material.ROCK, SoundType.STONE, 1F, 3.0F,5.0F, "pickaxe", 3);

    public static final Block NETHER_STAR_BLOCK = new BlockBase("nether_star_block", Material.GLASS, 1000F, "pickaxe", 4, 4F, 1000F, SoundType.GLASS);

    public static final Block BWOOD_LOG = new BlockLogBase("bwood_log");
    public static final Block BWOOD_LEAVES = new BlockLeavesBase("bwood_leaves");
    public static final Block BWOOD_SAPLING = new BlockSaplingBase("bwood_sapling");
    public static final Block BWOOD_PLANKS = new BlockWoodBase("bwood_planks", Material.WOOD, SoundType.WOOD, 0F, 2F, 5F, "axe", 1);
    public static final Block BWOOD_STAIRS = new BlockStairsBase("bwood_stairs", BWOOD_PLANKS.getDefaultState());
}
