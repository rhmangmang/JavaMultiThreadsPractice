/**
 * @Description "守护"具有陪伴的含义。因此，当进程中的非守护线程都消失时，守护线程将会自动销毁。该类将模拟守护线程。
 * @Author rhmangmang
 * @Date 2021-04-27 16:56
 * @Version 1.0
 */

public class ThreadDaemon extends Thread{
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            ++i;
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadDaemon thread = new ThreadDaemon();
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(5000);
            System.out.println("main函数执行完毕后，thread对象也不再打印了。因为其是守护线程，将停止。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
