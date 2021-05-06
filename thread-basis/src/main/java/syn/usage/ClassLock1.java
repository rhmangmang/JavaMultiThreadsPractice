package syn.usage;

/**
 * @Description 打印的结果为异步的原因是：这两个方法持有不同的锁。一个是实例对象的锁，另一个是Class锁。
 * （Class锁可以对该类的所有实例对象起作用）
 * @Author rhmangmang
 * @Date 2021-05-06 11:29
 * @Version 1.0
 */

public class ClassLock1 {
    public static void main(String[] args) {

        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");

        ThreadB b = new ThreadB(service);
        b.setName("B");

        a.start();
        b.start();

    }
}


class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }

}

class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }
}


class Service {
    public synchronized static void printA() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printA");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printA");
    }

    public synchronized void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                + System.currentTimeMillis() + "离开printB");
    }

}