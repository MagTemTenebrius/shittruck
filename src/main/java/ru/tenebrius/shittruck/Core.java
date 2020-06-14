package ru.tenebrius.shittruck;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid = Core.MODID, version = Core.VERSION)
public class Core {
    public static final String MODID = "shittruck";
    public static final String VERSION = "1.0";

    @Mod.Instance(Core.MODID)
    public static Core instance;

    @SidedProxy(modId = MODID, serverSide = "ru.tenebrius.shittruck.ProxyServer", clientSide = "ru.tenebrius.shittruck.ProxyClient")
    public static ProxyServer proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        int randomID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(ShitTruck.class, "shittruck", randomID);
        EntityRegistry.registerModEntity(ShitTruck.class, "shittruck", randomID, instance, 64, 1, true);
        EntityRegistry.addSpawn(ShitTruck.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
        EntityList.entityEggs.put(randomID, new EntityList.EntityEggInfo(randomID, 0xFFFFFF, 0x00FF00));

        proxy.preInit();
    }
}
