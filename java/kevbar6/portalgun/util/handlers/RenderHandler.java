package kevbar6.portalgun.util.handlers;

import kevbar6.portalgun.entity.EntityHerbert;
import kevbar6.portalgun.entity.render.RenderHerbert;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(EntityHerbert.class, new IRenderFactory<EntityHerbert>() {
            @Override
            public Render<? super EntityHerbert> createRenderFor(RenderManager manager) {
                return new RenderHerbert(manager);
            }
        });
    }
}
