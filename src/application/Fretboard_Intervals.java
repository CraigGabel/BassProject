package application;

import javax.management.Descriptor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Fretboard_Intervals extends Fretboard
{
	public Fretboard_Intervals()
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
		for (int i = 0; i < Fretboard_Intervals.STRING_COUNT; i++)
		{
			for (int j = 0; j < Fretboard_Intervals.FRET_COUNT; j++)
			{
				buttonArray[i][j].setText(ChromaticScale.INTERVALS[(STRING_SEMITONE_START[i] + j)%ChromaticScale.SEMITONE_COUNT]);
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
					if (button.getText().equals(ChromaticScale.INTERVALS[k]))
						if (scale.semiToneSelection[k] == false)
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
					if (button.getText().equals(ChromaticScale.INTERVALS[k]))
						if (scale.semiToneSelection[k] == true)
							button.setStyle(Common.myCSSstring[1]);
				}
			}
		}
	}
}
