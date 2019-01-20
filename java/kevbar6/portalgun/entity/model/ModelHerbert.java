package kevbar6.portalgun.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import org.lwjgl.opengl.GL11;

/**
 * ModelIronGolem - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelHerbert extends ModelBase {
    public ModelRenderer main;
    public ModelRenderer main_1;
    public ModelRenderer main_2;
    public ModelRenderer iron_golem_right_leg;
    public ModelRenderer iron_golem_left_leg;
    public ModelRenderer iron_golem_middle;
    public ModelRenderer iron_golem_center;
    public ModelRenderer iron_golem_left_arm;
    public ModelRenderer iron_golem_right_arm;
    public ModelRenderer iron_golem_head;

    public ModelHerbert() {
        this.textureWidth = 244;
        this.textureHeight = 128;
        this.main_1 = new ModelRenderer(this, 194, 0);
        this.main_1.setRotationPoint(7.7F, 32.0F, -4.0F);
        this.main_1.addBox(-6.0F, -2.0F, 0.0F, 12, 32, 12, 0.0F);
        this.setRotateAngle(main_1, 0.5017821599483697F, 0.0F, 0.0F);
        this.main = new ModelRenderer(this, 112, 33);
        this.main.setRotationPoint(-5.5F, 0.0F, 0.0F);
        this.main.addBox(0.0F, 0.0F, 0.0F, 16, 32, 16, 0.0F);
        this.setRotateAngle(main, 1.1838568316277536F, 0.0F, 0.0F);
        this.main_2 = new ModelRenderer(this, 110, 0);
        this.main_2.setRotationPoint(0.0F, 31.0F, 4.0F);
        this.main_2.addBox(-9.0F, 0.0F, -20.0F, 18, 6, 24, 0.0F);
        this.setRotateAngle(main_2, 0.7517109513282776F, 0.0F, 0.0F);
        this.iron_golem_center = new ModelRenderer(this, 0, 40);
        this.iron_golem_center.setRotationPoint(0.0F, -21.30000000000006F, 0.0F);
        this.iron_golem_center.addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F);
        this.iron_golem_right_leg = new ModelRenderer(this, 37, 0);
        this.iron_golem_right_leg.setRotationPoint(-4.3F, 5.3F, 0.0F);
        this.iron_golem_right_leg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        this.iron_golem_left_leg = new ModelRenderer(this, 60, 0);
        this.iron_golem_left_leg.setRotationPoint(5.3F, 5.3F, 0.0F);
        this.iron_golem_left_leg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        this.iron_golem_head = new ModelRenderer(this, 0, 0);
        this.iron_golem_head.setRotationPoint(0.0F, -21.30000000000006F, -2.0F);
        this.iron_golem_head.addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F);
        this.iron_golem_middle = new ModelRenderer(this, 0, 70);
        this.iron_golem_middle.setRotationPoint(0.0F, -21.30000000000006F, 0.0F);
        this.iron_golem_middle.addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F);
        this.iron_golem_left_arm = new ModelRenderer(this, 60, 58);
        this.iron_golem_left_arm.setRotationPoint(0.0F, -21.30000000000006F, 0.0F);
        this.iron_golem_left_arm.addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.iron_golem_right_arm = new ModelRenderer(this, 60, 21);
        this.iron_golem_right_arm.setRotationPoint(0.0F, -21.30000000000006F, 0.0F);
        this.iron_golem_right_arm.addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.main.addChild(this.main_1);
        this.main_1.addChild(this.main_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.main.offsetX, this.main.offsetY, this.main.offsetZ);
        GlStateManager.translate(this.main.rotationPointX * f5, this.main.rotationPointY * f5, this.main.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 1.0D);
        GlStateManager.translate(-this.main.offsetX, -this.main.offsetY, -this.main.offsetZ);
        GlStateManager.translate(-this.main.rotationPointX * f5, -this.main.rotationPointY * f5, -this.main.rotationPointZ * f5);
        this.main.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_center.offsetX, this.iron_golem_center.offsetY, this.iron_golem_center.offsetZ);
        GlStateManager.translate(this.iron_golem_center.rotationPointX * f5, this.iron_golem_center.rotationPointY * f5, this.iron_golem_center.rotationPointZ * f5);
        GlStateManager.scale(1.4113440000000002D, 1.4520000000000002D, 1.4520000000000002D);
        GlStateManager.translate(-this.iron_golem_center.offsetX, -this.iron_golem_center.offsetY, -this.iron_golem_center.offsetZ);
        GlStateManager.translate(-this.iron_golem_center.rotationPointX * f5, -this.iron_golem_center.rotationPointY * f5, -this.iron_golem_center.rotationPointZ * f5);
        this.iron_golem_center.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_right_leg.offsetX, this.iron_golem_right_leg.offsetY, this.iron_golem_right_leg.offsetZ);
        GlStateManager.translate(this.iron_golem_right_leg.rotationPointX * f5, this.iron_golem_right_leg.rotationPointY * f5, this.iron_golem_right_leg.rotationPointZ * f5);
        GlStateManager.scale(1.41D, 1.45D, 1.45D);
        GlStateManager.translate(-this.iron_golem_right_leg.offsetX, -this.iron_golem_right_leg.offsetY, -this.iron_golem_right_leg.offsetZ);
        GlStateManager.translate(-this.iron_golem_right_leg.rotationPointX * f5, -this.iron_golem_right_leg.rotationPointY * f5, -this.iron_golem_right_leg.rotationPointZ * f5);
        this.iron_golem_right_leg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_left_leg.offsetX, this.iron_golem_left_leg.offsetY, this.iron_golem_left_leg.offsetZ);
        GlStateManager.translate(this.iron_golem_left_leg.rotationPointX * f5, this.iron_golem_left_leg.rotationPointY * f5, this.iron_golem_left_leg.rotationPointZ * f5);
        GlStateManager.scale(1.41D, 1.45D, 1.45D);
        GlStateManager.translate(-this.iron_golem_left_leg.offsetX, -this.iron_golem_left_leg.offsetY, -this.iron_golem_left_leg.offsetZ);
        GlStateManager.translate(-this.iron_golem_left_leg.rotationPointX * f5, -this.iron_golem_left_leg.rotationPointY * f5, -this.iron_golem_left_leg.rotationPointZ * f5);
        this.iron_golem_left_leg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_head.offsetX, this.iron_golem_head.offsetY, this.iron_golem_head.offsetZ);
        GlStateManager.translate(this.iron_golem_head.rotationPointX * f5, this.iron_golem_head.rotationPointY * f5, this.iron_golem_head.rotationPointZ * f5);
        GlStateManager.scale(1.4113440000000002D, 1.4520000000000002D, 1.4520000000000002D);
        GlStateManager.translate(-this.iron_golem_head.offsetX, -this.iron_golem_head.offsetY, -this.iron_golem_head.offsetZ);
        GlStateManager.translate(-this.iron_golem_head.rotationPointX * f5, -this.iron_golem_head.rotationPointY * f5, -this.iron_golem_head.rotationPointZ * f5);
        this.iron_golem_head.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_middle.offsetX, this.iron_golem_middle.offsetY, this.iron_golem_middle.offsetZ);
        GlStateManager.translate(this.iron_golem_middle.rotationPointX * f5, this.iron_golem_middle.rotationPointY * f5, this.iron_golem_middle.rotationPointZ * f5);
        GlStateManager.scale(1.4113440000000002D, 1.4520000000000002D, 1.4520000000000002D);
        GlStateManager.translate(-this.iron_golem_middle.offsetX, -this.iron_golem_middle.offsetY, -this.iron_golem_middle.offsetZ);
        GlStateManager.translate(-this.iron_golem_middle.rotationPointX * f5, -this.iron_golem_middle.rotationPointY * f5, -this.iron_golem_middle.rotationPointZ * f5);
        this.iron_golem_middle.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_left_arm.offsetX, this.iron_golem_left_arm.offsetY, this.iron_golem_left_arm.offsetZ);
        GlStateManager.translate(this.iron_golem_left_arm.rotationPointX * f5, this.iron_golem_left_arm.rotationPointY * f5, this.iron_golem_left_arm.rotationPointZ * f5);
        GlStateManager.scale(1.4113440000000002D, 1.4520000000000002D, 1.4520000000000002D);
        GlStateManager.translate(-this.iron_golem_left_arm.offsetX, -this.iron_golem_left_arm.offsetY, -this.iron_golem_left_arm.offsetZ);
        GlStateManager.translate(-this.iron_golem_left_arm.rotationPointX * f5, -this.iron_golem_left_arm.rotationPointY * f5, -this.iron_golem_left_arm.rotationPointZ * f5);
        this.iron_golem_left_arm.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.iron_golem_right_arm.offsetX, this.iron_golem_right_arm.offsetY, this.iron_golem_right_arm.offsetZ);
        GlStateManager.translate(this.iron_golem_right_arm.rotationPointX * f5, this.iron_golem_right_arm.rotationPointY * f5, this.iron_golem_right_arm.rotationPointZ * f5);
        GlStateManager.scale(1.4113440000000002D, 1.4520000000000002D, 1.4520000000000002D);
        GlStateManager.translate(-this.iron_golem_right_arm.offsetX, -this.iron_golem_right_arm.offsetY, -this.iron_golem_right_arm.offsetZ);
        GlStateManager.translate(-this.iron_golem_right_arm.rotationPointX * f5, -this.iron_golem_right_arm.rotationPointY * f5, -this.iron_golem_right_arm.rotationPointZ * f5);
        this.iron_golem_right_arm.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.iron_golem_head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.iron_golem_head.rotateAngleX = headPitch * 0.017453292F;
        this.iron_golem_left_leg.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.iron_golem_right_leg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.iron_golem_left_leg.rotateAngleY = 0.0F;
        this.iron_golem_right_leg.rotateAngleY = 0.0F;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityIronGolem entityirongolem = (EntityIronGolem)entitylivingbaseIn;
        int i = entityirongolem.getAttackTimer();

        if (i > 0)
        {
            this.iron_golem_right_arm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTickTime, 10.0F);
            this.iron_golem_left_arm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTickTime, 10.0F);
        }
        else
        {
            int j = entityirongolem.getHoldRoseTick();

            if (j > 0)
            {
                this.iron_golem_right_arm.rotateAngleX = -0.8F + 0.025F * this.triangleWave((float)j, 70.0F);
                this.iron_golem_left_arm.rotateAngleX = 0.0F;
            }
            else
            {
                this.iron_golem_right_arm.rotateAngleX = (-0.2F + 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
                this.iron_golem_left_arm.rotateAngleX = (-0.2F - 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
            }
        }
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
