package org.thor.javademo.concurrent.cap1;


import org.thor.javademo.concurrent.tools.SleepTools;

/**
 *类说明：演示对象锁和类锁
 */
public class Demo9SynClzAndInst {

    /**
     * 使用类锁的线程
     */
    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println("TestClass is running...");
            synClass();
        }
    }

    /**
     * 使用对象锁的线程
     */
    private static class InstanceSyn implements Runnable{
        private Demo9SynClzAndInst demo9SynClzAndInst;

        public InstanceSyn(Demo9SynClzAndInst demo9SynClzAndInst) {
            this.demo9SynClzAndInst = demo9SynClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..."+ demo9SynClzAndInst);
            demo9SynClzAndInst.instance();
        }
    }

    /**
     * 使用对象锁的线程
     */
    private static class Instance2Syn implements Runnable{
        private Demo9SynClzAndInst demo9SynClzAndInst;

        public Instance2Syn(Demo9SynClzAndInst demo9SynClzAndInst) {
            this.demo9SynClzAndInst = demo9SynClzAndInst;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2 is running..."+ demo9SynClzAndInst);
            demo9SynClzAndInst.instance2();
        }
    }

    /**
     * 锁对象
     */
    private synchronized void instance(){
        SleepTools.second(3);
        System.out.println("synInstance is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended "+this.toString());
    }

    /**
     * 锁对象
     */
    private synchronized void instance2(){
        SleepTools.second(3);
        System.out.println("synInstance2 is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 ended "+this.toString());
    }

    /**
     * 类锁，实际是锁类的class对象
     */
    private static synchronized void synClass(){
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    public static void main(String[] args) {
    	Demo9SynClzAndInst demo9SynClzAndInst = new Demo9SynClzAndInst();
    	Thread t1 = new Thread(new InstanceSyn(demo9SynClzAndInst));
    	
    	//SynClzAndInst synClzAndInst2 = new SynClzAndInst();
    	//Thread t2 = new Thread(new Instance2Syn(synClzAndInst));
    	
    	t1.start();
    	//t2.start();
    	
    	SynClass synClass = new SynClass();
    	synClass.start();
    	SleepTools.second(1);
    }
}
