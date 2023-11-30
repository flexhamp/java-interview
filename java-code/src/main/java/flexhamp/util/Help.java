package flexhamp.util;

public final class Help {
    public static <T> void callOrNext(ConsumerSafe<T> c) {
        try {
            c.accept();
        } catch (Exception ignored) {
        }
    }
}