package ca.vgorcinschi;

import java.util.Iterator;

import static java.lang.Integer.valueOf;

/**
 * Created by vgorcinschi on 13/09/16.
 */
public class AppRunner {
    public static void main(String[] args) {
        Dequeue<Integer> dequeue = new Dequeue();
        for (int i = 5; i >= 1; i--) {
            dequeue.pushLeft(valueOf(i));
        }
        for (int i = 6; i < 11; i++) {
            dequeue.pushRight(valueOf(i));
        }
        System.out.println("...after pushing:");
        Iterator<Integer> iter = dequeue.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
        for (int i = 0; i < 5; i++) {
            System.out.println("poping: "+dequeue.popLeft());
        }
        for (int i=0; i <5; i++)
            System.out.println("poping: "+dequeue.popRight());
        System.out.println("...after popping:");
        System.out.println("The size of the dequeue with unique id "+System.identityHashCode(dequeue)+
                " is "+dequeue.size());
    }
}
