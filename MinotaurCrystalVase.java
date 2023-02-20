/*
Srignan Paruchuru
COP 4520
2/15/2023
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;

class MinotaurCrystalVase {
    final static int N = 1000;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Thread[] t = new Thread[N];

        for (int i = 0; i < N; i++) {
            t[i] = new Thread(new WorkerTwo(i)); }

        for (int i = 0; i < N; i++) {
            q.add(i); }

        while (!q.isEmpty()) {
            int i = q.remove();

            try {
                t[i].run();
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All of the guests entered the vase room");
        long endTime = System.nanoTime();
        try {
            FileWriter myOutput = new FileWriter("CrystalVaseTime.txt");
            myOutput.write("Execution Time: " + (endTime - startTime) + " Nanoseconds\n");
            myOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static class WorkerTwo extends Thread {
        int index;
        public WorkerTwo(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("Guest " + index + " has entered the room");

            System.out.println("Guest " + index + " has left the room");

            // Guest re-enters q half the time
            if (Math.random() < 0.5) {
                q.add(index);
                System.out.println("Guest " + index + " has re-entered the line");
            }
        }
    }
}