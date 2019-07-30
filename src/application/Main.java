
package application;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application
{
	public static LinkedList<Scale>	    	   scaleList			= new LinkedList<Scale>();
	public static LinkedList<Chords>		   chordList			= new LinkedList<Chords>();
	public static LinkedList<Licks>			   lickList				= new LinkedList<Licks>();
	public static LinkedList<ChordProgression> chordProgressionList = new LinkedList<ChordProgression>();
	public static LinkedList<JamProgression>   jamProgressionList   = new LinkedList<JamProgression>();

	Fretboard_Intervals	fretboardIntervals;
	Fretboard_Notes		fretboardNotes;
	Tablature			tablature;
	String				rootNote;

	public static void main(String[] args)
	{
		launch(args);
	}

	private EventHandler<ActionEvent> showScale()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (Scale scale: scaleList)
				{
					if (scale.name.equals(mItem.getParentMenu().getText()))
					{
						for (Modes mode: scale.modes)
						{
							if (mode.name.equals(mItem.getText()))
							{
								ChromaticScale chromaticScale = new ChromaticScale(scale.name + " - " + rootNote + " " + mode.name,
										                                  		   rootNote,
										                                  		   scale.getIntervals(mode.offset));

								System.out.println(chromaticScale.name);
								System.out.println(chromaticScale.toStringIntervals());
								System.out.println(chromaticScale.toStringNotes());
								System.out.println();
								fretboardIntervals.labelFretboard(chromaticScale);
//								fretboardIntervals.highlightFretboard(chromaticScale);
								fretboardNotes.labelFretboard(chromaticScale);
//								fretboardNotes.highlightFretboard(chromaticScale);
							}
						}
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> showChord()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (Chords chord: chordList)
				{
					if (chord.name.equals(mItem.getText()))
					{
						ChromaticScale chromaticScale = new ChromaticScale(rootNote + " " + chord.name,
								  										   rootNote,
								  										   chord.intervals);

						System.out.println(chromaticScale.name);
						System.out.println(chromaticScale.toStringIntervals());
						System.out.println(chromaticScale.toStringNotes());
						System.out.println();
//						fretboardIntervals.labelFretboard(scale);
						fretboardIntervals.highlightFretboard(chromaticScale);
//						fretboardNotes.labelFretboard(scale);
						fretboardNotes.highlightFretboard(chromaticScale);
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> showLick()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (Licks lick: lickList)
				{
					if (lick.name == mItem.getText())
					{
						System.out.println(lick.name);
						System.out.println();
						tablature.buildTab(lick);
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> setRootNote()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();
				rootNote = mItem.getText();
			}
		};
	}

	private EventHandler<ActionEvent> showJamProgression()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (JamProgression jamProgression: jamProgressionList)
				{
					if (jamProgression.name == mItem.getText())
					{
						LinkedList<ChromaticScale> scales = new LinkedList<ChromaticScale>();

						ScaleWindow scaleWindow = new ScaleWindow();
						scaleWindow.initScaleWindow();
						scaleWindow.setWindowTitle(rootNote + " - " + jamProgression.name);

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
					}
				}
			}
		};
	}

	public MenuBar mainMenu()
	{
		Menu menu1 = new Menu("Scales");

		for (Scale scale: scaleList)
		{
			EventHandler<ActionEvent> action = showScale();

			if (scale.modes.size() > 0)
			{
				Menu subMenu = new Menu(scale.name);
				for (Modes mode: scale.modes)
				{
					MenuItem menuItem = new MenuItem(mode.name);
					menuItem.setOnAction(action);
					subMenu.getItems().add(menuItem);
				}
				menu1.getItems().add(subMenu);
			}
			else
			{
				MenuItem menuItem = new MenuItem(scale.name);
				menuItem.setOnAction(action);
				menu1.getItems().add(menuItem);
			}
		}

		Menu menu2 = new Menu("Chords");

		for (Chords chord: chordList)
		{
			EventHandler<ActionEvent> action = showChord();
			MenuItem menuItem = new MenuItem(chord.name);
			menuItem.setOnAction(action);
			menu2.getItems().add(menuItem);
		}

		Menu menu3 = new Menu("Licks");

		for (Licks lick: lickList)
		{
			EventHandler<ActionEvent> action = showLick();
			MenuItem menuItem = new MenuItem(lick.name);
			menuItem.setOnAction(action);
			menu3.getItems().add(menuItem);
		}

		Menu menu4 = new Menu("Jam Progressions");

		for (JamProgression jamProgression: jamProgressionList)
		{
			EventHandler<ActionEvent> action = showJamProgression();
			MenuItem menuItem = new MenuItem(jamProgression.name);
			menuItem.setOnAction(action);
			menu4.getItems().add(menuItem);
		}

		Menu menu5 = new Menu("Root Note");
		ToggleGroup rootNoteToggleGroup = new ToggleGroup();

		for (String string: ChromaticScale.NOTE_SHARPS)
		{
			EventHandler<ActionEvent> action = setRootNote();
			RadioMenuItem radioItem = new RadioMenuItem(string);
			radioItem.setOnAction(action);
			radioItem.setToggleGroup(rootNoteToggleGroup);
			menu5.getItems().add(radioItem);
		}

		rootNoteToggleGroup.getToggles().get(7).setSelected(true);
		rootNote = ChromaticScale.NOTE_SHARPS[7];

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);

		return menuBar;
	}

	@Override
	public void start(Stage primaryStage)
	{
		// db interface
		DB_Interface db_interface = new DB_Interface(); // create interface to database
		//read data from databases
		scaleList = db_interface.readDB_Scales();
		lickList = db_interface.readDB_Licks();
		chordList = db_interface.readDB_Chords();
		chordProgressionList = db_interface.readDB_ChordProgression();
		jamProgressionList = db_interface.readDB_JamProgression();
		// end of db interface

		ChromaticScale testScale = new ChromaticScale(ChromaticScale.NOTE_SHARPS[3] + " " + chordList.get(0).name, ChromaticScale.NOTE_SHARPS[3], chordList.get(0).intervals);
		System.out.println(testScale.name);
		System.out.println(testScale.toStringIntervals());
		System.out.println(testScale.toStringNotes());

		// left pane - fretboard, intervals
		fretboardIntervals = new Fretboard_Intervals();
		fretboardIntervals.initFretboard();
		GridPane leftPane = fretboardIntervals.paintFretboard();
		// end of left pane

		// right pane - fretboard, notes
		fretboardNotes = new Fretboard_Notes();
		fretboardNotes.initFretboard();
		GridPane rightPane = fretboardNotes.paintFretboard();
		// end of right pane

		// bottom pane - tablature to display lick
		tablature = new Tablature();
		VBox bottomPane = tablature.initTablature();
		bottomPane.setPadding(new Insets(0, 20, 0, 20));
		// end of bottom pane

		// layout
		// top pane - menubar
		VBox topPane = new VBox();
		topPane.setPadding(new Insets(0, 0, 0, 0));

		topPane.getChildren().addAll(mainMenu());

		// end of top pane

		// border pane - combines the other panes to the main layout
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topPane);
		borderPane.setLeft(leftPane);
		borderPane.setRight(rightPane);
		borderPane.setBottom(bottomPane);
		// end of border pane
		// end of layout

		// Scene - create scene with border pane layout
		Scene scene = new Scene(borderPane);
		// end of scene

		// window (stage) stuff
		Stage window;
		window = primaryStage;
		window.setTitle("the window");
		window.setScene(scene);
		window.show();
		// end of window stuff

		WalkingBass walkingBass = new WalkingBass();
		walkingBass.doTheThing();
	}
}
