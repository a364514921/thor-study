# MyCat

## 一、概述
### 1.1 是什么
### 1.2 干什么
### 1.3 原理

## 二、安装启动
### 2.1 安装
- 将安装包上传至/opt目录
```shell script
[root@iZbp1i0x4t16rv8q20zeiwZ minio]# cd /opt/
[root@iZbp1i0x4t16rv8q20zeiwZ opt]# ls
containerd  Mycat-server-1.6.7.1-release-20190627191042-linux.tar.gz  Mycat-web-1.0-SNAPSHOT-20170102153329-linux.tar.gz  zookeeper-3.4.11.tar.gz
```
- 解压，并将加压后文件拷贝到软件安装目录:/usr/local
```shell script
[root@iZbp1i0x4t16rv8q20zeiwZ opt]# tar -zxvf Mycat-server-1.6.7.1-release-20190627191042-linux.tar.gz 
[root@iZbp1i0x4t16rv8q20zeiwZ opt]# ls
containerd  mycat  Mycat-server-1.6.7.1-release-20190627191042-linux.tar.gz  Mycat-web-1.0-SNAPSHOT-20170102153329-linux.tar.gz  zookeeper-3.4.11.tar.gz
[root@iZbp1i0x4t16rv8q20zeiwZ opt]# cp -r mycat /usr/local/
[root@iZbp1i0x4t16rv8q20zeiwZ opt]# ls /usr/local/
aegis  bin  etc  games  include  lib  lib64  libexec  mycat  sbin  share  src
```

- 三个配置文件
    
1.schema.xml: 定义逻辑库，表、分片节点等内容
2.rule.xml: 定义分片规则
3.server.xml: 定义用户以及系统相关变量，如端口等

```shell script
[root@iZbp1i0x4t16rv8q20zeiwZ local]# cd mycat/
[root@iZbp1i0x4t16rv8q20zeiwZ mycat]# ls
bin  catlet  conf  lib  logs  version.txt
[root@iZbp1i0x4t16rv8q20zeiwZ mycat]# cd conf/
[root@iZbp1i0x4t16rv8q20zeiwZ conf]# ls
autopartition-long.txt      cacheservice.properties  index_to_charset.properties  myid.properties          rule.xml                  sequence_db_conf.properties           server.xml            zkconf
auto-sharding-long.txt      dbseq.sql                log4j2.xml                   partition-hash-int.txt   schema.xml                sequence_distributed_conf.properties  sharding-by-enum.txt  zkdownload
auto-sharding-rang-mod.txt  ehcache.xml              migrateTables.properties     partition-range-mod.txt  sequence_conf.properties  sequence_time_conf.properties         wrapper.conf
```

### 2.2 启动

- 修改配置文件server.xml

修改用户信息，与MySQL区分，如下：
```xml script
 <user name="mycat" defaultAccount="true">
                <property name="password">123456</property>
                <property name="schemas">TESTDB</property>

                <!-- 表级 DML 权限设置 -->
                <!--            
                <privileges check="false">
                        <schema name="TESTDB" dml="0110" >
                                <table name="tb01" dml="0000"></table>
                                <table name="tb02" dml="1111"></table>
                        </schema>
                </privileges>           
                 -->
        </user>
```

- 修改配置文件 schema.xml

删除<schema>标签间的表信息，<dataNode>标签只留一个，<dataHost>标签只留一个，<writeHost> <readHost>只留一对

```xml script
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://io.mycat/">

        <schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100" dataNode="dn1">
        </schema>
        <dataNode name="dn1" dataHost="host1" database="testdb" />
        <dataHost name="host1" maxCon="1000" minCon="10" balance="0"
                          writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
                <heartbeat>select user()</heartbeat>
                <!-- can have multi write hosts -->
                <writeHost host="hostM1" url="47.98.181.17:3307" user="root"
                                   password="root">
                        <!-- can have multi read hosts -->
                        <readHost host="hostS2" url="47.98.181.17:3308" user="root" password="root" />
                </writeHost>
        </dataHost>
</mycat:schema>
```

