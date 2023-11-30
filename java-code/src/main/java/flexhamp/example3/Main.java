package flexhamp.example3;

public class Main {
    public static void main(String[] args) {
//        ISum iSum = (a, b) -> a + b;
        ISum iSum = Integer::sum;
        iSum.sum(1, 2);
    }

    @FunctionalInterface
    public interface ISum {
        int sum(int a, int b);
    }
}
