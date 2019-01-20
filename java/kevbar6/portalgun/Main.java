package kevbar6.portalgun;

        import kevbar6.portalgun.init.SmeltingInit;
        import kevbar6.portalgun.proxy.CommonProxy;
        import kevbar6.portalgun.tabs.PortalTab;
        import kevbar6.portalgun.util.Reference;
        import kevbar6.portalgun.util.handlers.RegistryHandler;
        import net.minecraft.creativetab.CreativeTabs;
        import net.minecraft.init.Blocks;
        import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.common.Mod.EventHandler;
        import net.minecraftforge.fml.common.SidedProxy;
        import net.minecraftforge.fml.common.event.FMLInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
        import net.minecraftforge.fml.common.registry.GameRegistry;
        import org.apache.logging.log4j.Logger;
        import scala.tools.nsc.doc.model.Public;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    public static final CreativeTabs portaltab = new PortalTab("portaltab");

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        RegistryHandler.preInitRegistries();
    }
    @EventHandler
    public static void init(FMLInitializationEvent event){
        SmeltingInit.Init();
        RegistryHandler.initRegistries();
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        RegistryHandler.postInitRegistries();
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event)
    {
        RegistryHandler.serverRegistries(event);
    }
}
