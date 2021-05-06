package syn.usage;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2021-05-06 11:35
 * @Version 1.0
 */

public class ClassLock2 {
    public static void main(String[] args) {

        Service2 service1 = new Service2();
        Service2 service2 = new Service2();

        ThreadA2 a = new ThreadA2(service1);
        a.setName("A");


        ThreadB2 b = new ThreadB2(service2);
        b.setName("B");

        a.start();
        b.start();

    }
}

class Service2 {

    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }

}

class ThreadA2 extends Thread {
    private Service2 service;

    public ThreadA2(Service2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }

}

class ThreadB2 extends Thread {
    private Service2 service;

    public ThreadB2(Service2 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }
}