- 验证数据库访问情况

Mycat 作为数据库中间件要和数据库部署在不同机器上，所以要验证远程访问情况。
```sql
mysql -uroot -proot -h 47.98.181.17 -P 3307
mysql -uroot -proot -h 47.98.181.17 -P 3308
```
> 如远程访问报错，请建对应用户
>grant all privileges on *.* to root@'缺少的host' identified by 'root';

- 启动程序

1.控制台启动 ：去 mycat/bin 目录下执行 ./mycat console
2.后台启动 ：去 mycat/bin 目录下 ./mycat start
为了能第一时间看到启动日志，方便定位问题，我们选择①控制台启动。

启动成功
```shell
[root@pve-ct01 bin]# ./mycat console
Running Mycat-server...
wrapper  | --> Wrapper Started as Console
wrapper  | Launching a JVM...
jvm 1    | Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=64M; support was removed in 8.0
jvm 1    | Wrapper (Version 3.2.3) http://wrapper.tanukisoftware.org
jvm 1    |   Copyright 1999-2006 Tanuki Software, Inc.  All Rights Reserved.
jvm 1    | 
jvm 1    | MyCAT Server startup successfully. see logs in logs/mycat.log
```

### 2.3 登陆

1、登录后台管理窗口(此登录方式用于管理维护 Mycat)

```sql
mysql -umycat -p123456 -P 9066 -h 192.168.0.177
```
```shell script
➜  ~ mysql -umycat -p123456 -P 9066 -h 192.168.0.177  
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 1
Server version: 5.6.29-mycat-1.6.7.1-release-20190627191042 MyCat Server (monitor)

Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> 

```

2、登录数据窗口
此登录方式用于通过 Mycat 查询数据，我们选择这种方式访问 Mycat

```sql
mysql -umycat -p123456 -P 8066 -h 192.168.0.177
```

## 三、搭建读写分离
### 3.1 搭建一主一从

