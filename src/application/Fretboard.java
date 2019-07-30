package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

abstract public class Fretboard implements EventHandler<ActionEvent>
{
	static final int STRING_COUNT = 4;
	static final int FRET_COUNT = 13;
	final int[] STRING_SEMITONE_START = new int[] {0,5,10,3};
	Button[][] buttonArray = new Button[Fretboard.STRING_COUNT][FRET_COUNT];

	public Fretboard()
	{

	}

	abstract public void initFretboard();

	@Override
	abstract public void handle(ActionEvent event);

	abstract public void initButtonText();

	public void initButtonStyle()
	{
		for (Button[] buttonAry: buttonArray)
		{
			for (Button button: buttonAry)
			{
				button.setStyle("");
				button.setFont(new Font("Courier New", 12));
			}
		}
	}

	//creates buttons and places them in returning layout
	//usable once at the beginning of program...mostly
	//no external class dependencies
	public GridPane paintFretboard()
	{
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		Label eString = new Label("E");
		eString.setFont(new Font("Courier New", 12));
		GridPane.setConstraints(eString, 0, 0);
//		GridPane.setHalignment(eString, HPos.CENTER);
		GridPane.setMargin(eString, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(eString);

		Label aString = new Label("A");
		aString.setFont(new Font("Courier New", 12));
		GridPane.setConstraints(aString, 1, 0);
//		GridPane.setHalignment(aString, HPos.CENTER);
		GridPane.setMargin(aString, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(aString);

		Label dString = new Label("D");
		dString.setFont(new Font("Courier New", 12));
		GridPane.setConstraints(dString, 2, 0);
//		GridPane.setHalignment(dString, HPos.CENTER);
		GridPane.setMargin(dString, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(dString);

		Label gString = new Label("G");
		gString.setFont(new Font("Courier New", 12));
		GridPane.setConstraints(gString, 3, 0);
//		GridPane.setHalignment(gString, HPos.CENTER);
		GridPane.setMargin(gString, new Insets(0, 0, 0, 7));
		gridPane.getChildren().add(gString);

		Label[] fretLabels = new Label[6];

		initButtonText();
		initButtonStyle();

		for (int i = 0; i < Fretboard_Intervals.FRET_COUNT; i++)
		{
			int fretLabelCount = 0;

			for (int j = 0; j < Fretboard_Intervals.STRING_COUNT; j++)
			{
				GridPane.setConstraints(buttonArray[j][i], j, i+1);
				gridPane.getChildren().add(buttonArray[j][i]);
			}

			if ((i == 0) || (i == 3) || (i == 5) || (i == 7) || (i == 9) || (i == 12))
			{
				fretLabels[fretLabelCount] = new Label("" + i);
				fretLabels[fretLabelCount].setFont(new Font("Courier New", 12));
				GridPane.setConstraints(fretLabels[fretLabelCount], Fretboard_Intervals.STRING_COUNT, i+1);
				gridPane.getChildren().add(fretLabels[fretLabelCount]);
				fretLabelCount++;
			}
		}

		return gridPane;
	}

	abstract public void labelFretboard(ChromaticScale scale);
	abstract public void highlightFretboard(ChromaticScale scale);
}
