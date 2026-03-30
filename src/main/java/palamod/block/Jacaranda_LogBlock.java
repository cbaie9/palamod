package palamod.block;

<<<<<<< Updated upstream
=======
import palamod.procedures.SetsapblockstatevisualProcedure;

>>>>>>> Stashed changes
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
<<<<<<< Updated upstream
import net.minecraft.util.TriState;
=======
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.TriState;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
>>>>>>> Stashed changes
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class Jacaranda_LogBlock extends Block {
<<<<<<< Updated upstream
	public Jacaranda_LogBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(2f).requiresCorrectToolForDrops().ignitedByLava().instrument(NoteBlockInstrument.BASS));
=======
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	public static final IntegerProperty SAP = IntegerProperty.create("sap", 0, 96);

	public Jacaranda_LogBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(2f).requiresCorrectToolForDrops().ignitedByLava().instrument(NoteBlockInstrument.BASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(SAP, 96));
>>>>>>> Stashed changes
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
		return TriState.TRUE;
	}
}