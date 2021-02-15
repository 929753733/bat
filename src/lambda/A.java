package lambda;

public interface A {
    default String gettName() {
        return "aaa";
    }

    String b();

    public static void show() {
        System.out.println("哈哈哈");
    }
}
