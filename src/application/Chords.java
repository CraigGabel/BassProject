package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

////v1
//public class Chords
//{
//
//    int id;
//    String name;
//    String symbol;
//    LinkedList<Integer> intervals;
//
//    public Chords()
//    {
//    	intervals = new LinkedList<Integer>();
//    }
//
//    public Chords(Chords chord)
//    {
//    	id = chord.id;
//    	name = chord.name;
//    	symbol = chord.symbol;
//
//    	intervals = new LinkedList<Integer>();
//
//    	for (Integer integer: chord.intervals)
//    		intervals.add(integer);
//    }
//}

//v2
public class Chords
{
	String group;
    HashMap<String, LinkedList<Integer>> chordMembers;

    public Chords()
    {
    	chordMembers = new HashMap<>();
    }

    public Chords(Chords chord)
    {
    	group = chord.group;

    	chordMembers = new HashMap<>();

    	for (Map.Entry<String, LinkedList<Integer>> entry : chord.chordMembers.entrySet())
    	{
    		chordMembers.put(entry.getKey(), entry.getValue());
    	}
    }
}
