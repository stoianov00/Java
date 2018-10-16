package contracts;

import exceptions.*;

import java.util.List;

public interface CommandHandler {
    String executeCommand(String name, List<String> parameters)
            throws DuplicateModelException, NonExistentModelException,
            RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
