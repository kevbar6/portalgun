package kevbar6.portalgun.init;

import kevbar6.portalgun.Main;
import kevbar6.portalgun.entity.EntityHerbert;
import kevbar6.portalgun.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities(){
        registerEntity("herbert", EntityHerbert.class, Reference.ENTITY_HERBERT, 75, 16776960, 16711680);
    }
    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1,true,color1,color2);
    }
}
