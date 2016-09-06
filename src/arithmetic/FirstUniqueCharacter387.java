package arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devin on 2016/9/1.
 */
public class FirstUniqueCharacter387 {
    public static void main(String[] args) {
        String s = "loeleetcode";
        System.out.println(firstUniqChar2(s));
    }
    //暴力查找 122ms
    public static int firstUniqChar(String s){
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)){
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) return i;
        }
        return -1;
    }
    //134ms
    public static int firstUniqChar1(String s){
        //首先,使用HashMap存储每个字符出现的个数
        Map<Character, Integer> charMap = new HashMap<>(s.length()); //预先分配HashMap大小,避免扩容性能影响
        for (int i = 0; i < s.length(); i++) {
            if (!charMap.containsKey(s.charAt(i))){
                charMap.put(s.charAt(i), 1);
            }else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i))+1);
            }
        }
        //然后,获取第一个出现次数为1的字符下标
        for (int i = 0; i < s.length(); i++) {
            if (charMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

        //entrySet时,顺序已经被打乱,因此不能使用
        //for (Map.Entry<Character, Integer> entry : charMap.entrySet()){
        //    System.out.println(entry.getKey() + " : " + entry.getValue());
        //    if (entry.getValue() == 1){
        //        return s.indexOf(entry.getKey());
        //    }
        //}
    }

    //巧妙利用数组计数 29ms
    public static int firstUniqChar2(String s){
        int[] countArray = new int[26];
        //首先使用数组countArray记录每个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'a']++;
        }
        //然后取出最先出现次数为1的字母的下标
        for (int i = 0; i < s.length(); i++) {
            if (countArray[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

}
