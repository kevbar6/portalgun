package kevbar6.portalgun.entity.render;

import kevbar6.portalgun.entity.EntityHerbert;
import kevbar6.portalgun.entity.model.ModelHerbert;
import kevbar6.portalgun.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHerbert extends RenderLiving<EntityHerbert> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/herbert.png");
    public RenderHerbert(RenderManager manager) {
        super(manager, new ModelHerbert(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHerbert entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityHerbert entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
