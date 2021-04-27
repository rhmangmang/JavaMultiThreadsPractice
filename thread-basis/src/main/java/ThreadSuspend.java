/**
 * @Description 线程暂停与恢复的方法学习
 * @Author rhmangmang
 * @Date 2021-04-27 15:40
 * @Version 1.0
 */

public class ThreadSuspend extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSuspend thread = new ThreadSuspend();
        thread.start();
        Thread.sleep(1000);
        thread.suspend();

        // "main end!" 永远不会被打印。因为，System.out.println中使用了 synchronized
        // 当ThreadSuspend被暂停后，不会释放 synchronized 锁的对应。
        System.out.println("main end!");
    }
}
