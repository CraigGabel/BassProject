package application;

import java.util.LinkedList;
import java.util.Random;

public class WalkingBass
{
	public WalkingBass()
	{

	}

	public void doTheThing()
	{
		String rootNote = "E";
		JamProgression jamProgression = Main.jamProgressionList.get(0);

		LinkedList<ChromaticScale> scales = new LinkedList<ChromaticScale>();

		ScaleWindow scaleWindow = new ScaleWindow();
		scaleWindow.initScaleWindow();
		scaleWindow.setWindowTitle("testing");

		scales = jamProgression.getChromaticScales(rootNote);

		for (ChromaticScale scale: scales)
		{
			scaleWindow.addScale(scale);
		}

		scaleWindow.initCenterPane();
		scaleWindow.updateCenterPaneObjects();
		scaleWindow.updateCenterPaneData();
		scaleWindow.updateCenterPaneLayout();
		scaleWindow.initTopPane();
		scaleWindow.addDefaultMenusMainMenu();
	    scaleWindow.paintWindow();

	    for (int i = 0; i < scaleWindow.scales.size(); i++)
	    {
	    	LinkedList<String> approachNotes = new LinkedList<>();

	    	approachNotes = scaleWindow.scales.get(i).getRootApproachNotes();
	    	int count = approachNotes.size();
	    	for (int j = 0; j < count-2; j++)
	    	{
	    		Random random = new Random();
	    		approachNotes.remove(random.nextInt(approachNotes.size()));
	    	}

	    	scaleWindow.scaleFretboards.get(i).highlightNotes(approachNotes, Common.myCSSstring[2]);
//	    	approachNotes.clear();
//	    	approachNotes.add(scaleWindow.scales.get(i).rootNote);
//	    	scaleWindow.scaleFretboards.get(i).highlightNotes(approachNotes, Common.myCSSstring[3]);
	    }
	}
}
