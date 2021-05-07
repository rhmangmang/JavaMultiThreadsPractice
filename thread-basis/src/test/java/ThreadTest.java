/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2021-05-07 09:46
 * @Version 1.0
 */

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();

        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(runnable, i + " ");
            thread.start();
        }

        Thread.sleep(2000L);
        System.out.println("-----------");

        runnable.flag = false;

    }
}
