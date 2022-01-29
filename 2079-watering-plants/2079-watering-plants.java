class Solution {
    //2233
    //12512
    public int wateringPlants(int[] plants, int capacity) {
        int steps=0; 
        int temp=capacity; 
        for (int i=0; i < plants.length; i++){
            int curr=plants[i]; 
            
            if (curr > temp) {
                steps+= (i) + i+1; 
                temp=capacity-curr; 
            }
            else {
            steps++; 
            temp -= curr; 
            }
            
        }
        return steps; 
    }
}