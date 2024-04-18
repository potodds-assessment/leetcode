package _scratch;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;

public class KeyValue {

    record KeyValueDTO (int key, int count) {}

    public void process(KeyValueDTO[] list) {
        System.out.println(Arrays.toString(list));
        Arrays.sort(list, (a,b)->a.key-b.key);
        System.out.println(Arrays.toString(list));
        Arrays.sort(list, (a,b)->a.count-b.count);
        System.out.println(Arrays.toString(list));
        Arrays.sort(list, (a,b)->b.count-a.count);
        System.out.println(Arrays.toString(list));

        KeyValueDTO one = new KeyValueDTO(1, 2);
        KeyValueDTO two = new KeyValueDTO(1, 2);
        KeyValueDTO three = new KeyValueDTO(2, 3);
        System.out.println(one.equals(three));

        Set<KeyValueDTO> s = new HashSet<>();
        s.add(one);
        s.add(two);
        s.add(three);
        System.out.println(s.contains(two));
        System.out.println(s.contains(one));
    }

    private List<List<String>> getTop(int n, List<String> values) {
        Map<String, Long> one = values.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
        System.out.println(one);

        TreeMap<Long, List<String>> two = 
            one.entrySet().stream().collect(Collectors.groupingBy(Entry::getValue, TreeMap::new, Collectors.mapping(Entry::getKey, Collectors.toList())));
        System.out.println(two);

        return two.descendingMap().values().stream().limit(n).collect(Collectors.toList());
        /*
        return values.stream()
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.groupingBy(Entry::getValue,
                TreeMap::new,
                Collectors.mapping(Entry::getKey, Collectors.toList())))
            .descendingMap().values().stream()
            .limit(n)
            .collect(Collectors.toList());
        */
}    

    public static void main(String[] args) {        
        KeyValue kv = new KeyValue();
//        kv.process(new KeyValueDTO[]{new KeyValueDTO(5, 8), new KeyValueDTO(2, 10), new KeyValueDTO(1, 100)});
        System.out.println(kv.getTop(2, List.of("strawberries", "orange", "apple", "mango", "grapes", "pineapple", "mango", "strawberries", "mango", "apple")));
    }
    
}
