
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TitaneBlockBlock extends Block {
	public TitaneBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 10;
		else
			return super.canHarvestBlock(state, world, pos, player);
	}
}