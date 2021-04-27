# JavaMultiThreadsPractice

#### 1. ThreadBasis
    介绍 Thread.currentThread() 和 this（这个this等价于ThreadBasis的实例类，且其继承了Thread类） 的区别
    
#### 2. ThreadSuspend
    线程暂停与恢复的方法学习，以及其缺陷了解

#### 3. Thread.yield() 方法
    该方法使得当前线程放弃当前 CPU 资源，让给其他的任务去使用CPU。但有可能刚刚放弃，又获得 CPU 时间片了。
    
#### 4. 线程优先级
    线程优先级的继承性：在Java中，如在A线程中创建B线程，则B线程和A线程的优先级是一样的。

#### 4. 守护线程（Daemon）
    "守护"具有陪伴的含义。因此，当进程中的非守护线程都消失时，守护线程将会自动销毁。垃圾回收线程就是典型的守护线程
