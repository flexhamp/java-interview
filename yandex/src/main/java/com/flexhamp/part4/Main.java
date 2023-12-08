package com.flexhamp.part4;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// ++++
//https://habr.com/ru/companies/vk/articles/420605/
//0.571s
//19.86Mb
public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            final int parseInt = Integer.parseInt(reader.readLine());
            final int brackets = 2 * parseInt;
            char[] list = new char[brackets];
            int i;

            for (i = 0; i < parseInt; i++) {
                list[i] = '(';
                list[i + parseInt] = ')';
            }

            System.out.println(list);
            int index;
            int count;
            while (true) {
                index = brackets - 1;
                count = 0;

                while (index >= 0) {
                    if (list[index] == (')')) {
                        count--;
                    }

                    if (list[index] == ('(')) {
                        count++;
                    }

                    if (count < 0 && list[index] == ('(')) {
                        break;
                    }
                    index--;
                }

                if (index < 0) {
                    break;
                }

                list[index] = ')';

                for (i = index + 1; i < brackets; i++) {
                    if (i <= (brackets - index + count) / 2 + index) {
                        list[i] = '(';
                    } else {
                        list[i] = ')';
                    }
                }
                System.out.println(list);
            }
        } catch (Exception ignored) {
        }
    }
}

//213ms
//22.39Mb
//public class Main {
//    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            c(Integer.parseInt(reader.readLine()), "", 0, 0);
//        } catch (Exception ignored) {
//        }
//    }
//
//    private static void c(int count, String s, int left, int right) {
//        if (left == count && right == count) {
//            System.out.println(s);
//        } else {
//            if (left < count)
//                c(count, s.concat("("), left + 1, right);
//            if (right < left) {
//                c(count, s.concat(")"), left, right + 1);
//            }
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int brackets = 2 * Integer.parseInt(reader.readLine());
//            char[] list = new char[brackets];
//            c(0, 0, brackets, list);
//        } catch (Exception ignored) {
//        }
//    }
//
//    private static void c(int diff, int index, int baskets, char[] list) {
//        if (diff <= baskets - index - 2) {
//            list[index] = '(';
//            c(diff + 1, index + 1, baskets, list);
//        }
//
//        if (diff > 0) {
//            list[index] = ')';
//            c(diff - 1, index + 1, baskets, list);
//        }
//
//        if (index == baskets) {
//            if (diff == 0) {
//                System.out.println(list);
//            }
//        }
//    }
//}