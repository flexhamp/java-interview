package collection.interfaces;

import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise1Test extends ClassicOnlineStore {

    @Easy
    @Test
    public void iterateByForEach() {
        Iterable<Customer> customerIterable = this.mall.getCustomerList();
        List<String> nameList = new ArrayList<>();

        /**
         * Create a {@link Consumer} which represents an operation to add customer's name to {@link nameList} list.
         * Iterate {@link customerIterable} with {@link Iterable#forEach} and use the {@link Consumer}
         * to finish creating the name list.
         */
        //        Consumer<Object> consumer = null;
        //        // customerIterable.

        Consumer<Object> consumer = a -> nameList.add(((Customer) a).getName());
        customerIterable.forEach(consumer);

        assertThat(nameList.toString(), is("[Joe, Steven, Patrick, Diana, Chris, Kathy, Alice, Andrew, Martin, Amy]"));
    }

    @Easy
    @Test
    public void whoHaveNoEInYourName() {
        Collection<String> nameCollection =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Predicate} which predicates if the input string contains "e".
         * Remove elements from {@link nameCollection} which contains "e" using {@link Collection#removeIf}.
         */
        //        Predicate<Object> predicate = null;
        //        // nameCollection.

        Predicate<Object> predicate = a -> a.toString().contains("e");
        nameCollection.removeIf(predicate);

        assertThat(nameCollection.toString(), is("[Patrick, Chris]"));
    }

    @Easy
    @Test
    public void replaceTheElements() {
        List<String> nameList =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link UnaryOperator} which returns given string wrapped with "()".
         * Replace the elements in {@link nameList} with string wrapped with "()" using {@link List#replaceAll} .
         */
        //        UnaryOperator<Object> unaryOperator = null;
        //        // nameList.

        UnaryOperator<String> unaryOperator = a -> "(" + a + ")";
        nameList.replaceAll(unaryOperator);

        assertThat(nameList.toString(), is("[(Joe), (Steven), (Patrick), (Chris)]"));
    }

    @Easy
    @Test
    public void sortByName() {
        List<String> nameList =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Comparator} to sort the name list by their name's length in ascending order.
         */
//        Comparator<String> comparator = (a, b) -> a.length() > b.length() ? 1 : a.length() == b.length() ? 0 : -1;
//        Comparator<String> comparator = (a, b) -> Integer.compare(a.length(), b.length());
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        nameList.sort(comparator);

        assertThat(nameList.toString(), is("[Joe, Chris, Steven, Patrick]"));
    }

    @Easy
    @Test
    public void createStream() {
        Collection<String> nameList =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a serial {@link Stream} using {@link Collection#stream}
         * You can learn about {@link Stream} APIs at stream-api module.
         */
        //        Stream<Object> nameStream = null
        Stream<String> nameStream = nameList.stream();

        assertThat(nameStream.count(), is(4L));
        assertThat(nameStream.isParallel(), is(false));
    }

    @Easy
    @Test
    public void createParallelStream() {
        Collection<String> nameList =
                new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));
        /**
         * Create a parallel {@link Stream} using {@link Collection#parallelStream} or {@link Stream#parallel}
         */
        //        Stream<Object> nameParallelStream = null;
//        Stream<String> nameParallelStream = StreamSupport.stream(nameList.spliterator(), true);
        Stream<String> nameParallelStream = nameList.parallelStream();


        assertThat(nameParallelStream.count(), is(4L));
        assertThat(nameParallelStream.isParallel(), is(true));
    }
}
