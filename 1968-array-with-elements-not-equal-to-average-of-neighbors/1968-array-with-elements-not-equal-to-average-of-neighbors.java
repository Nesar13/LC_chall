class Solution {
    // 1) We can sort this and rearrange the array to have the biggest number
    // in the middle , but this would take O(nlogn) time | O(1) space
    // 2) We can do this in O(n) time 
    // 3) At its core, this approach is based on the fact 
    //that the average of two numbers can never be 
    //lower than the smallest of the two elements, 
    //nor higher than the largest of the two elements. 
    //      -This means that if an element's neighbors are both 
    //       smaller than itself, then the average of those two neighbors 
    //       will be smaller than the element in question. 
    //      -The same is true for larger elements as well, though with the average 
    //       being larger than the element in question. 
    //So what we can do is go through the array and, in a sense, 
    //rearrange it into a series of peaks and valleys, that way ensuring that we meet the no average criteria.
    
    // for example: take 2,3,4 
    // we know we need to rearrange 3 and 4 to make 4 the highest number so it'll always be bigger than avg
    // Another example: 4,3,2, we know we need to swap 3 and 2 to make the 2 the smallest 
    // number in the middle 
public int[] rearrangeArray(int[] nums) {
    for(int i = 1; i < nums.length - 1; i++){
        if((nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) || (nums[i - 1] > nums[i] && nums[i] > nums[i + 1])){
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
    }
    return nums;
}
    
}