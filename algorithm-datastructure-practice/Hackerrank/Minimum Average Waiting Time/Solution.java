import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Customer implements Comparable<Customer> {
    int orderTime;
    int serveTime;

    public Customer(int orderTime, int serveTime) {
        this.orderTime = orderTime;
        this.serveTime = serveTime;
    }
    
    public int compareTo(Customer other) {
        if (other.serveTime < this.serveTime) {
            return this.orderTime;
        }
        return -1;
    }

    public String toString() {
        return "[orderTime-"+orderTime+",  serveTime-"+serveTime+"]";
    }
}

public class Solution {

    static void printList(Customer[] c) {
        for (Customer cus : c)
            System.out.print(cus + " ->");
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCustomers = in.nextInt();
        Customer[] customers = new Customer[numOfCustomers];

        for (int i = 0; i < numOfCustomers; i++) {
            int orderTime = in.nextInt();
            int serveTime = in.nextInt();
            customers[i] = new Customer(orderTime, serveTime);
        }
        in.close();

        Arrays.sort(customers, Comparator.comparingInt(o -> o.orderTime));

        Queue<Customer> waitTime = new PriorityQueue<>();
        long currentTime = 0L;
        long totalWaitTime = 0L;
        int index = 0;

        while (!waitTime.isEmpty() || index < customers.length) {
            while (index < customers.length && customers[index].orderTime <= currentTime) {
                waitTime.add(customers[index]);
                index++;
            }
            if (waitTime.isEmpty()) {
                currentTime = customers[index].orderTime;
                continue;
            }

            Customer served = waitTime.poll();
            currentTime += served.serveTime;
            totalWaitTime += currentTime - served.orderTime;
        }

        System.out.println(totalWaitTime / customers.length);
    }
}
