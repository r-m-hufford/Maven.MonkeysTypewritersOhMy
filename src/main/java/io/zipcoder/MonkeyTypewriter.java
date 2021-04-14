package io.zipcoder;

import java.util.ArrayList;

public class MonkeyTypewriter {

    String introduction = "It was the best of times,\n" +
            "it was the blurst of times,\n" +
            "it was the age of wisdom,\n" +
            "it was the age of foolishness,\n" +
            "it was the epoch of belief,\n" +
            "it was the epoch of incredulity,\n" +
            "it was the season of Light,\n" +
            "it was the season of Darkness,\n" +
            "it was the spring of hope,\n" +
            "it was the winter of despair,\n" +
            "we had everything before us,\n" +
            "we had nothing before us,\n" +
            "we were all going direct to Heaven,\n" +
            "we were all going direct the other way--\n" +
            "in short, the period was so far like the present period, that some of\n" +
            "its noisiest authorities insisted on its being received, for good or for\n" +
            "evil, in the superlative degree of comparison only. ";

    public final int MaxThreads = 16;
    private int max = 0;

    public static void main(String[] args) {

        MonkeyTypewriter typewriter = new MonkeyTypewriter();
        typewriter.runThreads();
    }

    public void runThreads() {
        for (max = MaxThreads; max <= MaxThreads; max++) {
            UnsafeCopier unsafe = new UnsafeCopier(introduction);

            if (false) {
                this.unsafeSplitStart(unsafe);
            } else {
                this.unsafeArrayList(unsafe);
            }

            try {
                Thread.sleep(2000);
                System.out.printf("***** UNSAFE (%d)\n", max);
                System.out.println(unsafe.copied);
                System.out.printf("***** UNSAFE (%d) diff: (%d)\n", max,
                        introduction.length() - unsafe.copied.length());
                if (unsafe.copied.equals(introduction)) {
                    System.out.println("** UNSAFE pass");
                } else {
                    System.out.println("*** UNSAFE FAIL!!!");
                }
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }

            boolean runSafe = true;
            if (runSafe) {
                SafeCopier safe = new SafeCopier(introduction);
                this.safe(safe);
            }
        }
    }

    public void unsafeArrayList(UnsafeCopier unsafe) {
        ArrayList<Thread> unsafeThreads = new ArrayList<Thread>();

        for (int i = 0; i < max; i++) {
            unsafeThreads.add(new Thread(unsafe));
        }

        for (int i = 0; i < max; i++) {
            unsafeThreads.get(i).start();
        }
    }

    public void unsafeSplitStart(UnsafeCopier unsafe) {
        for (int i = 0; i < max; i++) {
            new Thread(unsafe).start();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unsafeArrayStart(UnsafeCopier unsafe) {
        ArrayList<Thread> unsafeThreads = new ArrayList<Thread>();

        for (int i = 0; i < max; i++) {
            unsafeThreads.add(new Thread(unsafe));
        }

        for (int i = 0; i < max; i++) {
            unsafeThreads.get(i).start();
        }
    }

    public void safe(SafeCopier safe) {
        for (int i = 0; i < 5; i++) {
            new Thread(safe).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("***** SAFE");
        System.out.println(safe.copied);
        System.out.println("***** SAFE");

        if (safe.copied.equals(introduction)) {
            System.out.println("SAFE PASS");
        } else {
            System.out.println("SAFE FAIL");
        }
    }
}






        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
   /*     try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
*/
        // Print out the copied versions here.
        // java time execution lines - how to measure elapsed or execution times
        // current time milliseconds
        // the iterator is only one in the program
        // each thread has a separate copy. What they agree on is not the final product because they never agreed on anything to begin with.
        // copied was changed out from underneath me it gets worse and worse.


// Long delay = more corruption.