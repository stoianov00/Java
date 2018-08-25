package radio_database;

public final class ExceptionConstants {
    public static final String INVALID_SONG_LENGTH_EXCEPTION = "Invalid song length.";
    public static final String INVALID_SONG_MINUTES_EXCEPTION = "Song minutes should be between 0 and 14.";
    public static final String INVALID_SONG_SECONDS_EXCEPTION = "Song seconds should be between 0 and 59.";

    public static final String INVALID_SONG_ARTIST_NAME_EXCEPTION = "Artist name should be between 3 and 20 symbols.";
    public static final String INVALID_SONG_NAME_EXCEPTION = "Song name should be between 3 and 30 symbols.";

    private ExceptionConstants() {
    }
}
