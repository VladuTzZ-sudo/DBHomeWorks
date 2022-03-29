package DeutscheBank.Homework2;

public class InvalidNationalIdException extends RuntimeException {
    public InvalidNationalIdException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    static boolean checkId(String id) {
        return id.length() == 6;
    }
}
