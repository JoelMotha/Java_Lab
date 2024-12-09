import java.util.ArrayList;
import java.util.List;

class CoffeeCounter {
    private List<String> counter = new ArrayList<>();
    private final int capacity;

    public CoffeeCounter(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addCoffee(String coffee) {
        while (counter.size() >= capacity) {
            try {
                System.out.println("Barista is waiting. Counter is full.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.add(coffee);
        System.out.println("Barista prepared coffee. Counter: " + counter.size());
        notifyAll();
    }

    public synchronized void pickCoffee(String consumer) {
        while (counter.isEmpty()) {
            try {
                System.out.println(consumer + " is waiting. Counter is empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.remove(0);
        System.out.println(consumer + " picked up coffee. Counter: " + counter.size());
        notifyAll();
    }

    public synchronized void sampleCoffee() {
        while (counter.isEmpty()) {
            try {
                System.out.println("Reviewer is waiting. Counter is empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter.remove(0);
        System.out.println("Reviewer sampled coffee. Counter: " + counter.size());
        notifyAll();
    }
}

class Barista implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;

    public Barista(CoffeeCounter counter, int coffeeCount) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < coffeeCount; i++) {
            try {
                Thread.sleep(500); // Simulate time to prepare coffee
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.addCoffee("Coffee");
        }
    }
}

class Customer implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    public Customer(CoffeeCounter counter, int coffeeCount, String name) {
        this.counter = counter;
        this.coffeeCount = coffeeCount;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < coffeeCount; i++) {
            try {
                Thread.sleep(500); // Simulate time to pick coffee
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.pickCoffee(name);
        }
    }
}

class CoffeeReviewer implements Runnable {
    private final CoffeeCounter counter;

    public CoffeeReviewer(CoffeeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Simulate time to sample coffee
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter.sampleCoffee();
    }
}

public class Lab6_b {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter(3);

        Thread barista1 = new Thread(new Barista(counter, 2), "Barista 1");
        Thread barista2 = new Thread(new Barista(counter, 3), "Barista 2");

        Thread customer1 = new Thread(new Customer(counter, 1, "Customer 1"));
        Thread customer2 = new Thread(new Customer(counter, 2, "Customer 2"));
        Thread customer3 = new Thread(new Customer(counter, 1, "Customer 3"));

        Thread reviewer = new Thread(new CoffeeReviewer(counter), "Reviewer");

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();

        try {
            barista1.join();
            barista2.join();
            customer1.join();
            customer2.join();
            customer3.join();
            reviewer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulation complete.");
    }
}

/* DESCRIPTION
Simulates a coffee shop scenario with multithreading. Baristas (producers)
prepare coffee and add it to a shared counter, while customers (consumers)
pick up coffee from the counter. A coffee reviewer (observer) samples coffee
when available. Synchronization between threads is achieved using wait() and
notifyAll() to ensure proper coordination and avoid race conditions.
*/

/* OUTPUT
Barista prepared coffee. Counter: 1                                                                                                                              
Barista prepared coffee. Counter: 2
Customer 3 picked up coffee. Counter: 1
Customer 2 picked up coffee. Counter: 0
Customer 1 is waiting. Counter is empty.
Reviewer is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Customer 1 picked up coffee. Counter: 0
Reviewer is waiting. Counter is empty.
Customer 2 is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Reviewer sampled coffee. Counter: 0
Customer 2 is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Customer 2 picked up coffee. Counter: 0
Simulation complete.
*/