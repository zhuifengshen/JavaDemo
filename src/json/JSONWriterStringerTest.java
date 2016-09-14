package json;

import org.json.JSONStringer;
import org.json.JSONWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devin on 2016/9/12.
 */
public class JSONWriterStringerTest {
    public static void main(String[] args) throws FileNotFoundException {
        JSONStringerTest();
    }

    public static void JSONStringerTest() throws FileNotFoundException {
        //JSONWriter
        PrintWriter writer = new PrintWriter("json.txt");
        JSONWriter jsonWriter = new JSONWriter(writer);
        jsonWriter.object().key("name").value("Devin").key("age").value(22).key("sex").value("male").endObject();
        writer.flush();
        writer.close();

        //JSONStringer
        Map<String,Object> person = new HashMap<>();
            person.put("name","devin");
            person.put("age", 20 );
            person.put("sex","male");

        Map<String,Object> person1 = new HashMap<>();
        person1.put("name","devin1");
        person1.put("age", 22);
        person1.put("sex","male");

        JSONStringer jsonStringer = new JSONStringer();
        jsonStringer.array().value(person).value(person1).endArray();
        System.out.println(jsonStringer);
    }
}
