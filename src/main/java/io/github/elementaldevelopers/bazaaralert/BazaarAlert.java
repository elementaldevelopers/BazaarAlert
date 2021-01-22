package io.github.elementaldevelopers.bazaaralert;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.ref.Reference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod(modid = BazaarAlert.MODID, version = BazaarAlert.VERSION)
public class BazaarAlert {
    public static final String MODID = "BazaarAlert";
    public static final String VERSION = "1.0.0";
    public static Pattern regex = Pattern.compile("^\\[Bazaar\\] Your (Sell|Buy) (Offer|Order) for \\d+x (\\w|\\s)+ was filled!$");
    SettingsCommand sc = new SettingsCommand();
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(sc);
    }
    @SubscribeEvent
    public void ChatRecieved(ClientChatReceivedEvent event) {
    	if (!sc.isEnabled) return;
    }
}