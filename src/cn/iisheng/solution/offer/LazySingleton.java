package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/10/13 11:02:59
 */
public class LazySingleton {
    
    private static volatile LazySingleton singleton = null;
    
    // 限制产生多个对象
    private LazySingleton() {
    
    }

//    // 通过该方法获取实例对象
//    public static synchronized LazySingleton getSingleton() {
//        if (singleton == null) {
//            singleton = new LazySingleton();
//        }
//        return singleton;
//    }
    
    // 通过该方法获取实例对象
    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
