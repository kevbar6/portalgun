package kevbar6.portalgun.world.generation;

import kevbar6.portalgun.init.BlockInit;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

import static net.minecraft.block.BlockLog.LOG_AXIS;

public class BWoodTree extends WorldGenAbstractTree
{
    public static final IBlockState LOG = BlockInit.BWOOD_LOG.getDefaultState();
    public static final IBlockState LOG1 = BlockInit.BWOOD_LOG.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
    public static final IBlockState LOG2 = BlockInit.BWOOD_LOG.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
    public static final IBlockState LEAVES = BlockInit.BWOOD_LEAVES.getDefaultState();
    private final int minTreeHeight = 9;

    public BWoodTree(boolean parShouldNotify)
    {
        super(parShouldNotify);
    }

    @Override
    public boolean generate(World world, Random parRandom, BlockPos pos)
    {
        int random = parRandom.nextInt(3);
        int minHeight = random + minTreeHeight;

        if (pos.getY() >= 1 && pos.getY() + minHeight + 1 <= world.getHeight())
        {
            if (!isSuitableLocation(world, pos, minHeight))
            {
                return false;
            }
            else
            {
                IBlockState state = world.getBlockState(pos.down());

                BlockPos pos01 = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
                BlockPos pos02 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
                BlockPos pos03 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
                BlockPos pos04 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);

                boolean isSoil0 = world.getBlockState(pos01.down()).getBlock().canSustainPlant(world.getBlockState(pos01.down()), world, pos01.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING);
                boolean isSoil1 = world.getBlockState(pos02.down()).getBlock().canSustainPlant(world.getBlockState(pos02.down()), world, pos02.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING);
                boolean isSoil2 = world.getBlockState(pos03.down()).getBlock().canSustainPlant(world.getBlockState(pos03.down()), world, pos03.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING);
                boolean isSoil3 = world.getBlockState(pos04.down()).getBlock().canSustainPlant(world.getBlockState(pos04.down()), world, pos04.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING);


                if (isSoil0 && isSoil1 && isSoil2 && isSoil3 && pos.getY() < world.getHeight() - minHeight - 1)
                {
                    for (int i = 0; i < minHeight; i++) {
                        //Logs / Leaves
                        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ());
                        BlockPos pos2 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ());
                        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - 1);
                        BlockPos pos4 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ() - 1);
                        BlockPos pos5 = new BlockPos(pos.getX() + 2, pos.getY() + i, pos.getZ());
                        BlockPos pos6 = new BlockPos(pos.getX() + 3, pos.getY() + i, pos.getZ());
                        BlockPos pos7 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - 2);
                        BlockPos pos8 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - 3);
                        BlockPos pos9 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ());
                        BlockPos pos10 = new BlockPos(pos.getX() - 2, pos.getY() + i, pos.getZ());
                        BlockPos pos11 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() + 2);
                        BlockPos pos12 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos13 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ() - 2);
                        BlockPos pos14 = new BlockPos(pos.getX() + 2, pos.getY() + i, pos.getZ() - 1);
                        //leaves
                        BlockPos pos15 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() + 3);
                        BlockPos pos16 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ() + 2);
                        BlockPos pos17 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() + 2);
                        BlockPos pos18 = new BlockPos(pos.getX() + 3, pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos19 = new BlockPos(pos.getX() + 2, pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos20 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos21 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos22 = new BlockPos(pos.getX() - 2, pos.getY() + i, pos.getZ() + 1);
                        BlockPos pos23 = new BlockPos(pos.getX() + 4, pos.getY() + i, pos.getZ());
                        BlockPos pos24 = new BlockPos(pos.getX() - 3, pos.getY() + i, pos.getZ());
                        BlockPos pos25 = new BlockPos(pos.getX() + 3, pos.getY() + i, pos.getZ() - 1);
                        BlockPos pos26 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() - 1);
                        BlockPos pos27 = new BlockPos(pos.getX() - 2, pos.getY() + i, pos.getZ() - 1);
                        BlockPos pos28 = new BlockPos(pos.getX() + 2, pos.getY() + i, pos.getZ() - 2);
                        BlockPos pos29 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() - 2);
                        BlockPos pos30 = new BlockPos(pos.getX() + 1, pos.getY() + i, pos.getZ() - 3);
                        BlockPos pos31 = new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() - 3);
                        BlockPos pos32 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - 4);

                        if (i < 8 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos1, LOG);
                            setBlockAndNotifyAdequately(world, pos4, LOG);
                        }

                        if (i < 3 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos2, LOG);
                            setBlockAndNotifyAdequately(world, pos3, LOG);
                        }
                        if (i == 2 + random) {
                            //leaves
                            setBlockAndNotifyAdequately(world, pos5, LEAVES);
                            setBlockAndNotifyAdequately(world, pos6, LEAVES);
                            setBlockAndNotifyAdequately(world, pos7, LEAVES);
                            setBlockAndNotifyAdequately(world, pos8, LEAVES);
                        }


                        if (i == 3 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos2, LOG1);
                            setBlockAndNotifyAdequately(world, pos3, LOG2);
                            setBlockAndNotifyAdequately(world, pos5, LOG1);
                            setBlockAndNotifyAdequately(world, pos6, LOG);
                            setBlockAndNotifyAdequately(world, pos7, LOG2);
                            setBlockAndNotifyAdequately(world, pos8, LOG);
                            //leaves
                            setBlockAndNotifyAdequately(world, pos13, LEAVES);
                            setBlockAndNotifyAdequately(world, pos14, LEAVES);
                            setBlockAndNotifyAdequately(world, pos18, LEAVES);
                            setBlockAndNotifyAdequately(world, pos19, LEAVES);
                            setBlockAndNotifyAdequately(world, pos20, LEAVES);
                            setBlockAndNotifyAdequately(world, pos23, LEAVES);
                            setBlockAndNotifyAdequately(world, pos25, LEAVES);
                            setBlockAndNotifyAdequately(world, pos26, LEAVES);
                            setBlockAndNotifyAdequately(world, pos29, LEAVES);
                            setBlockAndNotifyAdequately(world, pos30, LEAVES);
                            setBlockAndNotifyAdequately(world, pos31, LEAVES);
                            setBlockAndNotifyAdequately(world, pos32, LEAVES);
                        }

                        if (i == 4 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos1, LOG);
                            setBlockAndNotifyAdequately(world, pos4, LOG);
                            setBlockAndNotifyAdequately(world, pos6, LOG);
                            setBlockAndNotifyAdequately(world, pos8, LOG);
                            //leaves
                            setBlockAndNotifyAdequately(world, pos2, LEAVES);
                            setBlockAndNotifyAdequately(world, pos3, LEAVES);
                            setBlockAndNotifyAdequately(world, pos5, LEAVES);
                            setBlockAndNotifyAdequately(world, pos7, LEAVES);
                            setBlockAndNotifyAdequately(world, pos18, LEAVES);
                            setBlockAndNotifyAdequately(world, pos23, LEAVES);
                            setBlockAndNotifyAdequately(world, pos25, LEAVES);
                            setBlockAndNotifyAdequately(world, pos30, LEAVES);
                            setBlockAndNotifyAdequately(world, pos31, LEAVES);
                            setBlockAndNotifyAdequately(world, pos32, LEAVES);

                        }

                        if (i == 5 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos1, LOG);
                            setBlockAndNotifyAdequately(world, pos4, LOG);
                            //leaves
                            setBlockAndNotifyAdequately(world, pos6, LEAVES);
                            setBlockAndNotifyAdequately(world, pos8, LEAVES);
                            setBlockAndNotifyAdequately(world, pos9, LEAVES);
                            setBlockAndNotifyAdequately(world, pos10, LEAVES);
                            setBlockAndNotifyAdequately(world, pos11, LEAVES);
                            setBlockAndNotifyAdequately(world, pos12, LEAVES);
                        }

                        if (i == 6 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos1, LOG);
                            setBlockAndNotifyAdequately(world, pos4, LOG);
                            setBlockAndNotifyAdequately(world, pos9, LOG1);
                            setBlockAndNotifyAdequately(world, pos10, LOG);
                            setBlockAndNotifyAdequately(world, pos11, LOG);
                            setBlockAndNotifyAdequately(world, pos12, LOG2);
                            //leaves
                            setBlockAndNotifyAdequately(world, pos2, LEAVES);
                            setBlockAndNotifyAdequately(world, pos3, LEAVES);
                            setBlockAndNotifyAdequately(world, pos13, LEAVES);
                            setBlockAndNotifyAdequately(world, pos14, LEAVES);
                            setBlockAndNotifyAdequately(world, pos15, LEAVES);
                            setBlockAndNotifyAdequately(world, pos16, LEAVES);
                            setBlockAndNotifyAdequately(world, pos17, LEAVES);
                            setBlockAndNotifyAdequately(world, pos20, LEAVES);
                            setBlockAndNotifyAdequately(world, pos21, LEAVES);
                            setBlockAndNotifyAdequately(world, pos22, LEAVES);
                            setBlockAndNotifyAdequately(world, pos24, LEAVES);
                            setBlockAndNotifyAdequately(world, pos26, LEAVES);
                            setBlockAndNotifyAdequately(world, pos27, LEAVES);
                        }

                        if (i == 7 + random) {
                            //log
                            setBlockAndNotifyAdequately(world, pos10, LOG);
                            setBlockAndNotifyAdequately(world, pos11, LOG);
                            setBlockAndNotifyAdequately(world, pos13, LOG);
                            setBlockAndNotifyAdequately(world, pos14, LOG);
                            //leafes
                            setBlockAndNotifyAdequately(world, pos1, LEAVES);
                            setBlockAndNotifyAdequately(world, pos4, LEAVES);
                            setBlockAndNotifyAdequately(world, pos5, LEAVES);
                            setBlockAndNotifyAdequately(world, pos7, LEAVES);
                            setBlockAndNotifyAdequately(world, pos9, LEAVES);
                            setBlockAndNotifyAdequately(world, pos12, LEAVES);
                            setBlockAndNotifyAdequately(world, pos15, LEAVES);
                            setBlockAndNotifyAdequately(world, pos16, LEAVES);
                            setBlockAndNotifyAdequately(world, pos17, LEAVES);
                            setBlockAndNotifyAdequately(world, pos22, LEAVES);
                            setBlockAndNotifyAdequately(world, pos24, LEAVES);
                            setBlockAndNotifyAdequately(world, pos25, LEAVES);
                            setBlockAndNotifyAdequately(world, pos27, LEAVES);
                            setBlockAndNotifyAdequately(world, pos28, LEAVES);
                            setBlockAndNotifyAdequately(world, pos30, LEAVES);
                        }

                        if (i == 8 + random) {
                            //leafes
                            setBlockAndNotifyAdequately(world, pos10, LEAVES);
                            setBlockAndNotifyAdequately(world, pos11, LEAVES);
                            setBlockAndNotifyAdequately(world, pos13, LEAVES);
                            setBlockAndNotifyAdequately(world, pos14, LEAVES);
                        }
                    }
                        return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight)
    {
        boolean isSuitableLocation = true;

        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY)
        {
            int extraSpaceNeeded = 1;
            if (checkY == parBlockPos.getY())
            {
                extraSpaceNeeded = 0;
            }
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2)
            {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX)
            {
                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ)
                {
                    isSuitableLocation = isReplaceable(parWorld,blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;
    }
}

