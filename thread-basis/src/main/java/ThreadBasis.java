/**
 * @Description 主要是介绍 Thread.currentThread() 和 this（这个this等价于ThreadBasis的实例类，且其继承了Thread类） 的区别
 * @Author rhmangmang
 * @Date 2021-04-27 14:44
 * @Version 1.0
 */

public class ThreadBasis extends Thread {
    public ThreadBasis () {
        System.out.println("ThreadBasis begin---");

        // 因为这个构造函数是main函数调用的，所以当前线程是main
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());

        // this 表示的就是 ThreadBasis 这个线程。
        // 此时，ThreadBasis这个线程还没被调度，处理构造的状态，所以alive是false
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());

        System.out.println("ThreadBasis end---");
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("run begin---");


        //
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());

        // this.getName() 这个值不会为 A。
        // 因为这个线程是 thread1，而不是 threadBasis，所以这个值应该为 basis
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());

        System.out.println("run end---");
    }

    public static void main(String[] args) {
        ThreadBasis threadBasis = new ThreadBasis();
        Thread thread1 = new Thread(threadBasis);

        System.out.println("main begin---");
        // 线程还没开始，所以alive是false
        System.out.println("thread1.isAlive() = " + thread1.isAlive());

        threadBasis.setName("basis");
        thread1.setName("A");
        thread1.start();
        // 这个alive的值不一定，看线程调度的速度咋样了
        System.out.println("thread1.isAlive() = " + thread1.isAlive());
        System.out.println("main end---");
    }
}


