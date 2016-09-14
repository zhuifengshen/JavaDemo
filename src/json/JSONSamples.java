package json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Created by Devin on 2016/9/12.
 */
public class JSONSamples {
    public static void main(String[] args) throws FileNotFoundException {
        JSONStringer jsonStringer = new JSONStringer();
        JSONObject obj6 = new JSONObject().put("title","book1").put("price","11$");
        JSONObject obj3 = new JSONObject().put("book",obj6).put("author",new JSONObject().put("name","author1"));

        JSONObject obj5 = new JSONObject().put("title","book2").put("price","22$");
        JSONObject obj4 = new JSONObject().put("book", obj5).put("author", new JSONObject().put("name", "author2"));

        JSONArray obj2 = new JSONArray().put(obj3).put(obj4);

        JSONObject obj1 = new JSONObject().put("title","BOOK").put("signing",obj2);

        jsonStringer.object().key("session").value(obj1).endObject();
        System.out.println(jsonStringer.toString());

        PrintWriter out = new PrintWriter(new FileOutputStream("book.json"));
        out.println(jsonStringer.toString());
        out.close();

        JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader("book.json")));
        System.out.println(jsonObject.getJSONObject("session").getJSONArray("signing").getJSONObject(1).getJSONObject("book").getString("title"));
    }
}
