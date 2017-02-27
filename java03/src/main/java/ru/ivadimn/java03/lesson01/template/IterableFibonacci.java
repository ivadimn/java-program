package ru.ivadimn.java03.lesson01.template;

import java.util.Iterator;

/**
 * Created by vadim on 26.02.2017.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count) {
        n = count;
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for ( int i : new IterableFibonacci(18)) {
            System.out.println(i + " ");
        }
    }
}
