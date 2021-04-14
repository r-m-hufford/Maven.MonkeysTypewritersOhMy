package io.zipcoder;

public class SimpleCopier extends Copier{

    public SimpleCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (stringIterator.hasNext()) {
            copied += stringIterator.next() + " ";

        }
    }
}
