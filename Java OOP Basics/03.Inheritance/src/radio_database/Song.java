package radio_database;

import radio_database.exceptions.InvalidArtistNameException;

public class Song {
    private String artistName;
    private String songName;
    private SongLength songLength;

    public Song(String artistName, String songName) {
        this.setArtistName(artistName);
        this.setSongName(songName);
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_SONG_ARTIST_NAME_EXCEPTION);
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20) {
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_SONG_NAME_EXCEPTION);
        }

        this.songName = songName;
    }

    public void setSongLength(SongLength songLength) {
        this.songLength = songLength;
    }

    public SongLength getSongLength() {
        return this.songLength;
    }
}
