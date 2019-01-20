package kevbar6.portalgun.util.handlers;


import kevbar6.portalgun.commands.CommandTeleportDimension;
import kevbar6.portalgun.init.*;
import kevbar6.portalgun.world.generation.generators.BWoodTreeGen;
import kevbar6.portalgun.world.generation.generators.OreGen;
import kevbar6.portalgun.util.interfaces.IHasModel;
import kevbar6.portalgun.world.types.WorldTypeOne;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item : ItemInit.ITEMS){
            if (item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
        for (Block block : BlockInit.BLOCKS){
            if (block instanceof IHasModel){
                ((IHasModel)block).registerModels();
            }
        }
    }
    public static void preInitRegistries(){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new BWoodTreeGen(),0);

        BiomeInit.registerBiomes();
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();

        BlockInitOld.init();
        BlockInitOld.register();
    }

    public static void initRegistries(){
        SoundsHandler.registerSounds();
    }

    public static void postInitRegistries(){
        WorldType ONE = new WorldTypeOne();
    }

    public static void serverRegistries(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandTeleportDimension());
    }
}
