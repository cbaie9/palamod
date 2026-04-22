package palamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class FakepaladiumoreBlock extends Block {
	public FakepaladiumoreBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(6f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}