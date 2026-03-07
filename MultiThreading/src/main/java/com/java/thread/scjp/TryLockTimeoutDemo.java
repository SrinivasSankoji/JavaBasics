package com.java.thread.scjp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTimeoutDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread-1 acquired lock. Holding for 5 seconds...");
                sleepSilently(5);
                System.out.println("Thread-1 done. Releasing lock.");
            } finally {
                lock.unlock();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread-2 trying to acquire lock with 2s timeout...");

                // IMPORTANT LINE: wait up to 2 seconds to acquire the lock
                boolean acquired = lock.tryLock(2, TimeUnit.SECONDS);

                if (acquired) {
                    try {
                        System.out.println("Thread-2 acquired lock within timeout. Processing...");
                        sleepSilently(1);
                    } finally {
                        lock.unlock();
                        System.out.println("Thread-2 released lock.");
                    }
                } else {
                    // Fallback path: lock not acquired within timeout
                    System.out.println("Thread-2 timed out! Could not acquire lock within 2 seconds.");
                }

            } catch (InterruptedException e) {
                System.out.println("Thread-2 interrupted while waiting for lock.");
                Thread.currentThread().interrupt();
            }
        }, "Thread-2");

        t1.start();

        // Small delay so Thread-1 almost certainly grabs the lock first
        Thread.sleep(100);

        t2.start();

        t1.join();
        t2.join();

        System.out.println("Program finished.");
    }

    private static void sleepSilently(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
