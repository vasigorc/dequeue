package ca.vgorcinschi;

import java.util.Iterator;

/**
 * Created by vgorcinschi on 12/09/16.
 */
public class Dequeue<Item> implements Iterable<Item>{

    DoubleNode first, last;
    int N;

    private class DoubleNode{
        Item item;
        DoubleNode next;
        DoubleNode previous;

        public DoubleNode(Item item) {
            this.item = item;
        }

        public void setNext(DoubleNode node){
            this.next = node;
            node.previous = this;
        }
    }

    public Dequeue() {
        N = 0;
        last = first = null;
    }

    public boolean isEmpty(){ return first==null;}

    public int size(){ return N;}

    public void pushLeft(Item item){
        DoubleNode oldFirst = first;
        first = new DoubleNode(item);
        if (oldFirst != null)first.setNext(oldFirst);
        recalculateLast();
        increment();
    }

    public void pushRight(Item item){
        //first == last == null
        if (last == null) pushLeft(item);
        else{
            DoubleNode oldLast = last;
            last = new DoubleNode(item);
            oldLast.setNext(last);
        }
        increment();
    }

    private void increment() { N++; }

    private void decrement(){ N--; }

    private void recalculateLast(){
        if (first == null) last = null;
        DoubleNode temp = first;
        boolean reachedEnd = false;
        while (!reachedEnd){
            if (temp.next != null)
                temp=temp.next;
            else
                reachedEnd = true;
        }
        last = temp;
    }

    public Item popLeft(){
        if (first == null) return  null;
        Item out = first.item;
        if (first.next == null){
            first = null;
        } else {
            first = first.next;
        }
        decrement();
        return out;
    }

    public Item popRight(){
        if (last == null) return null;
        Item out = last.item;
        if (last.previous == null){
            last=null;
        }else{
            last = last.previous;
        }
        decrement();
        return out;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private DoubleNode current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }
}
