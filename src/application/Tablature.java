package application;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class Tablature
{
	Label title;
	Label eString;
	Label aString;
	Label dString;
	Label gString;
	Label blankLine;
	Label eString2;
	Label aString2;
	Label dString2;
	Label gString2;
	Label eStringPtr;
	Label aStringPtr;
	Label dStringPtr;
	Label gStringPtr;

	public Tablature()
	{

	}

	public VBox initTablature()
	{
		VBox vbox = new VBox();

		title = new Label("!Empty");
		eString = new Label("--E|");
		eString.setFont(new Font("Courier New", 12));
		aString = new Label("--A|");
		aString.setFont(new Font("Courier New", 12));
		dString = new Label("--D|");
		dString.setFont(new Font("Courier New", 12));
		gString = new Label("--G|");
		gString.setFont(new Font("Courier New", 12));
		blankLine = new Label("");
		blankLine.setFont(new Font("Courier New", 12));
		eString2 = new Label("");
		eString2.setFont(new Font("Courier New", 12));
		aString2 = new Label("");
		aString2.setFont(new Font("Courier New", 12));
		dString2 = new Label("");
		dString2.setFont(new Font("Courier New", 12));
		gString2 = new Label("");
		gString2.setFont(new Font("Courier New", 12));

//		TextField textField = new TextField();

		for (int measureIndex = 0; measureIndex < Licks.MAX_MEASURES_PER_LINE; measureIndex++)
		{
			for (int noteIndex = 0; noteIndex < Licks.NOTES_PER_MEASURE; noteIndex++)
			{
					eString.setText(eString.getText() + "--");
					aString.setText(aString.getText() + "--");
					dString.setText(dString.getText() + "--");
					gString.setText(gString.getText() + "--");
			}

			eString.setText(eString.getText() + "-|");
			aString.setText(aString.getText() + "-|");
			dString.setText(dString.getText() + "-|");
			gString.setText(gString.getText() + "-|");
		}

		vbox.getChildren().addAll(title, eString, aString, dString, gString, blankLine, eString2, aString2, dString2, gString2);

		return vbox;
	}

	public void buildTab(Licks lick)
	{
		title.setText(lick.name);
		eString.setText("--E|");
		aString.setText("--A|");
		dString.setText("--D|");
		gString.setText("--G|");
		eString2.setText("");
		aString2.setText("");
		dString2.setText("");
		gString2.setText("");

		//--G-|-----------------|-----------------|-----------------|-----------------|
		//--D-|-----------------|-2-----2---------|-----------------|-2-----2-5-4-2-0-|
		//--A-|-3-----3-5-----5-|---------5-----5-|-3-----3-5-----5-|-----------------|
		//--E-|01234567890123456|-----------------|-----------------|-----------------|

		int measureCount = 0;

		for (int measureIndex = 0; measureIndex < Licks.MAX_MEASURE_COUNT; measureIndex++)
		{
			if (lick.measure[measureIndex].noteCount != 0)
			{
				if ((measureIndex+1) > measureCount)
				{
					measureCount = measureIndex+1;
				}
			}
		}

		if (measureCount > Licks.MAX_MEASURES_PER_LINE)
		{

			eString2.setText("--E|");
			aString2.setText("--A|");
			dString2.setText("--D|");
			gString2.setText("--G|");
		}

		for (int measureIndex = 0; measureIndex < measureCount; measureIndex++)
		{
//			if (lick.measure[measureIndex].noteCount == 0)
//			{
//				eString.setText(eString.getText() + "-|");
//				aString.setText(aString.getText() + "-|");
//				dString.setText(dString.getText() + "-|");
//				gString.setText(gString.getText() + "-|");
//				break;
//			}

			if (measureIndex < Licks.MAX_MEASURES_PER_LINE)
			{
				eStringPtr = eString;
				aStringPtr = aString;
				dStringPtr = dString;
				gStringPtr = gString;
			}
			else
			{
				eStringPtr = eString2;
				aStringPtr = aString2;
				dStringPtr = dString2;
				gStringPtr = gString2;
			}

			for (int noteIndex = 0; noteIndex < Licks.NOTES_PER_MEASURE; noteIndex++)
			{
				if ((lick.measure[measureIndex].note[noteIndex] != null) && (lick.measure[measureIndex].note[noteIndex].contains("E")))
				{
					eStringPtr.setText(eStringPtr.getText() + "-" + lick.measure[measureIndex].note[noteIndex].substring(1));
				}
				else
				{
					eStringPtr.setText(eStringPtr.getText() + "--");
				}

				if ((lick.measure[measureIndex].note[noteIndex] != null) && (lick.measure[measureIndex].note[noteIndex].contains("A")))
				{
					aStringPtr.setText(aStringPtr.getText() + "-" + lick.measure[measureIndex].note[noteIndex].substring(1));
				}
				else
				{
					aStringPtr.setText(aStringPtr.getText() + "--");
				}

				if ((lick.measure[measureIndex].note[noteIndex] != null) && (lick.measure[measureIndex].note[noteIndex].contains("D")))
				{
					dStringPtr.setText(dStringPtr.getText() + "-" + lick.measure[measureIndex].note[noteIndex].substring(1));
				}
				else
				{
					dStringPtr.setText(dStringPtr.getText() + "--");
				}

				if ((lick.measure[measureIndex].note[noteIndex] != null) && (lick.measure[measureIndex].note[noteIndex].contains("G")))
				{
					gStringPtr.setText(gStringPtr.getText() + "-" + lick.measure[measureIndex].note[noteIndex].substring(1));
				}
				else
				{
					gStringPtr.setText(gStringPtr.getText() + "--");
				}
			}


			eStringPtr.setText(eStringPtr.getText() + "-|");
			aStringPtr.setText(aStringPtr.getText() + "-|");
			dStringPtr.setText(dStringPtr.getText() + "-|");
			gStringPtr.setText(gStringPtr.getText() + "-|");
		}
	}
}
