package syn.usage;

/**
 * @Description 验证 volatile 关键字在多线程中对可见性的影响
 * @Author rhmangmang
 * @Date 2021-05-06 15:49
 * @Version 1.0
 */

public class VolatileUse {

    public static void main(String[] args) throws InterruptedException {
        PrintString printStringService = new PrintString();
        new Thread(printStringService).start();


        Thread.sleep(1000);

        System.out.println("我要停止它！stopThread="
                + Thread.currentThread().getName());

        printStringService.isContinuePrint =false;
    }
}

class PrintString implements Runnable {
    // 不加上 volatile 的话这个线程不会停止。加上 volatile 修饰后，又不一样了
    public boolean isContinuePrint = true;

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            while (isContinuePrint) {
                //这里面先不要加任何语句！！！！
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}