一个主机用于处理所有写请求，一台从机负责所有读请求，架构图如下
![image.png](https://upload-images.jianshu.io/upload_images/4617498-493e233c7b6982a9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1. 搭建MySQL主从复制
1.1 主从复制原理
![image.png](https://upload-images.jianshu.io/upload_images/4617498-bb91934565f1ce36.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1.2 主机配置
```text
修改配置文件：vim /etc/my.cnf

[mysqld]
## 设置server_id，同一局域网中需要唯一
server_id=101
## 开启二进制日志功能
log-bin=mysql-bin
## 设置不要复制的数据库(可设置多个)
binlog-ignore-db=mysql
binlog-ignore-db=information_schema
## 设置需要复制的数据库
#binlog-do-db=需要复制的主数据库名字
## 设置二进制日志使用内存大小（事务）
binlog_cache_size=1M
## 设置使用的二进制日志格式（mixed,statement,row）
binlog_format=mixed
## 二进制日志过期清理时间。默认值为0，表示不自动清理。
expire_logs_days=7
## 跳过主从复制中遇到的所有错误或指定类型的错误，避免slave端复制中断。
## 如：1062错误是指一些主键重复，1032错误是因为主从数据库数据不一致
slave_skip_errors=1062
## 不区分大小写
lower_case_table_names=1
```

1.3 从机配置
```text
[mysqld]
## 设置server_id，同一局域网中需要唯一
server_id=102
## 指定不需要同步的数据库名称
binlog-ignore-db=mysql
## 开启二进制日志功能，以备Slave作为其它数据库实例的Master时使用
log-bin=mysql-slave1-bin     
## 设置二进制日志使用内存大小（事务）
binlog_cache_size=1M
## 设置使用的二进制日志格式（mixed,statement,row）
binlog_format=mixed
## 二进制日志过期清理时间。默认值为0，表示不自动清理。
expire_logs_days=7
## 跳过主从复制中遇到的所有错误或指定类型的错误，避免slave端复制中断。
## 如：1062错误是指一些主键重复，1032错误是因为主从数据库数据不一致
slave_skip_errors=1062
## relay_log配置中继日志
relay_log=mysql-relay-bin     
## log_slave_updates表示slave将复制事件写进自己的二进制日志
log_slave_updates=1
## slave设置为只读（具有super权限的用户除外）
read_only=1

```

1.4 主机、从机重启 MySQL 服务

1.5 主机从机都关闭防火墙

1.6 创建数据同步用户：
```sql
CREATE USER 'slave'@'%' IDENTIFIED BY '123456';
GRANT REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'slave'@'%';

```

1.7 连接到主数据库的mysql客户端，查看主数据库状态：

```text
mysql> show master status;
+------------------+----------+--------------+--------------------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB               | Executed_Gtid_Set |
+------------------+----------+--------------+--------------------------------+-------------------+
| mysql-bin.000002 |      154 |              | mysql,mysql,information_schema |                   |
+------------------+----------+--------------+--------------------------------+-------------------+
1 row in set (0.00 sec)

```

1.8 连接到从数据库的mysql客户端，配置主数据库相关信息

```sql
change master to master_host='47.98.181.17', master_user='slave', master_password='123456', master_port=3307, master_log_file='mysql-bin.000001', master_log_pos=154, master_connect_retry=30;  

```
主从复制命令参数说明：

master_host：主数据库的IP地址；
master_port：主数据库的运行端口；
master_user：在主数据库创建的用于同步数据的用户账号；
master_password：在主数据库创建的用于同步数据的用户密码；
master_log_file：指定从数据库要复制数据的日志文件，通过查看主数据的状态，获取File参数；
master_log_pos：指定从数据库从哪个位置开始复制数据，通过查看主数据的状态，获取Position参数；
master_connect_retry：连接失败重试的时间间隔，单位为秒。

1.9 启动从服务器复制功能

```sql
start slave;
```

1.10 查看从服务器状态

```text
show slave status\G;
```

1.11 下面两个参数都是Yes，则说明主从配置成功！
```sql
 Slave_IO_Running: Yes
 Slave_SQL_Running: Yes

```

1.12 主机新建库、新建表、insert记录，从机复制

1.13 如何停止从服务复制功能

```sql
stop slave;
```

1.14 如何重新配置主从

```sql
stop slave;
reset master;
```

2、 修改 Mycat 的配置文件 schema.xml
之前的配置已分配了读写主机，是否已实现读写分离？
验证读写分离
（1）在写主机插入：insert into mytbl values (1,@@hostname);
主从主机数据不一致了
（2）在Mycat里查询：select * from mytbl;

修改<dataHost>的balance属性，通过此属性配置读写分离的类型
负载均衡类型，目前的取值有4 种：
（1）balance="0", 不开启读写分离机制，所有读操作都发送到当前可用的 writeHost 上。
（2）balance="1"，全部的 readHost 与 stand by writeHost 参与 select 语句的负载均衡，简单的说，当双主双从
模式(M1->S1，M2->S2，并且 M1 与 M2 互为主备)，正常情况下，M2,S1,S2 都参与 select 语句的负载均衡。
（3）balance="2"，所有读操作都随机的在 writeHost、readhost 上分发。
（4）balance="3"，所有读请求随机的分发到 readhost 执行，writerHost 不负担读压力

为了能看到读写分离的效果，把balance设置成2，会在两个主机间切换查询
…
<dataHost name="host1" maxCon="1000" minCon="10" balance="2"
writeType="0" dbType="mysql" dbDriver="native" switchType="1" 
slaveThreshold="100">
…

3、 启动 Mycat
（1）在写主机数据库表mytbl中插入带系统变量数据，造成主从数据不一致
INSERT INTO mytbl VALUES(2,@@hostname);
（2）在Mycat里查询mytbl表,可以看到查询语句在主从两个主机间切换

### 3.2 搭建双主双从

## 四、垂直拆分 -- 分库
### 4.1 如何划分表
### 4.2 实现分库

## 五、水平拆分 -- 分表
### 5.1 实现分表