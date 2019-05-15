package tu.practise.firm.exceptions;

public class InvalidDepartmentException extends IllegalArgumentException {
    private static final String INVALID_DEPARTMENT_MESSAGE = "Department credentials are invalid!";

    public InvalidDepartmentException() {
        super(INVALID_DEPARTMENT_MESSAGE);
    }

    public InvalidDepartmentException(String s) {
        super(s);
    }
}
