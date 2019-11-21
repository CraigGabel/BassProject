package application;

import java.util.LinkedList;

public class Scale
{
	public String group;
	LinkedList<Modes> modes;
	LinkedList<Integer> intervals;

	public Scale()
	{
		modes = new LinkedList<Modes>();
		intervals = new LinkedList<Integer>();
	}

	public Scale(Scale scale)
	{
		group = scale.group;

		modes = new LinkedList<Modes>();

		for (int i = 0; i < scale.modes.size(); i++)
		{
			Modes mode = new Modes();
			mode.name = scale.modes.get(i).name;
			mode.offset = scale.modes.get(i).offset;
			modes.add(mode);
		}

		intervals = new LinkedList<Integer>();

		for (int i = 0; i < scale.intervals.size(); i++)
		{
			intervals.add(new Integer(scale.intervals.get(i)));
		}
	}

	public LinkedList<Integer> getIntervals(int modeOffset)
	{
		LinkedList<Integer> tempIntervals = new LinkedList<>();

		for (int intervalsIndex = 0; intervalsIndex < intervals.size(); intervalsIndex++)
		{
			tempIntervals.add(new Integer(intervals.get(intervalsIndex)));
		}

		for (int rotateCount = 0; rotateCount < modeOffset; rotateCount++)
		{
			tempIntervals.add(tempIntervals.removeFirst());
		}

		return tempIntervals;
	}
}
