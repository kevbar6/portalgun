package kevbar6.portalgun.objects.blocks.slab;

public class BlockDoubleSlabBase extends BlockSlabBase
{
	public BlockDoubleSlabBase(String name, float hardness, float resistance)
	{
		super(name, hardness, resistance);
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
}
