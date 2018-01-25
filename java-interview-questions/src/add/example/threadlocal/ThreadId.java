package add.example.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/*
What is the ThreadLocal class? How and why would you use it?

A single ThreadLocal instance can store different values for each thread independently.
Each thread that accesses the get() or set() method of a ThreadLocal instance is accessing its own, independently initialized copy of the variable.
ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or transaction ID).
The example below, from the ThreadLocal Javadoc, generates unique identifiers local to each thread.
A thread’s id is assigned the first time it invokes ThreadId.get() and remains unchanged on subsequent calls.
 */
public class ThreadId implements  Runnable{
    // Next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }

            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static void set(int i) {
        threadId.set(i);
    }

    @Override
    public void run() {
        System.out.print(threadId.get());
    }
}