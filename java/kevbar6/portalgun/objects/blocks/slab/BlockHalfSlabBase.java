package kevbar6.portalgun.objects.blocks.slab;

public class BlockHalfSlabBase extends BlockSlabBase
{
	public BlockHalfSlabBase(String name, float hardness, float resistance)
	{
		super(name, hardness, resistance);
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}

}
