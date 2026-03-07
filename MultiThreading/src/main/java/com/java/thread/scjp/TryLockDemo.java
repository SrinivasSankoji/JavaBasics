package com.java.thread.scjp;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> refreshCache("Thread-1", 5000), "Thread-1");
        Thread t2 = new Thread(() -> refreshCache("Thread-2", 2000), "Thread-2");
        Thread t3 = new Thread(() -> refreshCache("Thread-3", 2000), "Thread-3");

        // Start Thread-1 first so it surely holds the lock
        t1.start();
        Thread.sleep(100);

        // These threads will try to acquire lock while Thread-1 is holding it
        t2.start();
        t3.start();

        // After Thread-1 releases the lock, simulate a later request
        Thread.sleep(5500);
        Thread t4 = new Thread(() -> refreshCache("Thread-4", 1000), "Thread-4");
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Program finished.");
    }

    private static void refreshCache(String threadName, long workMs) {
        System.out.println(threadName + " -> Trying tryLock()");
        // Important line : tryLock() does not wait
        if (lock.tryLock()) {
            try {
                System.out.println(threadName + " -> Lock acquired. Refreshing cache...");
                Thread.sleep(workMs); // simulate long refresh work
                System.out.println(threadName + " -> Refresh complete.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(threadName + " -> Interrupted during work.");
            } finally {
                lock.unlock();
                System.out.println(threadName + " -> Lock released.");
            }
        } else {
            // fallback path
            System.out.println(threadName + " -> Lock busy. Skipping refresh (fallback path).");
        }
    }
}
