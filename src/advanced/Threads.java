package advanced;

public class Threads {

    public static void main(String[] args) {

        // extends Thread
        MultithreadingThingFirstWay myThing = new MultithreadingThingFirstWay(100);
        MultithreadingThingFirstWay myOtherThing = new MultithreadingThingFirstWay(200);

        //Start is the correct method to execute threads at the same time

        System.out.println("starting....1");
        myThing.start();
        System.out.println("starting....2");
        myOtherThing.start();

        for (int i = 0; i < 5; i++) {
            MultithreadingThingFirstWay thing = new MultithreadingThingFirstWay(i);
            System.out.println("restarting....3 " + " ( " + i + ") ");
            thing.start();
        }


        // implements Runnable
        MultithreadingThingSecondWay mySecondThing = new MultithreadingThingSecondWay(300);
        MultithreadingThingSecondWay mySecondOtherThing = new MultithreadingThingSecondWay(400);

        //Start is the correct method to execute threads at the same time

        Thread mySecondThingThread = new Thread(mySecondThing);
        mySecondThingThread.start();

        Thread mySecondOtherThingThread = new Thread(mySecondOtherThing);
        mySecondOtherThingThread.start();

        Thread calculateAsync = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("In calculate Async " + Thread.currentThread());
            }
        }, "async");
        calculateAsync.start();

        for (int i = 0; i < 5; i++) {
            MultithreadingThingSecondWay thing = new MultithreadingThingSecondWay(i);
            Thread thread = new Thread(thing);
            thread.start();
        }
    }
}

class MultithreadingThingFirstWay extends Thread {

    private int threadNumber;

    public MultithreadingThingFirstWay(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " from thread number " + threadNumber);

            if (threadNumber == 3) {
                throw new RuntimeException("The thread number " + threadNumber + " crashed");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MultithreadingThingSecondWay implements Runnable {

    private int threadNumber;

    public MultithreadingThingSecondWay(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " from thread number " + threadNumber + ", Current thread: " + Thread.currentThread());

            if (threadNumber == 3) {
                throw new RuntimeException("The thread number " + threadNumber + " crashed");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * NOTES
 * <p>
 * Ways to implement multi-threads in Java.
 * <p>
 * 1. Extends Thread
 * 2. Implements Runnable  // Better because you can implement to multiple interfaces but you can only extend one class that's why is more flexible
 * <p>
 * -- If one thread crashes this doesn't affect the other running threads
 *
 *
 *
 * Synchronized: Only one thread can access to a method or a resource
 *
 */
