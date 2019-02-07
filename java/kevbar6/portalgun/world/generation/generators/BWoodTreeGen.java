package kevbar6.portalgun.world.generation.generators;

import kevbar6.portalgun.world.biomes.BiomeBWoodTreeForest;
import kevbar6.portalgun.world.generation.BWoodTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BWoodTreeGen implements IWorldGenerator {
    private final WorldGenerator BWOOD = new BWoodTree();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case -1:
                break;
            case 0:
                runGenerator(BWOOD, world, random, chunkX, chunkZ, 0, -1, 0, BiomeBWoodTreeForest.class);
                break;
            case 1:
                break;
        }
    }
    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chanceToSpawn, int minHeight, int maxHeight, Class<?>... classes){
        if (chanceToSpawn < 1)
            if (random.nextDouble() < chanceToSpawn) chanceToSpawn = 1;
            else chanceToSpawn = 0;
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chanceToSpawn; i++){
            BlockPos pos = new BlockPos(chunkX * 16 + 10 + random.nextInt(15), minHeight + random.nextInt(heightDiff),chunkZ * 16 + 10 + random.nextInt(15));
            if (minHeight < 0) pos = world.getHeight(pos);
            Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
            if (classesList.contains(biome) || classes.length == 0) generator.generate(world, random, pos);
        }
    }
}
