package _scratch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test {

    record Data(char c, int count) {}

    public void test() {
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            public int compare(Data s, Data t) {
                if (s.c < t.c)
                    return 1;
                else if (s.c > t.c)
                    return -1;
                else
                    return 0;
            }
        });

        Data one = new Data('a', 10);
        Data two = new Data('b', 5);
        Data three = new Data('c', 100);
        Data four = new Data('d', 3);

        heap.add(one);
        heap.add(two);
        heap.add(three);
        heap.add(four);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }

    public static void main(String[] args) {
        test app = new test();
        app.test();
    }
    
}
