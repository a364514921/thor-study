package org.thor.javademo.设计模式新.d2_代理模式;

/**
 * @Description:定义一个西门庆，这人色中饿鬼
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:16
 * @Version: V1.0
 */
public class XiMenQing {
    /**
     * 水浒里是这样写的:西门庆被潘金莲用竹竿敲了一下难道，痴迷了，
     * 被王婆看到了,就开始撮合两人好事，王婆作为潘金莲的代理人
     * 收了不少好处费，那我们假设一下:
     * 如果没有王婆在中间牵线，这两个不要脸的能成吗?难说的很!
     */
    public static void main(String[] args) {
        // 把王婆叫出来
//        WangPo wangPo = new WangPo();

        /*
        然后西门庆就说，我要和潘金莲happy，然后王婆就安排了西门庆丢筷子的那出戏:
        看到没，虽然表面上时王婆在做，实际上爽的是潘金莲
         */
//        wangPo.makeEyesWithMan();
//        wangPo.happyWithMan();

        //改编一下历史，贾氏被西门庆勾走:
        JiaShi jiaShi = new JiaShi();
        WangPo wangPo = new WangPo(jiaShi); //让王婆作为贾氏的代理人
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();

    }
}
