package leetcode.two_pointers;

public class ThreeSumMultiplicity {

    /////////////////////////////////////////////////////////////
    // 923. 3Sum With Multiplicity
    // https://leetcode.com/problems/3sum-with-multiplicity/
    /////////////////////////////////////////////////////////////
    public int threeSumMulti(int[] arr, int target) {

        //////////////////////////////////////////////////
        // brute force method
        // Time: O(n^2)
        // Space: O(1)
        //////////////////////////////////////////////////
//        int mod = 1_000_000_007;
//        long result = 0;
//        for(int i=0;i<arr.length;i++) {
//            int[] count = new int[101];
//            for(int j=i+1;j<arr.length;j++) {
//                int k = target-arr[i]-arr[j];
//                if (k>=0 && k<=100 && count[k]>0) {
//                    result+=count[k];
//                    result%=mod;
//                }
//                count[arr[j]]++;
//            }
//        }
//        return (int)result;

        //////////////////////////////////////////////////
        // formula method (i==j==k, i==j!=k, i<j<k)
        // Time: O(n + 100*100)
        // Space: O(100) = O(1)
        //////////////////////////////////////////////////
        int mod = 1_000_000_007;
        long result = 0;
        long[] c = new long[101];
        for(int i:arr) c[i]++;

        for(int i=0;i<=100;i++) {
            for(int j=i;j<=100;j++) {
                int k = target - i - j;
                if (k<0 || k>100) continue;
                if (i==j && j==k)
                    result += (c[i] * (c[i]-1) * (c[i]-2) /6);
                else if (i==j && j!=k)
                    result += ((c[i] * (c[i]-1) /2) * c[k]);
                else if (i<j && j<k)
                    result += (c[i] * c[j] * c[k]);

            }
        }
        return (int)(result%mod);
    }
    public static void main(String[] args) {
        ThreeSumMultiplicity app = new ThreeSumMultiplicity();

        /////////////////////////////////////////////////////////////
        // 923. 3Sum With Multiplicity
        // https://leetcode.com/problems/3sum-with-multiplicity/
        /////////////////////////////////////////////////////////////
        System.out.println(app.threeSumMulti(new int[]{1,1,2,2,2,2},5)); // 12

    }
}
