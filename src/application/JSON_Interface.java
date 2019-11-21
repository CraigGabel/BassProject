package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Interface
{
	public JSON_Interface()
	{

	}

	public LinkedList<Chords> readJSON_Chords(String file) throws FileNotFoundException, IOException, ParseException
	{
		LinkedList<Chords> chordList = new LinkedList<>();

		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader(file));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting scales
		JSONArray chordArray = (JSONArray) jo.get("Chords");

		for (int i = 0; i < chordArray.size(); i++)
		{
			Chords tempChord = new Chords();

			JSONObject jsonChord = (JSONObject) chordArray.get(i);

			tempChord.group = (String) jsonChord.get("group");

			JSONArray jsonChordMembers = (JSONArray) jsonChord.get("members");

			for (int ii = 0; ii < jsonChordMembers.size(); ii++)
			{
				JSONObject tempJSONchordMember = (JSONObject) jsonChordMembers.get(ii);

				JSONArray jsonIntervals = (JSONArray) tempJSONchordMember.get("intervals");
				LinkedList<Integer> intervals = new LinkedList<>();
				for (int iii = 0; iii < jsonIntervals.size(); iii++)
				{
					intervals.add(Integer.parseInt((String) jsonIntervals.get(iii)));
				}

				tempChord.chordMembers.put((String) tempJSONchordMember.get("name"), intervals);
			}

			chordList.add(tempChord);
		}

		return chordList;
	}

	public LinkedList<Scale> readJSON_Scales(String file) throws FileNotFoundException, IOException, ParseException
	{
		LinkedList<Scale> scaleList = new LinkedList<>();

		// parsing file "JSONExample.json"
		Object obj = new JSONParser().parse(new FileReader(file));

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting scales
		JSONArray scaleArray = (JSONArray) jo.get("Scales");

		for (int i = 0; i < scaleArray.size(); i++)
		{
			Scale tempScale = new Scale();

			JSONObject jsonScale = (JSONObject) scaleArray.get(i);

			tempScale.group = (String) jsonScale.get("group");

			JSONArray jsonIntervals = (JSONArray) jsonScale.get("intervals");

			for (int ii = 0; ii < jsonIntervals.size(); ii++)
			{
				tempScale.intervals.add(Integer.parseInt((String) jsonIntervals.get(ii)));
			}

			JSONArray jsonModes = (JSONArray) jsonScale.get("modes");

			if (jsonModes != null)
			{
				for (int ii = 0; ii < jsonModes.size(); ii++)
				{
					JSONObject tempJSONmode = (JSONObject) jsonModes.get(ii);
					Modes tempModes = new Modes();
					tempModes.name = (String) tempJSONmode.get("name");
					tempModes.offset = Integer.parseInt((String) tempJSONmode.get("offset"));
					tempScale.modes.add(tempModes);
				}
			}

			scaleList.add(tempScale);
		}

		return scaleList;
	}

