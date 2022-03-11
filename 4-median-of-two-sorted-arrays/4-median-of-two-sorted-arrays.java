class Solution {
    
        public double findMedianSortedArrays(int A[], int B[]) {
    int n = A.length;
    int m = B.length;
    // the following call is to make sure len(A) <= len(B).
    // yes, it calls itself, but at most once, shouldn't be
    // consider a recursive solution
    if (n > m)
        return findMedianSortedArrays(B, A);

    // now, do binary search
    int k = (n + m - 1) / 2;
    int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
    while (l < r) {
        int midA = (l + r) / 2;
        int midB = k - midA;
        if (A[midA] < B[midB])
            l = midA + 1;
        else
            r = midA;
    }
    
    // after binary search, we almost get the median because it must be between
    // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

    // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
    // and there are some corner cases we need to take care of.
    int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
    if (((n + m) & 1) == 1)
        return (double) a;

    // if (n+m) is even, the median can be calculated by 
    //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
    // also, there are some corner cases to take care of.
    int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
    return (a + b) / 2.0;
}
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         // 12345
//         // 234
//         // total=8
//         // half=4
//         int len1=nums1.length; 
//         int len2=nums2.length; 
//         if (len1==0 && len2==0) return 0.0; 
//         if (len1==0) return getMid(nums2); 
//         if (len2==0) return getMid(nums1); 
        
//         int[] A=len1 <= len2 ? nums1 : nums2; 
//         int[] B=len1 <= len2 ? nums2 : nums1; 
        
//         int left=0; 
//         int right=A.length; 
        
//         int realMid= (len1+len2 +1)/2; 
        
//         while (left <= right){
            
//             int midA=left+(right-left)/2; 
//             int leftASize=midA; // length of current A from 0 to mid
//             int leftBSize=realMid - midA; 
//             int leftA=leftASize >0 ? A[leftASize-1] : Integer.MIN_VALUE; // checking overflow of indices
//             int leftB=leftBSize >0 ? B[leftBSize-1] : Integer.MIN_VALUE; 
            
//             int rightA=leftASize < A.length? A[leftASize] : Integer.MAX_VALUE; 
//             int rightB=leftBSize < A.length? B[leftBSize] : Integer.MAX_VALUE; 
            
//             if (leftA <= rightB && leftB <= rightA && (leftA != Integer.MIN_VALUE || rightA != Integer.MAX_VALUE 
//                                                        || leftB != Integer.MIN_VALUE || rightB != Integer.MAX_VALUE)){
//                 if((len1 + len2) % 2==0)// if even 
//                 {
//                    return (Math.max(leftA, leftB)
//                            + Math.min(rightA, rightB))/2.0;  
//                 }
//                 return Math.max(leftA, leftB); 
                
//             } else if(leftA > rightB) right=midA-1; 
//             else left=midA +1; 
            
//         }
        
//         return 0.0; 
        
        
        
//     }
    
//     double getMid(int[] nums){
//         int n=nums.length; 
//         if ( n % 2==0){
//             return (nums[n/2] + nums[n/2-1])/2.0; 
//         }
//         else return nums[n/2]; 
        
//     }
}