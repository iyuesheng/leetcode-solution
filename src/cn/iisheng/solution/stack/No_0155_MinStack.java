package cn.iisheng.solution.stack;

/**
 * @author iisheng
 * @date 2022/01/06 22:09:03
 */
public class No_0155_MinStack {
    
    class MinStack {

        public class Element {
            public int val;
            public int min;

            Element next;

            public Element(int val, int min) {
                this.val = val;
                this.min = min;
            }

        }

        Element top = null;

        public MinStack() {
            // 初始化
        }

        public void push(int val) {
            if (top == null) {
                top = new Element(val, val);
            } else {
                Element e = new Element(val, Math.min(top.min, val));
                e.next = top;
                top = e;
            }
        }

        public void pop() {
            if (top == null) {
                return;
            } else {
                Element tmp = top.next;
                top = tmp;
            }
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
        }
    }

}
