package ru.tenebrius.shittruck;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderShitTruck extends RenderBiped {

    private static final ResourceLocation MOB_TEXTURE = new ResourceLocation(Core.MODID + ":textures/model/shit_truck.png");

    public RenderShitTruck(float x) {
        super(new ModelShitTruck(), x);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return MOB_TEXTURE;
    }

    

}
