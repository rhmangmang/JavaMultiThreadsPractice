package thread.usage;

/**
 * @Description 默认情况下，所有线程的优先级都是5 {@link Thread#NORM_PRIORITY}
 * @Author rhmangmang
 * @Date 2021-04-27 16:05
 * @Version 1.0
 */

public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("main begin priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main end priority = " + Thread.currentThread().getPriority());

        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4(thread3);
        thread4.setName("thread4");
        thread4.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("thread.usage.Thread1's priority = " + this.getPriority());

        Thread2 thread2 = new Thread2();
        thread2.start();
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread.usage.Thread2's priority = " + this.getPriority());
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println("thread.usage.Thread3's priority = " + this.getPriority());
    }
}

class Thread4 extends Thread {
    Thread thread3;
    public Thread4(Thread thread3) {
        this.thread3 = thread3;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(2);
        System.out.println("thread.usage.Thread4's priority = " + this.getPriority() + " current Thread = " + Thread.currentThread().getName());
        thread3.start();
    }
}