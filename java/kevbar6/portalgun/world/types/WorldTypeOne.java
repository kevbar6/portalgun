package kevbar6.portalgun.world.types;

import kevbar6.portalgun.init.BiomeInit;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeOne extends WorldType {
    public WorldTypeOne() {
        super("one");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        return new BiomeProviderSingle(BiomeInit.BWOOD_FOREST);
    }
}
