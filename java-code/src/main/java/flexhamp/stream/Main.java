package flexhamp.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }


    private static <T> String listToString(List<T> list) {
        if (list == null)
            return null;
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
