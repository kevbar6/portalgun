package kevbar6.portalgun.world.generation.generators;

import kevbar6.portalgun.init.BiomeInit;
import kevbar6.portalgun.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {
    private WorldGenerator ydiamond_end_ore, ydiamond_overworld_ore, ydiamond_nether_ore, whiteiron_overworld_ore, whiteiron_nether_ore, bedrock_ore;
    public OreGen() {
        ydiamond_end_ore = new WorldGenMinable(BlockInit.YDIAMOND_END_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.END_STONE));
        ydiamond_overworld_ore = new WorldGenMinable(BlockInit.YDIAMOND_OVERWORLD_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.STONE));
        ydiamond_nether_ore = new WorldGenMinable(BlockInit.YDIAMOND_NETHER_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.NETHERRACK));

        whiteiron_overworld_ore = new WorldGenMinable(BlockInit.WHIREIRON_OVERWORLD_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.STONE));
        whiteiron_nether_ore = new WorldGenMinable(BlockInit.WHITEIRON_NETHER_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.NETHERRACK));
        bedrock_ore = new WorldGenMinable(BlockInit.BEDROCK_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case -1:
                runGenerator(ydiamond_nether_ore, world, random, chunkX, chunkZ, 4, 0, 100);
                runGenerator(whiteiron_nether_ore, world, random, chunkX, chunkZ, 4, 0, 100);
                break;
            case 0:
                runGenerator(ydiamond_overworld_ore, world, random, chunkX, chunkZ, 2, 0, 50);
                runGenerator(whiteiron_overworld_ore, world, random, chunkX, chunkZ, 2, 0, 50);
                runGeneratorInBiome(bedrock_ore, world, random, chunkX, chunkZ, 2, 0, 50, BiomeInit.BWOOD_FOREST);
                break;
            case 1:
                runGenerator(ydiamond_end_ore, world, random, chunkX, chunkZ, 8, 0, 100);
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight){
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chance; i++){
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);
            gen.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    private void runGeneratorInBiome(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight, Biome biome){
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        Biome getBiome = world.getBiome(new BlockPos(blockX, 64, blockZ));
        if (getBiome == biome)runGenerator(gen, world, rand, chunkX, chunkZ, chance, minHeight, maxHeight);
    }
}
