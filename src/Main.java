import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(3);
        list.add(7);
        Stream<Integer> stream = list.stream();

        List<Integer> list1 = new ArrayList<>();
        Stream<Integer> stream1 = list1.stream();


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        };

        BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer + " " + integer2);
            }
        };

        findMinMax(stream, comparator, biConsumer);

        findEvenNumbers(list);


    }

    public static void findMinMax(Stream<Integer> stream, Comparator<Integer> order, BiConsumer<Integer, Integer> minMaxConsumer) {
        List <Integer> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            Integer min = list.stream()
                              .min(order)
                              .get();
            Integer max = list.stream()
                              .max(order)
                              .get();
            minMaxConsumer.accept(min,max);
        }
    }

    public static void findEvenNumbers(List<Integer> list) {
        System.out.println("Четные числа: ");
        System.out.println("Кол - во четных чисел: " + list.stream()
                .filter(num -> num % 2 == 0)
                .peek(System.out::println)
                .count());
    }


}