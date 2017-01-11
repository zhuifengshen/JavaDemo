package json.fastson.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 14:31
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class JsonToBean {
    public static String readRtf(File in){
        RTFEditorKit rtf = new RTFEditorKit();
        DefaultStyledDocument dsd = new DefaultStyledDocument();
        String text = null;
        try {
            rtf.read(new FileInputStream(in), dsd, 0);
            text = new String(dsd.getText(0, dsd.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        //System.out.println("Json content: " + readRtf(new File("json.rtf")));
        String jsonString = "{\n" +
                "    \"statuses\":[\n" +
                "        {\n" +
                "         \"id\": 912345678901,\n" +
                "         \"text\": \"How do I stream JSON in Java?\",\n" +
                "         \"geo\": null,\n" +
                "         \"user\": {\n" +
                "        \"name\": \"json_newb\",\n" +
                "        \"followers_count\": 41\n" +
                "              }\n" +
                "          },\n" +
                "          \n" +
                "        {\n" +
                "         \"id\": 777777777888,\n" +
                "         \"text\": \"dfngsdnglnsldfnsl\",\n" +
                "         \"geo\": null,\n" +
                "         \"user\": {\n" +
                "        \"name\": \"dsfgpd\",\n" +
                "        \"followers_count\": 24\n" +
                "              }\n" +
                "          }\n" +
                "     ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("statuses");
        List<DataBean> listDataBean = JSON.parseArray(jsonArray.toString(), DataBean.class);
        for (DataBean dataBean : listDataBean) {
            System.out.println(dataBean.getId());
            System.out.println(dataBean.getText());
            System.out.println(dataBean.getGeo());
            System.out.println(dataBean.getUser());
            System.out.println(dataBean.getUser().getName());
            System.out.println(dataBean.getUser().getFollowers_count());
        }
    }
}
