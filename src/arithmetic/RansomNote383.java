package arithmetic;

import java.util.HashMap;

/**
 * Created by Devin on 2016/9/7.
 */
public class RansomNote383 {
    public static void main(String[] args) {
        String ransom = "aa";
        String megazines = "aba";
        System.out.println(canConstruct1(ransom, megazines));
    }
    //20
    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            //如果该字母个数小于零, 则说明magazine中不能全包含该字母
            if (--chars[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    //85
    private static boolean canConstruct1(String ransomNote, String magazine){
        HashMap<Character,Integer> charsMap = new HashMap<>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            if (charsMap.containsKey(magazine.charAt(i))){
                charsMap.put(magazine.charAt(i), charsMap.get(magazine.charAt(i)) + 1);
            }else {
                charsMap.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (charsMap.containsKey(ransomNote.charAt(i))){
                //当字母个数为1时,则应该去除该节点
                if (charsMap.get(ransomNote.charAt(i)) == 1){
                    charsMap.remove(ransomNote.charAt(i));
                }else{
                    charsMap.put(ransomNote.charAt(i), charsMap.get(ransomNote.charAt(i)) - 1);
                }
            }else {
                //当字母不存在时,说明magazine中不能全包含该字母,直接返回false.
                return false;
            }
        }
        return true;
    }

}
