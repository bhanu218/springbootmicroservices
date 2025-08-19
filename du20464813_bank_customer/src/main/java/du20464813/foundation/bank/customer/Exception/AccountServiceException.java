package du20464813.foundation.bank.customer.Exception;

public class AccountServiceException extends RuntimeException{
    private final int statusCode;
    public AccountServiceException(int statusCode, String message){
        super(message);
        this.statusCode=statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
