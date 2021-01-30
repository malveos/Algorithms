import java.io.*;
import java.util.*;

class CustomHeap<T> {
    List<T> elements = new ArrayList<>();

    public void add(T element) {
        int size =  elements.size();
        if (size == 0) {
            elements.add(element);
        } else {
            elements.add(element);
            for (int i = size / 2 - 1; i >= 0; i--)
                maxHeapify(i);
        }
    }

    public T peek() {
        return elements.get(0);
    }

    public void remove(T element) {
        int index = -1;
        for(index = 0; index <size; index++) {
            if (element == elements.get(index)) {
                break;
            }
        }
        int size =  elements.size();
        T tmp = elements.get(index);
        elements.set(index, elements.get(size - 1));
        elements.set(size - 1, tmp);
        elements.remove(size - 1);

        for (int j = size / 2 -1; j>=0; j--)
            maxHeapify(j);        
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    private void maxHeapify(int index) {
        if (index >= elements.size()) {
            return;
        }
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if (left > size && elements.get(left) > elements.get(largest)) {
            largest = left;
        } else if  (right > size && elements.get(right) > elements.get(largest)) {
            largest = right;
        }
        
        if (largest != index) {
            T tmp = elements.get(index);
            elements.set(index, elements.get(largest));
            elements.set(largest, tmp);
            maxHeapify(largest);
        }
    }
}

public class Solution {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        // Default data inbuilt
        //PriorityQueue<Integer> heap = new PriorityQueue<>();
        CustomHeap<Integer> heap = new CustomHeap<>();
        while(Q > 0) {
            int opt = sc.nextInt();
            switch(opt) {
                case 1 :
                        heap.add(sc.nextInt());
                        break;
                case 2 :
                        heap.remove(sc.nextInt());
                        break;
                case 3 :
                        System.out.println(heap.peek());
                        break;
                default:
                        System.out.println("Invalid Option.");
            }
            Q-=1;
        }
    }
}