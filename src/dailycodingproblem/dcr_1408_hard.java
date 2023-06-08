package dailycodingproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Good morning! Here's your coding interview problem for today.

Given a list, sort it using this method: reverse(lst, i, j), which reverses lst from i to j.
 */
public class dcr_1408_hard {

    public List<String> reverseList(List<String> lst, int start, int fin) {
        String[] lstArr = lst.toArray(new String[]{});

        int len = fin - start + 1 ;
        int mid = (len / 2 ) + start;

        for(int i=start, y=fin; i<mid; i++, y--) {
            String left = lstArr[i];
            String right = lstArr[y];

            lstArr[i] = right;
            lstArr[y] = left;
        }

        return Arrays.asList(lstArr);
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("b");
        lst.add("c");
        lst.add("d");
        lst.add("e");
        lst.add("f");

        System.out.println(lst);
        dcr_1408_hard app = new dcr_1408_hard();
        System.out.println(app.reverseList(lst, 0, lst.size()-1));
    }
}
