/*
	Fibon!
 */

public class Test009 {
    public static double fibon(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibon(n - 1) + fibon(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; ++i)
            System.out.println(i + " " + fibon(i));
    }
}
