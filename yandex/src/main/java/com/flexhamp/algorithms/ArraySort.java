package com.flexhamp.algorithms;


import com.flexhamp.util.RunnableSort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class ArraySort {
    private static int swap = 0;
    private static final Random rand = new Random();

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 7, 8, 1, 5, 4, 8, 9, 7, 2, 3, 83};
        int[] nums = generateArray(15);

        LinkedList<RunnableSort<int[]>> list = new LinkedList<>();
        list.add(ArraySort::bubbleSort);
        list.add(ArraySort::bubbleSort2);
        list.add(ArraySort::selectionSort);
        list.add(ArraySort::insertionSort);
        list.add(ArraySort::quickSortStart);

        list.forEach(runnableSort -> {
            execute(runnableSort, nums.clone());
        });
    }

    /*
    Пузырьковая сортировка

    Для 10 элементов в сумме получается:
    9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45.
    В общем виде, если массив состоит из N элементов, на первом проходе выполняются N–1 сравнений, на втором — N–2 и т. д. Сумма такого ряда вычисляется
    по формуле:
    (N–1) + (N–2) + (N–3) + ... + 1 = N × (N–1)/2.

    Таким образом, алгоритм выполняет около N^2 / 2 сравнений (на –1 можно не обращать внимания, особенно при больших N

    Инвариант
    В методе bubbleSort инвариант определяет, что элементы данных справа
    от out отсортированы. Это условие остается истинным. (При первом проходе отсортированные элементы отсутствуют, а справа от out нет ни одного элемента, так
    как счетчик инициализируется позицией крайнего правого элемента.)

    Время выполнения O(N^2)
    */
    public static int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 1; i--) { // Внешний цикл (обратный)
            for (int j = 0; j < i; j++) {            // Внутренний цикл (прямой)
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static int[] bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }


    /*
        Сортировки методом выбора

        Число сравнений в теле цикла равно (N-1)*N/2.
        Число сравнений в заголовках циклов (N-1)*N/2.
        Число сравнений перед операцией обмена N-1.
        Суммарное число сравнений N2−1.
        Число обменов N-1.

        Cортировка методом выбора выполняется за время O(N^2),
        как и пузырьковая сортировка.
        Тем не менее совершенно очевидно,
        что сортировка методом выбора выполняется быстрее из-за меньшего количества перестановок.

        Инвариант
        В программе selectSort.java элементы данных с индексами, меньшими либо равными out, всегда отсортированы.
    */

    public static int[] selectionSort(int[] nums) {
        int min;
        for (int i = 0; i < nums.length - 1; i++) {         // Внешний цикл
            min = i;                                        // Минимум
            for (int j = i + 1; j < nums.length; j++) {     // Внутренний цикл
                if (nums[j] < nums[min]) {                  // Если значение min больше
                    min = j;
                }
            }
            swap(nums, i, min);                             // Поменять их местами
        }
        return nums;
    }


    /*
        Сортировка методом вставки
        Выполняется за время порядка O(N^2)

        Если данные упорядочены, то условие цикла while
        никогда не бывает истинным; следовательно, оно вырождается в простую команду
        во внешним цикле, выполняемую N–1 раз. В этом случае алгоритм выполняется
        за время O(N).

        Если данные почти отсортированы, то сортировка методом вставки
        выполняется почти за время O(N), а следовательно, является простым и эффективным способом упорядочения файлов данных с небольшими отклонениями
        в порядке сортировки.

        Инварианты сортировки методом вставки
        В конце каждого прохода, непосредственно после вставки элемента из temp, элементы данных с индексами, меньшими outer, являются частично отсортированными.
    */

    public static int[] insertionSort(int[] nums) {
        int j;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            j = i;
            while (j > 0 && nums[j - 1] >= tmp) {
                nums[j] = nums[j - 1];
                --j;
            }
            nums[j] = tmp;
        }

        return nums;
    }

    /*
    Алгоритм быстрой сортировки

    Быстрая сортировка, также известная как Quick Sort или сортировка Хоара, является одним их самых эффективных алгоритмов. Она включает в себя три этапа:

    Из массива выбирается опорный элемент, чаще всего посередине массива.
    Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
    Далее первые шаги рекурсивно применяются к подмассивам, которые разделились опорным элементом на две части — слева и справа от него.

    Сложность алгоритма: O(n log n)
    */
    public static void quickSort(int[] nums, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (nums.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = nums[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (nums[i] < border) i++;
            while (nums[j] > border) j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(nums, low, j);
        if (high > i) quickSort(nums, i, high);
    }

    public static int[] quickSortStart(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void swap(int[] arr, int left, int right) {
        swap++;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    private static int[] generateArray() {
        final int length = getRandom(15, 100);
        return generateArray(length, 0, 1000);
    }

    private static int[] generateArray(int length) {
        return generateArray(length, 0, 1000);
    }

    private static int[] generateArray(int from, int to) {
        final int length = getRandom(15, 100);
        return generateArray(length, from, to);
    }

    private static int[] generateArray(int length, int from, int to) {
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = getRandom(from, to);
        }
        return array;
    }

    private static int getRandom(int from, int to) {
        return from + rand.nextInt(to - from + 1);
    }

    private static <T> void execute(RunnableSort<T> runnable, T t) {
//        String methodName = new Object() {}
//                .getClass()
//                .getEnclosingMethod()
//                .getName();
//
//        System.out.println("Current Method is " + methodName);

        System.out.println("======================================================");
        System.out.println("Initial");
        printArray(t);

        LocalDateTime from = LocalDateTime.now();
        final T result = runnable.run(t);
        LocalDateTime to = LocalDateTime.now();
        System.out.println("Spent time sorting: " + Duration.between(from, to));

        System.out.println("Swap: " + swap);
        swap = 0;

        System.out.println("Result");
        printArray(result);
    }

    private static <T> void printArray(T t) {
        final Class<?> aClass = t.getClass();
        final Class<?> componentType = aClass.getComponentType();
        if (aClass.isArray() && componentType.isPrimitive()) {
            if (componentType.equals(int.class)) {
                System.out.println(Arrays.toString((int[]) t));
            } else if (componentType.equals(long.class)) {
                System.out.println(Arrays.toString((long[]) t));
            } else {
                System.out.println(t);
            }
        }
    }


    public static int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public static int [] mergeArray(int[] arrayA, int [] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionA];
                positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }
}

