package com.zhou.single;

//懒汉式单例
public class LazyMan {
    private LazyMan(){

    }


//    private static LazyMan LAZYMAN = null;

    //不考虑线程安全的单例模式
//    public static LazyMan getInstance(){
//        if (LAZYMAN == null)
//            LAZYMAN = new LazyMan();
//        return LAZYMAN;
//    }

    //考虑线程安全方式 1 ：在getInstance方法上加同步
//    public static synchronized LazyMan getInstance(){
//        if (LAZYMAN == null)
//            LAZYMAN = new LazyMan();
//        return LAZYMAN;
//    }

    //考虑线程安全方式 2 ：双重检查锁定
//    public static synchronized LazyMan getInstance(){
//        if (LAZYMAN == null){
//            synchronized (LazyMan.class){
//                if (LAZYMAN == null)
//                    LAZYMAN = new LazyMan();
//            }
//        }
//        return LAZYMAN;
//    }

    //考虑线程安全方式 3 ：静态内部类
    private static class LazyHolder{
        private static final LazyMan LAZYMAN = new LazyMan();
    }

    public static  LazyMan getInstance(){
        return LazyHolder.LAZYMAN;
    }
}








