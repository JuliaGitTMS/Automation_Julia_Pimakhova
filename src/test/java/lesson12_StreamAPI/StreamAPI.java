package lesson12_StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Stream.concat;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15));
        System.out.println(sortList(list));
        System.out.println(sortList1(list));
    }
//    for the world without "absolute value")
    public static List<Integer> sortList(List<Integer> list){
        return concat(list.stream().filter(e->e<0).map(a->a*-1), list.stream().filter(p->p>=0)).sorted().collect(Collectors.toList());
    }
    public static List<Integer> sortList1(List<Integer> list){
        return list.stream().map(Math::abs).sorted().collect(Collectors.toList());
    }
}
