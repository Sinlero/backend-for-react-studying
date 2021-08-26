package App.Exceptions;

public class BigAskingException extends RuntimeException{

    public BigAskingException() {
        super("You asking too much users");
    }
}
