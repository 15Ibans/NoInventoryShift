package me.ibans.noinventoryshift;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = NoInventoryShift.MODID, version = NoInventoryShift.VERSION, useMetadata = true)
public class NoInventoryShift
{
    public static final String MODID = "noinventoryshift";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onOpenInventory(GuiOpenEvent e) {
        if (e.gui instanceof GuiInventory) {
            e.gui = new NoShiftInventory(Minecraft.getMinecraft().thePlayer);
        }
        if (e.gui instanceof GuiContainerCreative) {
            e.gui = new NoShiftCreativeInventory(Minecraft.getMinecraft().thePlayer);
        }
    }
}
