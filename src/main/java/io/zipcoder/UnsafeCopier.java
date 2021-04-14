package io.zipcoder;
import static java.lang.Thread.*;
/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    private boolean _debug = false;

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    /// try catch with 100 millisecond sleep

    public void run() {
        while (stringIterator.hasNext()) {

            try {
                sleep(600);
                if (stringIterator.hasNext()) {
                    copied += stringIterator.next() + " ";
                    if (_debug) System.out.println(currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
