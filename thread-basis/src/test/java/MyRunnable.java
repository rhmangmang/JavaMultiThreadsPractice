/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2021-05-07 09:48
 * @Version 1.0
 */

public class MyRunnable implements Runnable {
    public boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (flag) {
            System.out.println("打印");
        }
        System.out.println(Thread.currentThread().getName() + " 终止");
    }
}
