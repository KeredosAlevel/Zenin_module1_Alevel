import java.io.FileNotFoundException;

public class Exception extends FileNotFoundException {
    @Override
    public String getMessage () {
        return "Fatal Error";
    }
}