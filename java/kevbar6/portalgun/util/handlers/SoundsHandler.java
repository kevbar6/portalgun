package kevbar6.portalgun.util.handlers;

import kevbar6.portalgun.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
    public static SoundEvent ENTITY_HERBERT_AMBIENT, ENTITY_HERBERT_HURT, ENTITY_HERBERT_DEATH;

    public static void registerSounds(){
        ENTITY_HERBERT_AMBIENT = registerSound("entity.herbert.ambient");
        ENTITY_HERBERT_HURT = registerSound("entity.herbert.hurt");
        ENTITY_HERBERT_DEATH = registerSound("entity.herbert.death");
    }
    private static SoundEvent registerSound(String name){
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
