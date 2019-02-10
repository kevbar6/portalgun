package kevbar6.portalgun.world.biomes;

import kevbar6.portalgun.entity.EntityHerbert;
import kevbar6.portalgun.init.BlockInit;
import kevbar6.portalgun.world.generation.BWoodTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeBWoodTreeForest extends Biome {
    protected static final WorldGenAbstractTree TREE = new BWoodTree(false);

    public BiomeBWoodTreeForest() {
        super(new BiomeProperties("bwood_forest").setBaseHeight(0.125F).setHeightVariation(0.0005F).setTemperature(1F).setWaterColor(16757078));

        topBlock = BlockInit.BDIRT.getDefaultState();
        fillerBlock = BlockInit.BDIRT.getDefaultState();

        this.decorator.coalGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.andesiteGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.diamondGen = new WorldGenMinable(BlockInit.BEDROCK_ORE.getDefaultState(),3);
        this.decorator.lapisGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.redstoneGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.goldGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.dioriteGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.dirtGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.gravelGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.gravelOreGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.ironGen = new WorldGenMinable(BlockInit.BDIRT.getDefaultState(),10);
        this.decorator.gravelPatchesPerChunk = 0;
        this.decorator.generateFalls = false;
        this.decorator.extraTreeChance = 0.1f;
        this.decorator.grassPerChunk = 0;
        this.decorator.grassPerChunk = 0;
        this.decorator.flowersPerChunk = 0;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHerbert.class, 10, 0, 1));
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return TREE;
    }
}
