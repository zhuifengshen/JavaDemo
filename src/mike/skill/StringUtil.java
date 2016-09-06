package mike.skill;

/**
 * Created by Devin on 2016/7/21.
 */
public class StringUtil {
    //将字符串第一个字符改为大写或小写
    public static String toLowerCaseInitial(String srcString, boolean flag){
        StringBuilder sb = new StringBuilder();
        if(flag){
            sb.append(Character.toLowerCase(srcString.charAt(0)));
        }else {
            sb.append((Character.toUpperCase(srcString.charAt(0))));
        }
        sb.append(srcString.substring(1));
        return sb.toString();
    }

    //获取lastname
    public static String getLastName(String name){
        String[] names = name.split("\\.");
        return names[names.length - 1];
    }

    public static void main(String[] args){
        System.out.println(toLowerCaseInitial("Zhangchuzhao", true));
        System.out.println(getLastName("zhang.chu.zhao"));
    }
}
