package palamod.block;

import palamod.world.inventory.CustomAnvilMenu;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.item.context.BlockPlaceContext;

import net.minecraft.world.InteractionResult;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;

import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import io.netty.buffer.Unpooled;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class AmethystanvilBlock extends FallingBlock {

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<AmethystanvilBlock> CODEC = simpleCodec(AmethystanvilBlock::new);

    @Override
    public MapCodec<AmethystanvilBlock> codec() {
        return CODEC;
    }

    public AmethystanvilBlock(BlockBehaviour.Properties properties) {
        super(properties
                .mapColor(MapColor.COLOR_PURPLE)
                .sound(new DeferredSoundType(
                        1.0f, 1.0f,
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.break")).orElseThrow().value(),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.step")).orElseThrow().value(),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")).orElseThrow().value(),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.hit")).orElseThrow().value(),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")).orElseThrow().value()
                ))
                .strength(1f, 10f)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        );

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    // ✅ CORRECTION OBLIGATOIRE (erreur getDustColor)
    @Override
    public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
        return 0xC77DFF; // violet améthyste
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    // ✅ UTILISE TON CUSTOM ANVIL MENU
    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                            Player player, BlockHitResult hit) {

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (player instanceof ServerPlayer serverPlayer) {

            MenuProvider provider = new MenuProvider() {

                @Override
                public Component getDisplayName() {
                    return Component.literal("Amethyst Anvil");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
                    return new CustomAnvilMenu(id, inv, ContainerLevelAccess.create(level, pos));
                }
            };

            serverPlayer.openMenu(provider);
        }

        return InteractionResult.CONSUME;
    }
}