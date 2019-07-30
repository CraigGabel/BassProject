package application;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Fretboard_Notes extends Fretboard
{
	public final int STARTING_NOTE_OFFSET = 7;

	public Fretboard_Notes()
	{

	}

	public void initFretboard()
	{
		for (int i = 0; i < Fretboard_Intervals.STRING_COUNT; i++)
		{
			for (int j = 0; j < Fretboard_Intervals.FRET_COUNT; j++)
			{
				buttonArray[i][j] = new Button();
				buttonArray[i][j].setMaxSize(40, 30);
				buttonArray[i][j].setMinSize(40, 30);
				buttonArray[i][j].setOnAction(this);
			}
		}
	}

	@Override
	public void handle(ActionEvent event)
	{
		for (Button[] buttonAry: buttonArray)
		{
			for (Button button: buttonAry)
			{
				if (event.getSource() == button)
				{
					String buttonCSS = button.getStyle();

					for (int k = 0; k < Common.myCSSstring.length; k++)
					{
						if (buttonCSS.equals(Common.myCSSstring[k]))
						{
							button.setStyle(Common.myCSSstring[(k+1)%Common.myCSSstring.length]);
							break;
						}
					}

					return;
				}
			}
		}
	}

	public void initButtonText()
	{
		for (int i = 0; i < Fretboard_Notes.STRING_COUNT; i++)
		{
			for (int j = 0; j < Fretboard_Notes.FRET_COUNT; j++)
			{
				buttonArray[i][j].setText(ChromaticScale.NOTE_SHARPS[(STRING_SEMITONE_START[i] + j + STARTING_NOTE_OFFSET)%ChromaticScale.SEMITONE_COUNT]);
			}
		}
	}

	public void labelFretboard(ChromaticScale scale)
	{
		initButtonText();
		initButtonStyle();

		for (Button[] buttonAry: buttonArray)
		{
			for (Button button: buttonAry)
			{
				for (int k = 0; k < ChromaticScale.SEMITONE_COUNT; k++)
				{
					if ((button.getText().equals(ChromaticScale.NOTE_SHARPS[k])) || (button.getText().equals(ChromaticScale.NOTE_FLATS[k])))
						if (scale.semiToneSelection[(ChromaticScale.SEMITONE_COUNT+k-scale.getChromaticScaleOffset())%ChromaticScale.SEMITONE_COUNT] == false)
							button.setText("");
				}
			}
		}
	}

	public void highlightFretboard(ChromaticScale scale)
	{
		initButtonStyle();

		for (Button[] buttonAry: buttonArray)
		{
			for (Button button: buttonAry)
			{
				for (int k = 0; k < ChromaticScale.SEMITONE_COUNT; k++)
				{
					if ((button.getText().equals(ChromaticScale.NOTE_SHARPS[k])) || (button.getText().equals(ChromaticScale.NOTE_FLATS[k])))
						if (scale.semiToneSelection[(ChromaticScale.SEMITONE_COUNT+k-scale.getChromaticScaleOffset())%ChromaticScale.SEMITONE_COUNT] == true)
							button.setStyle(Common.myCSSstring[1]);
				}
			}
		}
	}

	public void highlightNotes(LinkedList<String> notes, String cssString)
	{
		for (Button[] buttonAry: buttonArray)
		{
			for (Button button: buttonAry)
			{
				for (int k = 0; k < notes.size(); k++)
				{
					if (button.getText().equals(notes.get(k)))
					{
						button.setStyle(cssString);
						break;
					}
				}
			}
		}
	}
}