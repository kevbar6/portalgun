package kevbar6.portalgun.commands;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import kevbar6.portalgun.util.Reference;
import kevbar6.portalgun.commands.util.CustomTeleporter;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CommandTeleportDimension extends CommandBase
{
	private final List<String> aliases = Lists.newArrayList(Reference.MODID, "TP", "tpdim", "tpdimension", "teleport");

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length < 1) return;

		String s = args[0];
		int dimension;

		try
		{
			dimension = Integer.parseInt(s);
		} catch(NumberFormatException e)
		{
			throw new CommandException("commands.tpdimension.dimensionnotfound", new Object[0]);
		}
		if(sender instanceof EntityPlayer)
		{
			if (dimension != 1){
				try {
					CustomTeleporter.teleportToDimension((EntityPlayer)sender, dimension, sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
					World world = server.getWorld(dimension);
					if (sender.getPosition().getY() <255){
						world.setBlockState(sender.getPosition(), Blocks.AIR.getDefaultState());
						world.setBlockState(new BlockPos(sender.getPosition().getX(), sender.getPosition().getY()+1, sender.getPosition().getZ()), Blocks.AIR.getDefaultState());
						world.setBlockState(new BlockPos(sender.getPosition().getX(), sender.getPosition().getY()-1, sender.getPosition().getZ()), Blocks.GLOWSTONE.getDefaultState());
						CustomTeleporter.teleportToDimension((EntityPlayer)sender, dimension, sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
					} else {
						world.setBlockState(new BlockPos(sender.getPosition().getX(), 255, sender.getPosition().getZ()), Blocks.AIR.getDefaultState());
						world.setBlockState(new BlockPos(sender.getPosition().getX(), 265, sender.getPosition().getZ()), Blocks.AIR.getDefaultState());
						world.setBlockState(new BlockPos(sender.getPosition().getX(), 254, sender.getPosition().getZ()), Blocks.GLOWSTONE.getDefaultState());
						CustomTeleporter.teleportToDimension((EntityPlayer) sender, dimension, sender.getPosition().getX(), 255, sender.getPosition().getZ());
					}

				}
				catch (IllegalArgumentException e){
					throw new CommandException("commands.tpdimension.dimensionnotfound", new Object[0]);

				}
			}
			else{
				throw new CommandException("commands.tpdimension.unsupporteddimensions", new Object[0]);
			}
		}
	}

	@Override
	public String getName()
	{
		return "tpdimension";
	}

	public String getUsage(ICommandSender sender)
	{
		return "tpdimension <id>";
	}

	@Override
	public List<String> getAliases()
	{
		return aliases;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
	{
		return Collections.emptyList();
	}
}