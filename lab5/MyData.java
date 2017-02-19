import java.text.*;
import java.util.*;
import java.io.*;

public class MyData implements Serializable {

    private int value;
    private long timestamp;

    public MyData(int v, long t) {
        value = v;
        timestamp = t;
    }

    public int getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat();
        String dateString = df.format(new Date(timestamp));

        return "Date: " + dateString + ", value = " + value;
    }

}
