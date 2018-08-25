package radio_database;

import radio_database.exceptions.InvalidSongException;
import radio_database.exceptions.InvalidSongLengthException;
import radio_database.exceptions.InvalidSongMinutesException;
import radio_database.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String length) {
        this.parseSongLength(length);
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(ExceptionConstants.INVALID_SONG_MINUTES_EXCEPTION);
        }

        this.minutes = minutes;
    }

    public int getMinutes() {
        return this.minutes;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(ExceptionConstants.INVALID_SONG_SECONDS_EXCEPTION);
        }

        this.seconds = seconds;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void parseSongLength(String length) {
        String[] lengthTokens = length.split(":");
        String minutes = lengthTokens[0];
        String seconds = lengthTokens[1];

        if (lengthTokens.length != 2 || !minutes.matches("\\d+") || !minutes.matches("\\d+")) {
            throw new InvalidSongLengthException(ExceptionConstants.INVALID_SONG_LENGTH_EXCEPTION);
        }

        int totalLength = this.getTotalSongLength(Integer.parseInt(minutes), Integer.parseInt(seconds));
        int minLength = 0;
        int maxLength = (14 * 60) + 59;

        if (totalLength < minLength || totalLength > maxLength) {
            throw new InvalidSongException(ExceptionConstants.INVALID_SONG_LENGTH_EXCEPTION);
        }

        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    private int getTotalSongLength(int minutes, int seconds) {
        return (minutes * 60) + seconds;
    }

}
