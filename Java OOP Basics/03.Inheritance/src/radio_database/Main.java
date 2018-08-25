package radio_database;

import radio_database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RadioDatabase radioDatabase = new RadioDatabase();

        int countOfSongs = Integer.parseInt(reader.readLine());
        while (countOfSongs-- > 0) {
            String[] songInput = reader.readLine().split(";");

            try {
                Song song = new Song(songInput[0], songInput[1]);

                SongLength songLength = new SongLength(songInput[2]);
                song.setSongLength(songLength);

                radioDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", radioDatabase.getSongs().size());
        System.out.println(radioDatabase.getPlaylistLength());
    }
}
