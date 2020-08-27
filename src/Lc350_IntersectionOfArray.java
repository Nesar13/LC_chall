import java.util.*;

public class Lc350_IntersectionOfArray {


    // fastest solution
    // HashMap and using List
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list= new ArrayList<>();
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],1)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                int new_val=map.get(nums2[i])-1;
                if(new_val==0){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i],new_val);
                    list.add(nums2[i]);
                }
            }
        }
        int[] arr= new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }

    // slower solution at 60%
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                nums1[k] = nums2[i];
                k++;
            }
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)-1);
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }









    public static void main(String[] args) {

        int [] nums1= {1,2,2,4,5};
        int [] nums2= {5,3,2,4,7};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }
}
