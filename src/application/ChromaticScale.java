package application;

import java.util.LinkedList;

public class ChromaticScale
{
	final static int SEMITONE_COUNT = 12;
	final static String[] INTERVALS = new String[] {"r", "m2", "M2", "m3", "M3", "P4",
                                             		"A4", "P5", "m6", "M6", "m7", "M7"};
	final static String[] NOTE_SHARPS = new String[] {"A", "A#", "B", "C", "C#", "D",
											   		  "D#", "E", "F", "F#", "G", "G#"};
	final static String[] NOTE_FLATS = new String[] {"A", "Bb", "B", "C", "Db", "D",
			   								  		 "Eb", "E", "F", "Gb", "G", "Ab"};

	boolean[] semiToneSelection = new boolean[] {false, false, false, false, false, false,
												 false, false, false, false, false, false};
	String rootNote = new String();
	String name = new String();

	public ChromaticScale()
	{

	}

	public ChromaticScale(ChromaticScale scale)
	{
		name = new String(scale.name);
		rootNote = new String(scale.rootNote);

		for (int i = 0; i < semiToneSelection.length; i++)
		{
			semiToneSelection[i] = scale.semiToneSelection[i];
		}
	}

	//used by scales & chords or anything with a linked list of intervals
	public ChromaticScale(String name, String rootNote, LinkedList<Integer> interval)
	{
		int intervalTotal = 0;

		semiToneSelection[intervalTotal] = true;
		for (int intervalIndex = 0; intervalIndex < interval.size(); intervalIndex++)
		{
			intervalTotal += interval.get(intervalIndex);
			semiToneSelection[intervalTotal%SEMITONE_COUNT] = true;
		}

		this.rootNote = rootNote;
		if (this.rootNote.equals(""))
		{
			this.rootNote = NOTE_SHARPS[7];
		}
		this.name = name;
	}

	public void setSemiToneSelection(LinkedList<Integer> interval)
	{
		int intervalTotal = 0;
		semiToneSelection = new boolean[] {false, false, false, false, false, false,
				 						   false, false, false, false, false, false};

		semiToneSelection[intervalTotal] = true;
		for (int intervalIndex = 0; intervalIndex < interval.size(); intervalIndex++)
		{
			intervalTotal += interval.get(intervalIndex);
			semiToneSelection[intervalTotal%SEMITONE_COUNT] = true;
		}
	}

	public int getChromaticScaleOffset()
	{
		int i;

		for (i = 0; i < SEMITONE_COUNT; i++)
		{
			if (rootNote.equals(NOTE_SHARPS[i]) || rootNote.equals(NOTE_FLATS[i]))
			{
				break;
			}
		}

		return i;
	}

	public LinkedList<String> getRootApproachNotes()
	{
		final int[] approachIntervals = new int[] {-2,-1,1,2,7};
		LinkedList<String> approachNotes = new LinkedList<String>();

		if ((rootNote != null) && (rootNote != ""))
		{
			int semiToneOffset = 0;
			for (semiToneOffset = 0; semiToneOffset < NOTE_SHARPS.length; semiToneOffset++)
			{
				if (NOTE_SHARPS[semiToneOffset].equals(rootNote) || NOTE_FLATS[semiToneOffset].equals(rootNote))
				{
					break;
				}
			}

			for (int i = 0; i < approachIntervals.length; i++)
			{
				approachNotes.add(NOTE_SHARPS[(12+semiToneOffset+approachIntervals[i])%12]);
			}
		}

		return approachNotes;
	}

	public String toStringIntervals()
	{
		String string = new String();

		for (int i = 0; i < semiToneSelection.length; i++)
		{
			if (semiToneSelection[i] == true)
			{
				if (i != 0)
				{
					string += " ";
				}
				string += INTERVALS[i];
				if (INTERVALS[i].length() == 1)
					string += " ";
			}
		}

		return string;
	}

	public String toStringNotes()
	{
		String string = new String();

		if ((rootNote != null) && (rootNote != ""))
		{
			int semiToneOffset = 0;
			for (int i = 0; i < NOTE_SHARPS.length; i++)
			{
				if (NOTE_SHARPS[i].equals(rootNote) || NOTE_FLATS[i].equals(rootNote))
				{
					semiToneOffset = i;
					break;
				}
			}

			for (int i = 0; i < semiToneSelection.length; i++)
			{
				if (semiToneSelection[i] == true)
				{
					if (i != 0)
					{
						string += " ";
					}
					string += NOTE_SHARPS[(i + semiToneOffset)%ChromaticScale.SEMITONE_COUNT];
					if (NOTE_SHARPS[(i + semiToneOffset)%ChromaticScale.SEMITONE_COUNT].length() == 1)
						string += " ";
				}
			}
		}

		return string;
	}
}
