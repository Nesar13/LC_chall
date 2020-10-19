public class Lc997_FindTheTownJudge {


    public static int findJudge(int N, int[][] trust) {
        int[] isTrusted = new int[N+1];
        for(int[] person : trust){
            
            isTrusted[person[0]]--;
            isTrusted[person[1]]++;
        }
        for(int i = 1;i < isTrusted.length;i++){
            if(isTrusted[i] == N-1) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int [][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};

        System.out.println(findJudge(4, trust));
    }
}
