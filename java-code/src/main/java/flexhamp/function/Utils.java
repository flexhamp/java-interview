package flexhamp.function;

public class Utils {
    public static void main(String[] args) {
        System.out.println(Utils.getOrDefault(() -> new Object().toString(), "default"));
        System.out.println(just(() -> 1 + 1));
    }

    public static <T> T getOrDefault(ExceptionalSupplier<T> supplier, T defaultValue) {
        try {
            var res = supplier.get();
            return res == null ? defaultValue : res;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T just(JustFunction<T> supplier) {
        return supplier.call();
    }
}
