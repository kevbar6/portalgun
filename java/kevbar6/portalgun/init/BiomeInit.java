package kevbar6.portalgun.init;

import kevbar6.portalgun.world.biomes.BiomeBWoodTreeForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
    public static final Biome BWOOD_FOREST = new BiomeBWoodTreeForest();
    public static void registerBiomes(){
        initBiome(BWOOD_FOREST, "bwood_forest", BiomeType.WARM, Type.HILLS, Type.DEAD, Type.DRY);
    }
    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types){
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println("Biomereg");
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        System.out.println("Biomeadd");
        return biome;
    }
}
