package lt.ekgame.bancho.api.units;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Beatmap {
    public static final Beatmap DEFAULT = new Beatmap("", "", "", "", "", 0, "", false,false);
    private String title;
    private String artist;
    private String creator;
    private String version;
    private String beatmapMD5;
    public String difficulty;
    private boolean dtEnabled;
    private boolean htEnabled;
    private int beatmapId = 0;
    private String beatmapName;
    public int RequestedBy;

    public Beatmap(String beatmapName, String beatmapMD5, int beatmapId, String rating, boolean dt,boolean ht) {
        this.artist = "unknown";
        this.title = "unknown";
        this.version = "unknown";
        this.creator = "unknown";
        this.beatmapName = beatmapName;
        this.beatmapMD5 = beatmapMD5;
        this.beatmapId = beatmapId;
        this.difficulty = rating;
        this.dtEnabled = dt;
        this.htEnabled = ht;
    }

    public Beatmap(String artist, String title, String version, String creator, String beatmapMD5, int beatmapId, String rating, boolean dt,boolean ht) {
        this.artist = artist;
        this.title = title;
        this.version = version;
        this.creator = creator;
        this.beatmapMD5 = beatmapMD5;
        this.beatmapId = beatmapId;
        this.difficulty = rating;
        this.dtEnabled = dt;
        this.htEnabled = ht;
    }
public Beatmap(File beatmap) throws IOException {
		
		Scanner scanner = new Scanner(new FileInputStream(beatmap));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if (line.startsWith("[Events]") || line.startsWith("[HitObjects]"))
				break; // everything else is irrelevant
			
			if (line.contains(":")) {
				String[] args = line.split(":");
				String label = args[0].trim();
				String value = "";
				for (int i = 1; i < args.length; i++)
					value += args[i];
				value = value.trim();
				
				if (label.equals("Title"))
					title = value;
				else if (label.equals("Artist"))
					artist = value;
				else if (label.equals("Creator"))
					creator = value;
				else if (label.equals("Version"))
					version = value;
				else if (label.equals("BeatmapID"))
					beatmapId = Integer.parseInt(value);
			}
		}
		scanner.close();
		beatmapMD5 = DigestUtils.md5Hex(new FileInputStream(beatmap));
	}

	public String getName() {
		if (beatmapName != null)
			return beatmapName;
		return String.format("%s - %s (%s) [%s]", artist, title, creator, version);
	}

	public String getChecksum() {
		return beatmapMD5;
	}

	public int getId() {
		return beatmapId;
	}

	public static Beatmap getDefault() {
		return DEFAULT;
	}
    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getVersion() {
        return this.version;
    }

    public String getDiff() {
        return this.difficulty;
    }

    public boolean getDT() {
        return this.dtEnabled;
    }

	public boolean getHT() {
		return this.htEnabled;
	}
}