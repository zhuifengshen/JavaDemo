package arithmetic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Devin on 2016/8/30.
 */
public class FindTheDifference389 {
    public static void main(String[] args) {
        String s ="abcd";
        String t = "abcde";
        System.out.println(findTheDifference2(s, t));
    }

    private static char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (int i = 0; i < chars2.length; i++) {
            boolean exist = false;
            for (int j = 0; j < chars1.length; j++) {
                if (chars2[i] == chars1[j]){
                    exist = true;
                    break;
                }
            }
            if (!exist) return chars2[i];
        }
        throw new IllegalArgumentException("no other letter was added.");
    }

    private static char findTheDifference1(String s, String t){
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        List charList = Arrays.asList(chars);
        for (int i = 0; i < t.length(); i++) {
            if (!charList.contains(t.charAt(i))){
                return t.charAt(i);
            }
        }
        throw new IllegalArgumentException("no other letter was added.");
    }
    //任何数异或自己 ＝ 把自己置0, 故最后只剩下多出的一个字符
    private static char findTheDifference2(String s, String t){
        char answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            answer ^= t.charAt(i);
        }
        return answer;
    }
}
