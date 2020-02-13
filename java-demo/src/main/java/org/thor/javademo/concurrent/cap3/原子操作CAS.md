## 原子操作CAS

### 什么是原子操作？如何实现原子操作？

    * syn基于阻塞的锁的机制，问题：  
        * 被阻塞的线程优先级很高
        * 拿到锁的线程一直不释放怎么办？
        * 大量的竞争，消耗CPU，同时带来死锁或者其他安全。
    
### CAS的原理

CAS（Compare And  Swap）,指令级别保证这是一个原子操作。利用了现代处理器都支持的CAS指令，循环这个指令，直到成功为止。
包含三个运算符： 

    * 一个内存地址V  
    * 一个期望的值A  
    * 一个新值B  

基本思路：如果地址V上的值和期望的值A相等，就给地址V赋予新值B，循环（死循环，自旋）里不断的进行CAS操作

### CAS的问题

    * ABA问题 
        A -> B -> A 加入版本号解决这个问题 A1 -> B2 -> A3
    * 开销问题
        CAS操作长期不成功，cpu不断的循环
    * 只能保证一个共享变量的原子操作
    
### 原子操作类的使用

    * 更新基本类：AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference
    * 更新数组类：AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
    * 更新应用类型：AtomicReference, AtomicMarkableReference, AtomicStampedReference
    * 原子更新字段类：AtomicReferenceFieldUpdater, AtomicIntegerFieldUpdater, AtomicLongFieldUpdater     
    
### JDK中相关原子操作类的使用

    AtomicMarkableReference，boolean 有没有动过
    AtomicStampedReference 动过几次
    

