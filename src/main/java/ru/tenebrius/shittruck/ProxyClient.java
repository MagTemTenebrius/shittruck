package ru.tenebrius.shittruck;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ProxyClient extends ProxyServer {

    public static int[] displayList = new int[6];//for 6 parts model

    @Override
    public void preInit() {
        final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(Core.MODID, "model/shit_truck_model.obj"));
//        model.renderAll();
        final String[] partsName = new String[] {
                "u",
                "d",
                "ru",
                "lu",
                "rd",
                "ld"
        };
        for (int i = 0; i < displayList.length; ++i ) {
            GL11.glPushMatrix();
            displayList[i] = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(displayList[i], GL11.GL_COMPILE);
            GL11.glScaled(12,12,12);
            GL11.glRotated(180, 0, 1, 0);
            GL11.glTranslated(0,0,0.1);
            model.renderPart(partsName[i]);
            GL11.glEndList();
            GL11.glPopMatrix();
        }

        RenderingRegistry.registerEntityRenderingHandler(ShitTruck.class, new RenderShitTruck(1F));
    }

}
