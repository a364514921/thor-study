## 显示锁

###  Lock接口和核心方法
    
    * lock()
    * unlock()
    * tryLock()
    
### Lock接口和synchronized的比较

    * synchronized代码间接
    * Lock：获取锁可以被中断，超时获取锁，尝试获取锁

### 可重入锁ReentrantLock所谓的公平和非公平
    
    如果在是加沙个，先对锁进行获取的请求，一定先被满足，这个锁就是公平的，不满足，就是非公平的
    非公平锁的效率更高，原因：非公平锁允许插队，举例：在B等待的时候C已经插入执行完
    

### ReadWriteLock接口和读写锁ReentrantReadWriteLock, 什么情况下使用读写锁？

    * 排它锁：ReadWriteLock和synchronized都是排它锁。
    * 读写锁：同一时刻允许多个读线程同时访问，但是写线程访问的时候，所有读和写都被阻塞。适用场景：最适宜读多写少的情况。

### Condition接口


### 用Lock和Condition实现等待通知    

### 了解LockSupport工具

    作用：
        * 阻塞一个线程
        * 唤醒一个线程
        * 构建同步组件的基础工具
        
    park开头的方法：阻塞
        
    unpark(Thread thread) 方法：唤醒
    
## AQS（AbstractQueuedSynchronized）   

    什么是AQS？学习它的必要性
        * AQS使用的方式和其中的设计模式
            继承，模版方法设计模式
        * 了解其中的方法(模版方法)
            独占式获取锁
                accquire()
                accquireInterruptibly() 获取锁的时候方法能够响应中断
                tryAccquireNanos()
            共享式获取锁
                acquireShared()
                accquireSharedInterruptibly()
                tryAccquireSharedNanos()          
            独占式释放锁  
                release()           
            共享式释放锁   
                releaseShared()      
                
        - 自己实现锁需要覆盖的流程方法  
             独占式获取
                tryAcquire()
             独占式获取
                tryRelease()
             共享式获取
                tryAcquireShared()
             共享式释放
                tryReleaseShared()
             这个同步器是否处于独占模式   
                isHeldExclusively() 
        - 同步状态 state
            getState() 获取当前的同步状态
            setState() 设置当前的同步状态
            compareAndSetState() 使用CAS设置状态，保证状态设置的原子性
                      
        * 实现一个类似于ReentrantLock锁
        
    AQS中的数据结构-节点和同步队列
    
## AQS中的数据结构 

### 节点和同步队列

![image.png](https://upload-images.jianshu.io/upload_images/4617498-497443ffefe9020b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Node里的节点状态：

* CANCELLED: 线程等待超时或者被中断了，需要从队列中移走
* SIGNAL: 后续的节点等待状态，当前节点，通知后面的节点去运行
* CONDITION: 当前节点处于等待队列
* PROPAGATE: 共享，表示状态要往后面的节点传播
* 0: 表示初始

### 节点在同步队列中的增加和移出

![image.png](https://upload-images.jianshu.io/upload_images/4617498-2a9ab09ca586e9f9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 独占式同步状态获取与释放

![image.png](https://upload-images.jianshu.io/upload_images/4617498-d4bac7513c350f34.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 其他同步状态获取与释放

* 共享式同步状态获取与释放
* 独占式超时同步状态获取
 
 
### Condition分析

![image.png](https://upload-images.jianshu.io/upload_images/4617498-7ce93a8b1bf25f53.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 节点在队列之间的移动

![image.png](https://upload-images.jianshu.io/upload_images/4617498-8180795bed1f9cad.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


   
       
   
        
        
     
    