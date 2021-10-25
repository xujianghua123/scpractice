package com.h.test.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Task(semaphore,"Task-" + i)).start();
        }
    }


    static class Task implements Runnable{
        private Semaphore semaphore;
        private String taskName;

        public Task(Semaphore semaphore,String taskName){
            this.semaphore = semaphore;
            this.taskName = taskName;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "  " + taskName + "  start ");
                Thread.sleep(5000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "  " + taskName + "  end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
