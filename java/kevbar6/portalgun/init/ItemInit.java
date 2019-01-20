package kevbar6.portalgun.init;

import kevbar6.portalgun.objects.armor.ArmorBase;
import kevbar6.portalgun.objects.items.ItemBase;
import kevbar6.portalgun.objects.items.ItemPortalGun;
import kevbar6.portalgun.objects.tools.*;
import kevbar6.portalgun.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    //Material
    public static final Item.ToolMaterial TOOL_YDIAMOND = EnumHelper.addToolMaterial("tool_ydiamond", 5, 5873, 9.0F, 4.0F, 11);
    public static final ItemArmor.ArmorMaterial ARMOR_YDIAMOND = EnumHelper.addArmorMaterial("armor_ydiamond", Reference.MODID + ":whiteiron", 40, new int[]{4, 7, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
    public static final Item.ToolMaterial TOOL_WHITEIRON = EnumHelper.addToolMaterial("tool_whiteiron", 4, 173, 9.0F, 4.0F, 11);
    public static final ItemArmor.ArmorMaterial ARMOR_WHITEIRON = EnumHelper.addArmorMaterial("armor_whiteiron", Reference.MODID + ":whiteiron", 20, new int[]{4, 7, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
    public static final Item.ToolMaterial TOOL_GHOST = EnumHelper.addToolMaterial("tool_ghost", 0, 1, 0F, 9378445969834723f, 0);

    //Items
    public static final Item YDIAMOND = new ItemBase("ydiamond");
    public static final Item BROKENPORTALGUN = new ItemBase("brokenportalgun");
    public static final Item YBEACON = new ItemBase("ybeacon");
    public static final Item WHITEIRON_INGOT = new ItemBase("whiteiron_ingot");
    public static final Item PORTALGUN = new ItemPortalGun("portalgun");
    public static final Item BEDROCK_SHARD = new ItemBase("bedrock_shard");

    //Tools
    public static final Item AXE_YDIAMOND = new ToolAxe("ydiamond_axe", TOOL_YDIAMOND);
    public static final Item HOE_YDIAMOND = new ToolHoe("ydiamond_hoe", TOOL_YDIAMOND);
    public static final Item PICKAXE_YDIAMOND = new ToolPickaxe("ydiamond_pickaxe", TOOL_YDIAMOND);
    public static final Item SHOVEL_YDIAMOND = new ToolShovel("ydiamond_shovel", TOOL_YDIAMOND);
    public static final Item SWORD_YDIAMOND = new ToolSword("ydiamond_sword", TOOL_YDIAMOND);

    public static final Item AXE_WHITEIRON = new ToolAxe("whiteiron_axe", TOOL_WHITEIRON);
    public static final Item HOE_WHITEIRON = new ToolHoe("whiteiron_hoe", TOOL_WHITEIRON);
    public static final Item PICKAXE_WHITEIRON = new ToolPickaxe("whiteiron_pickaxe", TOOL_WHITEIRON);
    public static final Item SHOVEL_WHITEIRON = new ToolShovel("whiteiron_shovel", TOOL_WHITEIRON);
    public static final Item SWORD_WHITEIRON = new ToolSword("whiteiron_sword", TOOL_WHITEIRON);

    public static final Item SWORD_GHOST = new ToolSword("ghost_sword", TOOL_GHOST);

    //Armour
    public static final Item HELMET_YDIAMOND = new ArmorBase("ydiamond_helmet", ARMOR_YDIAMOND, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_YDIAMOND = new ArmorBase("ydiamond_chestplate", ARMOR_YDIAMOND, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_YDIAMOND = new ArmorBase("ydiamond_leggings", ARMOR_YDIAMOND, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_YDIAMOND = new ArmorBase("ydiamond_boots", ARMOR_YDIAMOND, 1, EntityEquipmentSlot.FEET);

    public static final Item HELMET_WHITEIRON = new ArmorBase("whiteiron_helmet", ARMOR_WHITEIRON, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_WHITEIRON = new ArmorBase("whiteiron_chestplate", ARMOR_WHITEIRON, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_WHITEIRON = new ArmorBase("whiteiron_leggings", ARMOR_WHITEIRON, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_WHITEIRON = new ArmorBase("whiteiron_boots", ARMOR_WHITEIRON, 1, EntityEquipmentSlot.FEET);
}
