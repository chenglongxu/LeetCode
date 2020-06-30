import java.util.Stack;

public class LeetCode9 {

    class CQueue {

        Stack<Integer> ASC;
        Stack<Integer> DESC;

        public CQueue() {
            ASC = new Stack<>();
            DESC = new Stack<>();
        }

        public void appendTail(int value) {
            if (DESC.empty()) {
                change();
            }
            ASC.push(value);
        }

        private void change() {
            if (ASC.empty()) {
                while (!DESC.empty()) {
                    ASC.push(DESC.pop());
                }
            } else {
                while (!ASC.empty()) {
                    DESC.push(ASC.pop());
                }
            }
        }

        public int deleteHead() {
            if (ASC.empty() && DESC.empty()) {
                return -1;
            } else {
                if (DESC.empty()) {
                    change();
                }
                return DESC.pop();
            }
        }
    }

}
