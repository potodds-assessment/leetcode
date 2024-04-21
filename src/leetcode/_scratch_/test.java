package leetcode._scratch_;

import java.util.ArrayList;
import java.util.HashMap;

public class test {

    public void t() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // Create a new list to add to the Map
        ArrayList<String> newList = new ArrayList<>();
        newList.add("new item 1");
        newList.add("new item 2");

        // Add the new list to the Map
        map.merge("key", newList, (oldValue, newValue) -> {
            if (oldValue == null) {
                return newValue;
            } else {
                oldValue.addAll(newValue);
                return oldValue;
            }
        });

        System.out.println(map);
    }

    public static void main(String[] args) {
        test app = new test();
        app.t();
    }
}
