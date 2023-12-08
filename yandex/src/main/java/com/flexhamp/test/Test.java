package com.flexhamp.test;


import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import java.util.Iterator;Напишите реализацию Java-итератора по заданному на входе набору целых чисел, возвращающий только четные (по значению) числа из этого набора.
//        TODO требования:
//        - реализовать Iterator<Integer>
//- придумать интерфейс для конечного пользователя (что принимать на вход)
//        - БЕЗ удаления элементов
//
//Lists.newArrayList(1).iterator();
//        [2,2]
//
//public class EvenIterator implements Iterator<Integer> {
//    private Iterator<Integer> it;
//    private Integer next;
//    private boolean hasNext;
//    public EvenIterator(Iterator<Integer> it) {
//        this.it = it;
//    }
//
//    public boolean hasNext() {
//        if (hasNext) {
//            return hasNext;
//        }
//        Integer tmp = null;
//        if (it.nasNext()) {
//            tmp = it.next;
//            if (tmp % 2 == 0) {
//                next = tmp;
//                hasNext = true;
//            }
//        }
//        while(it.nasNext() || !hasNext) {
//            tmp = it.next;
//            if (tmp % 2 == 0){
//                next = tmp;
//                hasNext = true;
//            }
//        }
//        return hasNext;
//    }
//
//    public Integer next() {
//        if (!hasNext()) {
//            new throw RuntimeExceprion("Not next");
//        }
//        hasNext = false;
//        return next;
//    }
//}
//
//    var it = new EvenIterator(Lists.newArrayList(2,2).iterator());
//it.next(); it.next()
//        while(it.hasNext()) {
//        it.hasNext();
//        System.out.println(it.next());
//        }
public class Test {
    public static void main(String[] args) {
        final Collector<Object, ?, List<Object>> objectListCollector = Collectors.toList();
    }
}