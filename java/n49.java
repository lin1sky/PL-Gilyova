public class n49 {
    public static int fusc(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0; // fusc(0)
        int b = 1; // fusc(1)

        for (int i = 1; i <= n; ++i) {
            if (i % 2 == 0) { // fusc(2n) = fusc(n)
            } else { // fusc(2n + 1) = fusc(n) + fusc(n + 1)
                int temp = a + b;  
                a = b; 
                b = temp;
            }
        }
        return a; //fusc(n) на последней итерации.
    }

    public static int fuscRec(int n) {
        return fuscHelper(n, 0, 1);
    }

    private static int fuscHelper(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }

        if (n % 2 == 0) {
            return fuscHelper(n / 2, a, b);
        } else {
            return fuscHelper(n / 2, b, a + b);
        }
    }

    public static int fuscIterative(int n) {
      int[] f = new int[Math.max(n + 1, 2)];
      f[0] = 0;
      f[1] = 1;

      for (int i = 2; i <= n; i++) {
        if (i % 2 == 0) {
          f[i] = f[i / 2];
        } else {
          f[i] = f[i / 2] + f[i / 2 + 1];
        }
      }
      return f[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
            System.out.println("fuscTailRecursive(" + i + ") = " + fuscRec(i));
            System.out.println("fuscIterative(" + i + ") = " + fuscIterative(i));
        }
    }
}