package kevbar6.portalgun.world.generation;

import kevbar6.portalgun.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

import static net.minecraft.block.BlockLog.LOG_AXIS;

public class BWoodTree extends WorldGenAbstractTree
    {
        public static final IBlockState LOG = BlockInit.BWOOD_LOG.getDefaultState();
        public static final IBlockState LEAF = BlockInit.BWOOD_LEAVES.getDefaultState();
        private int minHeight;

	public BWoodTree()
        {
            super(false);
        }

        @Override
        public boolean generate(World world, Random rand, BlockPos pos) {

                //1
                int i = rand.nextInt(3) + 5;


                boolean flag = true;

                if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256) {
                    for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j) {
                        int k = 1;

                        if (j == pos.getY()) {
                            k = 0;
                        }

                        if (j >= pos.getY() + 1 + i - 2) {
                            k = 2;
                        }

                        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                        for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l) {
                            for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1) {
                                if (j >= 0 && j < world.getHeight()) {
                                    if (!this.isReplaceable(world, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                        flag = false;
                                    }
                                } else {
                                    flag = false;
                                }
                            }
                        }
                    }

                    if (!flag) {
                        return false;
                    } else {
                        BlockPos down = pos.down();
                        IBlockState state = world.getBlockState(down);
                        boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING); ///////////////<<<<<----

                        if (isSoil && pos.getY() < world.getHeight() - i - 1) {
                            state.getBlock().onPlantGrow(state, world, down, pos);

                            for (int i2 = pos.getY() - 3 + i; i2 <= pos.getY() + i; ++i2) {
                                int k2 = i2 - (pos.getY() + i);
                                int l2 = 1 - k2 / 2;

                                for (int i3 = pos.getX() - l2; i3 <= pos.getX() + l2; ++i3) {
                                    int j1 = i3 - pos.getX();

                                    for (int k1 = pos.getZ() - l2; k1 <= pos.getZ() + l2; ++k1) {
                                        int l1 = k1 - pos.getZ();

                                        if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0) {
                                            BlockPos blockpos = new BlockPos(i3, i2, k1);
                                            IBlockState state2 = world.getBlockState(blockpos);

                                            if (state2.getBlock().isAir(state2, world, blockpos) || state2.getBlock().isAir(state2, world, blockpos)) {
                                                this.setBlockAndNotifyAdequately(world, blockpos, LEAF);
                                            }
                                        }
                                    }
                                }
                            }

                            for (int j2 = 0; j2 < i; ++j2) {
                                BlockPos upN = pos.up(j2);
                                IBlockState state2 = world.getBlockState(upN);

                                if (state2.getBlock().isAir(state2, world, upN) || state2.getBlock().isLeaves(state2, world, upN)) {
                                    this.setBlockAndNotifyAdequately(world, pos.up(j2), LOG);
                                }
                            }

                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }


            }

        @Override
        protected boolean canGrowInto(Block blockType)
        {
            Material material = blockType.getDefaultState().getMaterial();
            return material == Material.AIR || material == Material.LEAVES || material == Material.GROUND || blockType == Blocks.GRASS || blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;

        }
    }

