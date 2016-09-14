package json.gson;

import java.util.List;

/**
 * Created by Devin on 2016/9/14.
 */
public class JsonBean {
    List<Roomname> roomname;
    class Roomname{
        int PCnum;
        int num;
        String name;
        String time;
    }
}
