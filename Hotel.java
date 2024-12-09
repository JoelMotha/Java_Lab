import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class OrderQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int maxSize;

    public OrderQueue(int size) {
        this.maxSize = size;
    }

    public synchronized void addOrder(String order) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait(); // Wait if the queue is full
        }
        queue.add(order);
        System.out.println("Chef added order: " + order);
        notify(); // Notify the waiter that an order is available
    }

    public synchronized String takeOrder() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the queue is empty
        }
        String order = queue.poll();
        notify(); // Notify the chef that there is space in the queue
        return order;
    }
}

class Chef implements Runnable {
    private final OrderQueue orderQueue;
    private final int totalOrders;

    public Chef(OrderQueue orderQueue, int totalOrders) {
        this.orderQueue = orderQueue;
        this.totalOrders = totalOrders;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= totalOrders; i++) {
            try {
                String order = "Order " + i;
                orderQueue.addOrder(order);
                Thread.sleep(random.nextInt(3000) + 1000); //Creates the duration for the wait period while the order is being processed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Waiter implements Runnable {
    private final OrderQueue orderQueue;
    private final int totalOrders;

    public Waiter(OrderQueue orderQueue, int totalOrders) {
        this.orderQueue = orderQueue;
        this.totalOrders = totalOrders;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalOrders; i++) {
            try {
                String order = orderQueue.takeOrder();
                System.out.println("Waiter delivered: " + order);
                Thread.sleep(new Random().nextInt(2000) + 1000); // Creates the time for delivery after order is made
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the order queue: ");
        int maxSize = scanner.nextInt();

        System.out.print("Enter the total number of orders to process: ");
        int totalOrders = scanner.nextInt();
        OrderQueue orderQueue = new OrderQueue(maxSize);
        Thread chefThread = new Thread(new Chef(orderQueue, totalOrders));
        Thread waiterThread = new Thread(new Waiter(orderQueue, totalOrders));

        chefThread.start();
        waiterThread.start();

        try {
            chefThread.join();
            waiterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All orders have been processed.");
        scanner.close();
    }
}