package tally.shattered_archive.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Stainable;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tally.shattered_archive.blocks.helpers.ModBlockProperties;

import java.util.Objects;

public class VariableStainedGlass extends TransparentBlock implements Stainable {
    public static final IntProperty OPAQUENESS = ModBlockProperties.OPAQUE;
    public static final IntProperty CARRY = ModBlockProperties.CARRY;
    private final DyeColor color;

    public VariableStainedGlass(DyeColor color, Settings settings) {
        super(settings);
        this.color = color;
        this.setDefaultState(this.stateManager.getDefaultState().with(OPAQUENESS, 0).with(CARRY, 0));
    }

    @Override
    public DyeColor getColor() {
        return this.color;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(OPAQUENESS).add(CARRY);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (world.isClient) {
            return;
        }
        world.scheduleBlockTick(pos, this, 1);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        if (pos != sourcePos) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isReceivingRedstonePower(pos)) {
            BlockState newS = state.with(OPAQUENESS, world.getReceivedRedstonePower(pos)).with(CARRY, 15);
            if (state != newS) {
                world.setBlockState(pos, newS, Block.NOTIFY_ALL);
            }
        } else {
            Integer newO = 0;
            Integer hC = 0;
            @Nullable Direction high = null;
            for (Direction dir : Direction.values()) {
                BlockState bState = world.getBlockState(pos.offset(dir));
                if (bState.isOf(this)) {
                    if (bState.get(CARRY) > hC) {
                        hC = bState.get(CARRY);
                        newO = bState.get(OPAQUENESS);
                        high = dir;
                    }
                }
            }

            if (high != null && hC != 15) {
                boolean higher = false;
                BlockPos newPos = pos.offset(high);
                for (Direction dir : Direction.values()) {
                    BlockState bState = world.getBlockState(newPos.offset(dir));
                    if (bState.isOf(this)) {
                        if (bState.get(CARRY) > hC) {
                            higher = true;
                        }
                    }
                }
                if (!higher) {
                    hC = 0;
                }
            }

            if (hC <= state.get(CARRY) || hC == 1) {
                BlockState newS = state.with(OPAQUENESS, 0).with(CARRY, 0);
                if (state != newS) {
                    world.setBlockState(pos, newS, Block.NOTIFY_ALL);
                }
            } else {
                BlockState newS = state.with(OPAQUENESS, newO).with(CARRY, hC - 1);
                if (state != newS) {
                    world.setBlockState(pos, newS, Block.NOTIFY_ALL);
                }
            }
        }
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) && Objects.equals(state.get(OPAQUENESS), stateFrom.get(OPAQUENESS));
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.isOf(this) ? state.get(OPAQUENESS) : 0;
    }
}
