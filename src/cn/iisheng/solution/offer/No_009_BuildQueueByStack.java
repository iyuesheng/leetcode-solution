package cn.iisheng.solution.offer;

import java.util.LinkedList;

/**
 * @author iisheng
 * @date 2022/08/06 10:33:58
 */
public class No_009_BuildQueueByStack {
    
    class CQueue {
        LinkedList<Integer> A, B;
        
        // 实现一个队列 先进先出
        // 使用两个栈 后进先出
        public CQueue() {
            A = new LinkedList<>();
            B = new LinkedList<>();
        }
        
        public void appendTail(int value) {
            A.addLast(value);
        }
        
        public int deleteHead() {
            if (!B.isEmpty()) {
                return B.removeLast();
            }
            if (A.isEmpty()) {
                return -1;
            }
            while (!A.isEmpty()) {
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
    }
    
    public static void main(String[] args) {
//        CQueue obj = new CQueue();
//        obj.appendTail(value);
//        int param_2 = obj.deleteHead();
    }
}
