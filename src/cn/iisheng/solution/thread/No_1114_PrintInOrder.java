package cn.iisheng.solution.thread;

/**
 * @author iisheng
 * @date 2019/07/14 10:11:13
 */
public class No_1114_PrintInOrder {

    public No_1114_PrintInOrder(){
        firstPrinted = false;
        secondPrinted = false;
    }

    private volatile boolean firstPrinted;
    private volatile boolean secondPrinted;

    public static void main(String[] args) {
        new No_1114_PrintInOrder().execute();
    }

    public void execute() {
        try {
            first(() -> System.out.println("first"));
            third(() -> System.out.println("third"));
            second(() -> System.out.println("second"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!firstPrinted) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondPrinted = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!secondPrinted) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
