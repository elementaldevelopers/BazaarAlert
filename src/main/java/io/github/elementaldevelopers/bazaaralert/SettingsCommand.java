package io.github.elementaldevelopers.bazaaralert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class SettingsCommand extends CommandBase{
	public boolean isEnabled = true;
	private String[] truesettings = {"on", "true"};
	private String[] falsesettings = {"off", "false"};
	public boolean listcontains(String[] list, String item) {
		for (String i: list) {
			if (i == item) {
				return true;
			}
		}
		return false;
		
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}
	@Override
	public String getCommandName() {
		return "bazaaralert";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Make sure the string after bazaaralert is either on, off, true or false. You can also put nothing to get the hep message";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Welcome to BazaarAlert!"));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("This mod notifies you when your Bazaar orders are filled"));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("However, it only works when Skyblock sends the Bazaar filled message"));
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Use /bazaaralert [setting] to turn it on or off. Accepted values are on, off, true, or false."));
			return;
		}
		if (args.length > 1) {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
		} else {
			if (listcontains(truesettings, args[0])) {
				this.isEnabled = true;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aSuccesfully turned on BazaarAlert"));
			} else if (listcontains(falsesettings, args[0])) {
				this.isEnabled = false;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aSuccesfully turned off BazaarAlert"));
			}
		}
	}
    
}