import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private int size;
    private Item[] RQueue;

    public RandomizedQueue() {
        RQueue = (Item[]) new Object[1];
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void enqueue(Item item) {
        if (null == item) {
            throw new IllegalArgumentException("Item is null");
        }
        if (size == RQueue.length)
            resize(RQueue.length*2);
        RQueue[size++] = item;
    }
    
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException(" que is empty.");
        }
        int rd = StdRandom.uniform(size);
        Item item = RQueue[rd];
        if (rd != size-1){
            RQueue[rd] = RQueue[size-1];
        }
        RQueue[size-1] = null;
        size--;
        if (size > 0 && size == RQueue.length/4)
            resize(RQueue.length/2);
        return item;
    }
    
    // return random elem but does not remove
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException(" que is empty.");
        }
        int rd = StdRandom.uniform(size);
        Item i = RQueue[rd];
        return i;
    }
    
    private void resize(int capacity) {
        assert capacity >= size;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = RQueue[i];
        }
        RQueue = copy;
        copy = null;
    }

    public Iterator<Item> iterator() {
        return new RQueueIterator();
    }
    
    private class RQueueIterator implements Iterator<Item> {
        private Item[] copy =(Item[]) new Object[RQueue.length];
        private int copySize = size;
        
        public RQueueIterator() {
            for (int i = 0; i < RQueue.length; i++) {
                copy[i] = RQueue[i];
            }
        }
        
        @Override
        public boolean hasNext() {
            return copySize > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int rd = StdRandom.uniform(copySize);
            Item item = copy[rd];
            if (rd != copySize - 1)
                copy[rd] = copy[copySize-1];
            copy[copySize-1] = null;
            copySize--;
            return item;
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("om");
        String op = rq.dequeue();
        StdOut.println("" + op);
    }
}