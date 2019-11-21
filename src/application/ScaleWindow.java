package application;

import java.awt.CheckboxMenuItem;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScaleWindow
{
	Stage window;
	String windowTitle;
	Scene scene;
	Scene blankScene = new Scene(new BorderPane());
	BorderPane borderPane;

	GridPane leftPane;
	GridPane centerPane;
	GridPane rightPane;
	GridPane bottomPane;
	VBox topPane;

	//center pane stuff
	LinkedList<ChromaticScale> scales;
//	LinkedList<Integer> highlightApproachNotes;
	LinkedList<MenuBar> scaleMenus;
	LinkedList<Text> scaleLabels;
	LinkedList<Fretboard_Notes> scaleFretboards;
	LinkedList<GridPane> scaleFretboardPanes;
	Button buttonNewScale;

	//top pane stuff
	MenuBar mainMenu;

	public ScaleWindow()
	{
		scales = new LinkedList<ChromaticScale>();
//		highlightApproachNotes = new LinkedList<Integer>();
		windowTitle = new String("new window");
//		initScaleWindow();
	}

	public void setWindowTitle(String string)
	{
		windowTitle = new String(string);
	}

	public int addScale(ChromaticScale scale)
	{
		scales.add(scale);

		int scaleIndex = 0xFF;
		for (int i = 0; i < scales.size(); i++)
		{
			if (scales.get(i).equals(scale))
			{
				scaleIndex = i;
				break;
			}
		}
		return scaleIndex;
	}

	public ChromaticScale removeScale(int scaleIndex)
	{
		return scales.remove(scaleIndex);
	}

	public boolean removeScale(ChromaticScale scale)
	{
		return scales.remove(scale);
	}

	public void initScaleWindow()
	{
		window = new Stage();
		borderPane = new BorderPane();

		leftPane = new GridPane();
		leftPane.setPadding(new Insets(20,20,20,20));
		leftPane.setVgap(5);
		leftPane.setHgap(5);

		centerPane = new GridPane();
		centerPane.setPadding(new Insets(20,20,20,20));
		centerPane.setVgap(5);
		centerPane.setHgap(5);

		rightPane = new GridPane();
		rightPane.setPadding(new Insets(20,20,20,20));
		rightPane.setVgap(5);
		rightPane.setHgap(5);

		topPane = new VBox();
		topPane.setPadding(new Insets(0, 0, 0, 0));

//		scales = new LinkedList<ChromaticScale>();
//		scaleMenus = new LinkedList<MenuBar>();
//		scaleLabels = new LinkedList<Label>();
//		scaleFretboards = new LinkedList<Fretboard_Notes>();
	}

	private EventHandler<ActionEvent> setRootNote(int scaleIndex)
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();
				scales.get(scaleIndex).rootNote = mItem.getText();

//				window.close();
//				initScaleWindow();
//				fillCenterPane2();
				updateCenterPaneData();
				window.sizeToScene();
//				paintWindow();
			}
		};
	}

	private EventHandler<ActionEvent> setScale(int scaleIndex)
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (int i = 0; i < Main.scaleList.size(); i++)
				{
					if (Main.scaleList.get(i).group.equals(mItem.getParentMenu().getText()))
					{
						for (int j = 0; j < Main.scaleList.get(i).modes.size(); j++)
						{
							if (Main.scaleList.get(i).modes.get(j).name.equals(mItem.getText()))
							{
								scales.get(scaleIndex).setSemiToneSelection(Main.scaleList.get(i).getIntervals(j));
								scales.get(scaleIndex).name = Main.scaleList.get(i).group + " " + Main.scaleList.get(i).modes.get(j).name;

//								window.close();
//								initScaleWindow();
//								fillCenterPane2();
								updateCenterPaneData();
								window.sizeToScene();
//								paintWindow();
							}
						}
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> setChord(int scaleIndex)
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				for (int i = 0; i < Main.chordList.size(); i++)
				{
					if (Main.chordList.get(i).group.equals(mItem.getParentMenu().getText()))
					{
						for (Map.Entry<String, LinkedList<Integer>> entry : Main.chordList.get(i).chordMembers.entrySet())
						{
							if (entry.getKey().equals(mItem.getText()))
							{
								scales.get(scaleIndex).setSemiToneSelection(entry.getValue());
								scales.get(scaleIndex).name = entry.getKey();

//								window.close();
//								initScaleWindow();
//								fillCenterPane2();
								updateCenterPaneData();
								window.sizeToScene();
//								paintWindow();
							}
						}
					}
				}
			}
		};
	}

	private EventHandler<ActionEvent> dropScale(int scaleIndex)
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

				if (mItem.getText().toLowerCase().contains("this"))
				{
//					LinkedList<ChromaticScale> scales;
//					LinkedList<MenuBar> scaleMenus;
//					LinkedList<Text> scaleLabels;
//					LinkedList<Fretboard_Notes> scaleFretboards;
//					LinkedList<GridPane> scaleFretboardPanes;

					scales.remove(scaleIndex);
//					highlightApproachNotes.remove(scaleIndex);
					scaleMenus.remove(scaleIndex);
					scaleLabels.remove(scaleIndex);
					scaleFretboards.remove(scaleIndex);
					scaleFretboardPanes.remove(scaleIndex);
				}
				else
				{
					ChromaticScale scale = scales.get(scaleIndex);
//					Integer highlightApproachNotes1 = highlightApproachNotes.get(scaleIndex);
					MenuBar menuBar = scaleMenus.get(scaleIndex);
					Text label = scaleLabels.get(scaleIndex);
					Fretboard_Notes fretboard = scaleFretboards.get(scaleIndex);
					GridPane gridPane = scaleFretboardPanes.get(scaleIndex);

					int scaleCount = scales.size();
					for (int i = 0; i < scaleCount; i++)
					{
						scales.remove();
//						highlightApproachNotes.remove();
						scaleMenus.remove();
						scaleLabels.remove();
						scaleFretboards.remove();
						scaleFretboardPanes.remove();
					}
					scales.add(scale);
//					highlightApproachNotes.add(highlightApproachNotes1);
					scaleMenus.add(menuBar);
					scaleLabels.add(label);
					scaleFretboards.add(fretboard);
					scaleFretboardPanes.add(gridPane);
				}

