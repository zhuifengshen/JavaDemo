package arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devin on 2016/8/29.
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] indices = twoSum(nums, target);
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length; i++){
                for (int j = i + 1; j < nums.length; j++) {
                    if (i != j && nums[i] == target - nums[j]){
                        return new int[]{i,j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
    }

    static class Node implements Comparable<Node>{
        int value, index;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
    public static int[] twoSum1(int[] nums, int target){
        int[] indexs = new int[2];
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Arrays.sort(nodes);
        int i = 0, j= nums.length - 1;
        while (i < j){
            if (nodes[i].value + nodes[j].value == target){
                break;
            }else if(nodes[i].value + nodes[j].value < target){
                i++;
            }else{
                j--;
            }
        }
        indexs[0] = nodes[i].index;
        indexs[1] = nodes[j].index;
        return indexs;
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

}
