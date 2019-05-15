package tu.practise.firm.exceptions;

public class InvalidTownException extends IllegalArgumentException {
    private static final String INVALID_TOWN_MESSAGE = "Town credentials are invalid!";

    public InvalidTownException() {
        super(INVALID_TOWN_MESSAGE);
    }

    public InvalidTownException(String s) {
        super(s);
    }
}
