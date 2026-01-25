package annotation;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
//@Scope("singleton")
@Scope("prototype")
public class Message {

    private int id;

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
