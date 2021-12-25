package mtr.block;

import mtr.BlockEntityTypes;
import mtr.mappings.BlockEntityMapper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockPIDS3 extends BlockPIDSBase {

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
		VoxelShape shape1 = IBlock.getVoxelShapeByDirection(6, 0, 0, 10, 10, 16, IBlock.getStatePropertySafe(state, FACING));
		VoxelShape shape2 = IBlock.getVoxelShapeByDirection(7.5, 10, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING));
		return Shapes.or(shape1, shape2);
	}

	@Override
	public BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state) {
		return new TileEntityBlockPIDS3(pos, state);
	}

	public static class TileEntityBlockPIDS3 extends TileEntityBlockPIDSBase {

		public static final int MAX_ARRIVALS = 2;

		public TileEntityBlockPIDS3(BlockPos pos, BlockState state) {
			super(BlockEntityTypes.PIDS_3_TILE_ENTITY, pos, state);
		}

		@Override
		protected int getMaxArrivals() {
			return MAX_ARRIVALS;
		}
	}
}