//				window.close();

//				initScaleWindow();
				initCenterPane();
				updateCenterPaneObjects();
				updateCenterPaneData();
				updateCenterPaneLayout();
				window.sizeToScene();

//				paintWindow();
			}
		};
	}

	private EventHandler<ActionEvent> highlightRootApproachNotes(int scaleIndex)
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				MenuItem mItem = (MenuItem) event.getSource();

//				if (highlightApproachNotes.get(scaleIndex).intValue() != 0)
//				{
//					highlightApproachNotes.set(scaleIndex, new Integer(0));
//				}
//				else
//				{
//					highlightApproachNotes.set(scaleIndex, new Integer(1));
//				}
			}
		};
	}

	private EventHandler<ActionEvent> newScale()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				scales.add(new ChromaticScale(Main.scaleList.get(0).group + " " + Main.scaleList.get(0).modes.get(0).name,
			                                  ChromaticScale.NOTE_SHARPS[0],
			                                  Main.scaleList.get(0).getIntervals(0)));
//				highlightApproachNotes.add(new Integer(0));
				scaleMenus.add(new MenuBar());
				scaleLabels.add(new Text());
				scaleFretboards.add(new Fretboard_Notes());

				initCenterPane();
				updateCenterPaneObjects();
				updateCenterPaneData();
				updateCenterPaneLayout();
				window.sizeToScene();
			}
		};
	}

	public void initCenterPane()
	{
		scaleMenus = new LinkedList<MenuBar>();
		scaleLabels = new LinkedList<Text>();
		scaleFretboards = new LinkedList<Fretboard_Notes>();
		scaleFretboardPanes = new LinkedList<GridPane>();
		buttonNewScale = new Button();

		for (int i = 0; i < scales.size(); i++)
		{
			scaleMenus.add(new MenuBar());
			scaleLabels.add(new Text());
			Fretboard_Notes fretboard = new Fretboard_Notes();
			fretboard.initFretboard();
			scaleFretboards.add(fretboard);
			scaleFretboards.get(i).initFretboard();
			scaleFretboardPanes.add(new GridPane());
		}
	}

	public void updateCenterPaneObjects()
	{
		for (int i = 0; i < scales.size(); i++)
		{
			Menu menu0 = new Menu("Root Note");

			for (int j = 0; j < ChromaticScale.SEMITONE_COUNT; j++)
			{
				EventHandler<ActionEvent> action = setRootNote(i);
				MenuItem menuItem = new MenuItem(ChromaticScale.NOTE_SHARPS[j]);
				menuItem.setOnAction(action);
				menu0.getItems().add(menuItem);
			}

			Menu menu1 = new Menu("Scales");

			for (int j = 0; j < Main.scaleList.size(); j++)
			{
				EventHandler<ActionEvent> action = setScale(i);

				if (Main.scaleList.get(j).modes.size() > 0)
				{
					Menu subMenu = new Menu(Main.scaleList.get(j).group);
					for (int k = 0; k < Main.scaleList.get(j).modes.size(); k++)
					{
						MenuItem menuItem = new MenuItem(Main.scaleList.get(j).modes.get(k).name);
						menuItem.setOnAction(action);
						subMenu.getItems().add(menuItem);
					}
					menu1.getItems().add(subMenu);
				}
				else
				{
					MenuItem menuItem = new MenuItem(Main.scaleList.get(j).group);
					menuItem.setOnAction(action);
					menu1.getItems().add(menuItem);
				}
			}

			Menu menu2 = new Menu("Chords");

			for (int j = 0; j < Main.chordList.size(); j++)
			{
				EventHandler<ActionEvent> action = setScale(i);

				Menu subMenu = new Menu(Main.chordList.get(j).group);
				for (Map.Entry<String, LinkedList<Integer>> entry : Main.chordList.get(j).chordMembers.entrySet())
				{
					MenuItem menuItem = new MenuItem(entry.getKey());
					menuItem.setOnAction(action);
					subMenu.getItems().add(menuItem);
				}
				menu2.getItems().add(subMenu);
			}

			Menu menu3 = new Menu("-");

			EventHandler<ActionEvent> action = dropScale(i);
			MenuItem menuItem = new MenuItem("drop this scale");
			menuItem.setOnAction(action);
			menu3.getItems().add(menuItem);
			menuItem = new MenuItem("drop other scales");
			menuItem.setOnAction(action);
			menu3.getItems().add(menuItem);

			action = highlightRootApproachNotes(i);
			CheckMenuItem checkMenuItem = new CheckMenuItem("highlight root approach notes");
//			if (highlightApproachNotes.get(i).intValue() != 0)
//			{
//				checkMenuItem.setSelected(true);
//			}
//			else
//			{
//				checkMenuItem.setSelected(false);
//			}
			checkMenuItem.setOnAction(action);
			menu3.getItems().add(checkMenuItem);

			scaleMenus.get(i).getMenus().addAll(menu0, menu1, menu2, menu3);

			scaleFretboardPanes.set(i, scaleFretboards.get(i).paintFretboard());
		}

		buttonNewScale = new Button("+");

		EventHandler<ActionEvent> action = newScale();
		buttonNewScale.setOnAction(action);
	}

	public void updateCenterPaneData()
	{
		for (int i = 0; i < scales.size(); i++)
		{
			scaleLabels.get(i).setText(scales.get(i).rootNote + " " + scales.get(i).name + "\n" + scales.get(i).toStringIntervals() + "\n" + scales.get(i).toStringNotes());
			scaleLabels.get(i).setFont(new Font("Courier New", 12));

			scaleFretboards.get(i).highlightFretboard(scales.get(i));
		}
	}

	public void updateCenterPaneLayout()
	{
		centerPane.getChildren().clear();

		int i = 0;
		for (i = 0; i < scales.size(); i++)
		{
			GridPane.setConstraints(scaleMenus.get(i), i, 0);
			centerPane.getChildren().add(scaleMenus.get(i));

			GridPane.setConstraints(scaleLabels.get(i), i, 1);
			GridPane.setMargin(scaleLabels.get(i), new Insets(0, 0, 0, 5));
			centerPane.getChildren().add(scaleLabels.get(i));

			GridPane.setConstraints(scaleFretboardPanes.get(i), i, 2);
			centerPane.getChildren().add(scaleFretboardPanes.get(i));
		}

		GridPane.setConstraints(buttonNewScale, i, 0);
		centerPane.getChildren().add(buttonNewScale);
	}

	public void initTopPane()
	{
		mainMenu = new MenuBar();
		topPane.getChildren().add(mainMenu);
	}

	public void addDefaultMenusMainMenu()
	{
		Menu menu0 = new Menu("Root Note");

		for (int j = 0; j < ChromaticScale.SEMITONE_COUNT; j++)
		{
//			EventHandler<ActionEvent> action = setRootNote(i);
			MenuItem menuItem = new MenuItem(ChromaticScale.NOTE_SHARPS[j]);
//			menuItem.setOnAction(action);
			menu0.getItems().add(menuItem);
		}

		mainMenu.getMenus().addAll(menu0);
	}

	public void addMenuMainMenu(Menu menu)
	{

	}

	public void paintWindow()
	{
//		fillCenterPane();

		borderPane.setTop(topPane);
//		borderPane.setLeft(leftPane);
//		borderPane.setRight(rightPane);
		borderPane.setCenter(centerPane);

		scene = new Scene(borderPane);

		window = new Stage();
		window.setTitle(windowTitle);
		window.setScene(scene);
		window.show();
	}
}
