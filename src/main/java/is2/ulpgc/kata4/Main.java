package is2.ulpgc.kata4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(urlOf("chinook.db"))) {
            TrackLoader trackLoader = new SqliteTrackLoader(connection);
            List<Track> tracks = trackLoader.LoadAll();
            for (Track track: tracks){
                System.out.println(track);
            }
        }
    }

    private static String urlOf(String file) {
        return "jdbc:sqlite:" + file;
    }

}
