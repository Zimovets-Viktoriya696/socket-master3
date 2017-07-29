import java.util.Date;

/**
 * Created by vika on 18.07.17.
 */
public class Message {
    private Date date;
    private String name;
    private String text;

    Message(Date date, String name, String text){
        this.date = date;
        this.name = name;
        this.text = text;
    }
}
