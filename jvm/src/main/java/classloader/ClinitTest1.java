package classloader;

public class ClinitTest1 {
    static class Father {
        public static int A = 1;

        static {
            A = 2;
            System.out.println(A);
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        Father father;

        // 先加载Father类，再加载Son类
        System.out.println(Son.B);//2
    }
}
