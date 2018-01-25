package add.example.tailrecursive;

/*
Tail recursion is functionally equivalent to iteration.
Since Java does not yet support tail call optimization, describe how to transform a simple tail recursive function into a loop
and why one is typically preferred over the other.
 */
public class TailRecursive {

    // clasic recursive function
    public static int sumFromOneToN(int n) {
        if (n < 1) {
            return 0;
        }

        return n + sumFromOneToN(n - 1);
    }

    /* this is not allowed in java
    public int sumFromOneToN(int n, int a) {
        if (n < 1) {
            return a;
        }

        return sumFromOneToN(n - 1, a + n);
    }
    */
    /* tail recursive function in java *
       be attentive to StackOverflowError
       the break/return conditions should be well defined
     */
    public static int sumFromOneToN2(int n) {
        int a = 0;

        while(n > 0) {
            a += n--;
        }

        return a;
    }

    public static void main(String []args) {
        long startTime = System.currentTimeMillis();
        sumFromOneToN(10);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.print(duration +"");

        startTime = System.currentTimeMillis();
        sumFromOneToN2(10);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.print(duration + "");
    }
}
