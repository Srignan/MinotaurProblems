/*
Srignan Paruchuru
COP 4520
2/15/2023
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.*;

class MinotaurBirthday {
    final static int N = 100;
    static AtomicInteger count =  new AtomicInteger(0);
    static AtomicBoolean leader = new AtomicBoolean(false);
    public static void main(String[] args) {

        Thread[] t = new Thread[N];
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            t[i] = new Thread(new WorkerOne());
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i);
        }

        while (count.intValue() < N) {
            int i = q.remove();

            leader.set(i == 0);

            try {
                t[i].run();
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace(); }

            q.add(i);
        }
        System.out.println("All of the guests entered the maze");
        long endTime = System.nanoTime();
        try {
            FileWriter myOutput = new FileWriter("birthdayTime.txt");
            myOutput.write("Execution Time: " + (endTime - startTime) + " Nanoseconds\n");
            myOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class WorkerOne extends Thread {
        boolean cake;

        public WorkerOne() {
            cake = true;
        }
        public void run() {
            if (leader.get()) {
                count.getAndIncrement();
                System.out.println("Counter: " + count);
            }
            else {
                if (cake) {
                    cake = false;
                    System.out.println("Guest ate the cake");
                }
                else {
                    System.out.println("Guest already ate the cake");
                }
            }
        }
    }
}