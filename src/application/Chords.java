package application;

import java.util.LinkedList;

public class Chords
{

    int id;
    String name;
    String symbol;
    LinkedList<Integer> intervals;

    public Chords()
    {
    	intervals = new LinkedList<Integer>();
    }

    public Chords(Chords chord)
    {
    	id = chord.id;
    	name = chord.name;
    	symbol = chord.symbol;

    	intervals = new LinkedList<Integer>();

    	for (Integer integer: chord.intervals)
    		intervals.add(integer);
    }

    public ChromaticScale getNotes()
    {
    	return new ChromaticScale(name, "", intervals);
    }
}
