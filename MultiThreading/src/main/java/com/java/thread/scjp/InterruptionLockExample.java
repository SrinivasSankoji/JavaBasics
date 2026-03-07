package com.java.thread.scjp;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptionLockExample {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: Holds the lock for a long time
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread-1 acquired the lock.");
                try {
                    Thread.sleep(5000); // simulate long work
                } catch (InterruptedException e) {
                    // ignored for simplicity
                }
            } finally {
                lock.unlock();
                System.out.println("Thread-1 released the lock.");
            }
        });

        // Thread 2: Tries to acquire the lock interruptibly
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread-2 trying to acquire lock...");
                lock.lockInterruptibly(); // IMPORTANT LINE
                try {
                    System.out.println("Thread-2 acquired the lock.");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread-2 was interrupted while waiting for the lock.");
            }
        });
        t1.start();
        Thread.sleep(100); // ensure t1 gets lock first
        t2.start();
        // Interrupt thread-2 while it is waiting for the lock
        Thread.sleep(2000);
        System.out.println("Main thread interrupting Thread-2...");
        t2.interrupt();
        t1.join();
        t2.join();
        System.out.println("Program finished.");
    }
}

