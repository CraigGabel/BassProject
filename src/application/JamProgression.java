package application;

import java.util.LinkedList;

public class JamProgression
{
	int id = 0;
	String name = new String();
	String chordProgression = new String();
	LinkedList<Integer> chordIndex = new LinkedList<Integer>();

	public JamProgression()
	{
		chordIndex = new LinkedList<Integer>();
	}

	public JamProgression(JamProgression jamProgression)
	{
		id = jamProgression.id;
		name = jamProgression.name;
		chordProgression = jamProgression.chordProgression;

		chordIndex = new LinkedList<Integer>();

		for (Integer integer: jamProgression.chordIndex)
			chordIndex.add(integer);
	}

	public LinkedList<ChromaticScale> getChromaticScales(String rootNote1)
	{
		LinkedList<ChromaticScale> scales = new LinkedList<ChromaticScale>();

		int chordProgressionListIndex;
		for (chordProgressionListIndex = 0; chordProgressionListIndex < Main.chordProgressionList.size(); chordProgressionListIndex++)
		{
			if (Main.chordProgressionList.get(chordProgressionListIndex).name.equals(name));
			{
				break;
			}
		}

		int startingNoteIndex;
		for (startingNoteIndex = 0; startingNoteIndex < ChromaticScale.NOTE_SHARPS.length; startingNoteIndex++)
		{
			if (rootNote1.equals(ChromaticScale.NOTE_SHARPS[startingNoteIndex]) || rootNote1.equals(ChromaticScale.NOTE_FLATS[startingNoteIndex]))
			{
				 break;
			}
		}

		for (int j = 0; j < this.chordIndex.size(); j++)
		{
			//determine which key (root note) this chord is
			int totalInterval = 0;
			for (int k = 0; k < this.chordIndex.get(j)-1; k++)
			{
				totalInterval += Main.chordProgressionList.get(chordProgressionListIndex).interval.get(k);
			}
			String note = new String(ChromaticScale.NOTE_SHARPS[(startingNoteIndex + totalInterval)%ChromaticScale.SEMITONE_COUNT]);

			//calculates which chord type is
			Chords chord = Main.chordList.get(0);
			for (int k = 0; k < Main.chordList.size(); k++)
			{
				if (Main.chordProgressionList.get(chordProgressionListIndex).chord.get(this.chordIndex.get(j)-1).equals(Main.chordList.get(k).name))
				{
					chord = Main.chordList.get(k);
				}
			}

			scales.add(new ChromaticScale(chord.name, note, chord.intervals));
		}

		return scales;
	}
}
