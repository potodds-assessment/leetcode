package leetcode.two_pointers;

public class Trapping_Rain_Water {
    public int trap(int[] height) {
        int left = 0;
        int right = 1;

        int final_value = 0;
        int temp_sum = 0;

        while (right < height.length && left < height.length) {
            if ( height[left] == 0 ) {
                left++;
                if ( left == right ) right++;
            } else {
                if ( height[left] > height[right] ) {
                    temp_sum += ( height[left] - height[right] );
                    right++;
                } else {
                    final_value += temp_sum;
                    temp_sum = 0;
                    left = right;
                    right++;
                }
            }
        }

        return final_value;
    }

    public static void main(String[] args) {
        Trapping_Rain_Water app = new Trapping_Rain_Water();
        System.out.println(app.trap( new int[]{0,1,0,2,1,0,1,3,2,1,2,1} ));
        System.out.println(app.trap( new int[]{4,2,0,3,2,5} ));
    }
}
