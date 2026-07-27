package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

import java.io.File;

public class GetxpfarmerbreakblockProcedure {
	public static double execute(BlockState blockDep, double farmerLevel) {
		double output = 0;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		BlockState block = Blocks.AIR.defaultBlockState();
		block = blockDep;
		lvl = farmerLevel;
		if (7 == (getPropertyByName(block, "age") instanceof IntegerProperty _getip0 ? block.getValue(_getip0) : -1) && block.getBlock() == Blocks.WHEAT) {
			output = 2;
		} else if (7 == (getPropertyByName(block, "age") instanceof IntegerProperty _getip2 ? block.getValue(_getip2) : -1) && block.getBlock() == Blocks.POTATOES && 5 <= lvl) {
			output = 3;
		} else if (7 == (getPropertyByName(block, "age") instanceof IntegerProperty _getip4 ? block.getValue(_getip4) : -1) && block.getBlock() == Blocks.CARROTS && 10 <= lvl) {
			output = 2.5;
		} else if (block.getBlock() == Blocks.MELON && 15 <= lvl) {
			output = 4;
		} else if (block.getBlock() == Blocks.CARVED_PUMPKIN && 30 <= lvl) {
			output = 5;
		} else if (block.getBlock() == PalamodModBlocks.EGGPLANT_3.get() && 40 <= lvl) {
			output = 10;
		} else if (block.getBlock() == PalamodModBlocks.ORANGEBLUE_4.get() && 100 <= lvl) {
			output = 2215;
		} else if (block.getBlock() == PalamodModBlocks.CHERVIL_3.get() && 60 <= lvl) {
			output = 20;
		} else if (block.getBlock() == PalamodModBlocks.KIWANO_4.get() && 80 <= lvl) {
			output = 200;
		}
		return output;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}