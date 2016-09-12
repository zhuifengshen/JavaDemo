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
                //此处j=i+1即可,因为之前部分已遍历过,另外主要i!=j的判断
                for (int j = i + 1; j < nums.length; j++) {
                    if (i != j && nums[i] == target - nums[j]){
                        return new int[]{i,j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
    }

    //定义Node节点类,用于保存数值和对应的下标索引
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
        //对节点进行排序,以便下面比较两个数之和的大小
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
        //将每个数及其下标作为HashMap的一个元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //利用HashMap的containsKey方法, 对每个数进行判断
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //此处注意两个数下标不能相同的判断
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
