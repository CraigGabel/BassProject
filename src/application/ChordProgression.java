package application;

import java.util.LinkedList;

public class ChordProgression
{
	int id;
	String name;
	LinkedList<Integer> interval;
	LinkedList<String> chord;

	public ChordProgression()
	{
		interval = new LinkedList<Integer>();
		chord = new LinkedList<String>();
	}

	public ChordProgression(ChordProgression chordProgression)
	{
		id = chordProgression.id;
		name = chordProgression.name;

		interval = new LinkedList<Integer>();

		for (Integer integer: chordProgression.interval)
			interval.add(integer);

		chord = new LinkedList<String>();

		for (String string: chordProgression.chord)
			chord.add(string);
	}
}
