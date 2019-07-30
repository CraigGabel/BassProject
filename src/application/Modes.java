package application;

public class Modes
{
	String name;
	int offset;

	public Modes()
	{

	}

	public Modes(Modes mode)
	{
		name = mode.name;
		offset = mode.offset;
	}
}
