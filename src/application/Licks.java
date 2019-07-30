package application;

public class Licks
{
	static final int MAX_MEASURE_COUNT = 8;
	static final int NOTES_PER_MEASURE = 8;
	static final int MAX_MEASURES_PER_LINE = 4;
	static final int STRING_COUNT = 4;

	public class Measure
	{
		int noteCount;
		String[] note = new String[NOTES_PER_MEASURE];
	}

	int id;
	int lickVersion;
    String name;

	Measure[] measure = new Measure[MAX_MEASURE_COUNT];

    public Licks()
    {
    	for (int i = 0; i < Licks.MAX_MEASURE_COUNT; i++)
    	{
    		measure[i] = new Measure();
    	}
    }

    public Licks(Licks lick)
    {
    	for (int i = 0; i < Licks.MAX_MEASURE_COUNT; i++)
    	{
    		measure[i] = new Measure();
    	}

        id = lick.id;
        lickVersion = lick.lickVersion;
        name = lick.name;

        for (int i = 0; i < Licks.MAX_MEASURE_COUNT; i++)
		{
			measure[i].noteCount = lick.measure[i].noteCount;

			for (int j = 0; j < Licks.NOTES_PER_MEASURE; j++)
			{
				measure[i].note[j] = lick.measure[i].note[j];
			}
		}
    }
}
