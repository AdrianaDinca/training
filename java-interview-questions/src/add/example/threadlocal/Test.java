package add.example.threadlocal;

public class Test {

    public static void main(String args[]) {
        ThreadId[] threads;
        threads = new ThreadId[2];
        //i.increment();
// System.out.print(i.get());
        for (int i = 0; i < 2; i++) {
            threads[i] = new ThreadId();
        }

        threads[1].set(1);

        for (ThreadId i: threads) i.run();
    }
}
