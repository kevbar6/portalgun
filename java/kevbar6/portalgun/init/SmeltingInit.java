package kevbar6.portalgun.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingInit {
    public static void Init() {
        GameRegistry.addSmelting(BlockInit.WHIREIRON_OVERWORLD_ORE, new ItemStack(ItemInit.WHITEIRON_INGOT, 1), 3F);
        GameRegistry.addSmelting(BlockInit.WHITEIRON_NETHER_ORE, new ItemStack(ItemInit.WHITEIRON_INGOT, 1), 3F);
    }
}