/*
	 public DB_Interface()
	{

	}

	public LinkedList<Scale> readDB_Scales()
	{
		LinkedList<Scale> scaleList = new LinkedList<Scale>();
		Scale scale;

		try
		{
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Craig", "CraigPassword");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from scales_v3 order by name");
			while (rs.next())
			{
				scale = new Scale();

				scale.id = rs.getInt("id");
				scale.name = rs.getString("name");

				for (int i = 0; i < 12; i++)	//12 is the maximum possible number of modes, also matches the DB
				{
					Modes mode = new Modes();
					String string = "mode" + (i+1) + "name";
					if (rs.getString(string) != null)
					{
						mode.name = rs.getString(string);
						mode.offset = i;
						scale.modes.add(new Modes(mode));
					}
				}

				for (int i = 0; i < 12; i++)	//12 is the maximum number allowed for intervals, matches the DB
				{
					String string = "interval" + (i+1);
					if (rs.getInt(string) != 0)
					{
						scale.intervals.add(new Integer(rs.getInt(string)));
					}
				}

				scaleList.add(new Scale(scale));
			}

			// step5 close the connection object
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return scaleList;
	}

	public LinkedList<ChordProgression> readDB_ChordProgression()
	{
		LinkedList<ChordProgression> chordProgressionList = new LinkedList<ChordProgression>();
		ChordProgression chordProgression;

		try
		{
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Craig", "CraigPassword");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from chordprogressions order by name");
			while (rs.next())
			{
				//System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
				chordProgression = new ChordProgression();

				chordProgression.id = rs.getInt("id");
				chordProgression.name = rs.getString("name");

				for (int i = 0; i < 12; i++)	//12 is the most chords in a progression, matches DB
				{
					String string = "chord" + (i+1);
					if (rs.getString(string) != null)
					{
						chordProgression.chord.add(new String(rs.getString(string)));
					}
				}

				for (int i = 0; i < 12; i++)	//one interval for each of above chords
				{
					String string = "interval" + (i+1);
					if (rs.getInt(string) != 0)
					{
						chordProgression.interval.add(new Integer(rs.getInt(string)));
					}
				}

				chordProgressionList.add(new ChordProgression(chordProgression));
			}

			// step5 close the connection object
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return chordProgressionList;
	}

	public LinkedList<JamProgression> readDB_JamProgression()
	{
		LinkedList<JamProgression> jamProgressionList = new LinkedList<JamProgression>();
		JamProgression jamProgression;

		try
		{
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Craig", "CraigPassword");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from jamprogressions order by name");
			while (rs.next())
			{
				//System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
				jamProgression = new JamProgression();

				jamProgression.id = rs.getInt("id");
				jamProgression.name = rs.getString("name");
				jamProgression.chordProgression = rs.getString("chordProgression");

				for (int i = 0; i < 12; i++)	//12 is the most allowed chords in a jam progression, matches DB
				{
					String string = "chord" + (i+1) + "index";
					if (rs.getInt(string) != 0)
					{
						jamProgression.chordIndex.add(new Integer(rs.getInt(string)));
					}
				}

				jamProgressionList.add(new JamProgression(jamProgression));
			}

			// step5 close the connection object
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return jamProgressionList;
	}

	public LinkedList<Chords> readDB_Chords()
	{
		LinkedList<Chords> chordList = new LinkedList<Chords>();
		Chords chord;

		try
		{
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Craig", "CraigPassword");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from chords");
			while (rs.next())
			{
				chord = new Chords();
				//System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

				chord.id = rs.getInt("id");
				chord.name = rs.getString("name");
				chord.symbol = rs.getString("symbol");

				for (int i = 0; i < 6; i++)	//6 is the most notes I allowed for a chord (I dont know why), matches DB
				{
					String string = "interval" + (i+1);
					if (rs.getInt(string) != 0)
					{
						chord.intervals.add(new Integer(rs.getInt(string)));
					}
				}

				chordList.add(new Chords(chord));
			}

			// step5 close the connection object
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return chordList;
	}

	public LinkedList<Licks> readDB_Licks()
	{
		LinkedList<Licks> lickList = new LinkedList<Licks>();
		Licks lick = new Licks();

		try
		{
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Craig", "CraigPassword");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from licks order by name");
			while (rs.next())
			{
				lick.id = rs.getInt("id");
				lick.lickVersion = rs.getInt("lickVersion");
			    lick.name = rs.getString("name");

				for (int measure = 0; measure < Licks.MAX_MEASURE_COUNT; measure++)	//8 measures max for licks (no real reason), matches DB
				{
					lick.measure[measure].noteCount = rs.getInt("measure" + measure + "noteCount");

					for (int note = 0; note < Licks.NOTES_PER_MEASURE; note++)	//8 notes per measure (no real reason why)
					{
						lick.measure[measure].note[note] = rs.getString("measure" + measure + "note" + note);
					}
				}

				lickList.add(new Licks(lick));
			}

			// step5 close the connection object
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return lickList;
	}
*/
}
