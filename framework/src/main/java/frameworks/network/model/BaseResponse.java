package frameworks.network.model;
/**
 * Created by sandeep on 13/5/18.
 */
public class BaseResponse {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return"message = " + message;
    }
}
