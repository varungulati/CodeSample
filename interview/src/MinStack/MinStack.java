package MinStack;

import java.util.Stack;

class MinStack {

    Stack<Integer> regular;
    Stack<Integer> minSt;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.regular  = new Stack<>();
        this.minSt = new Stack<>();
    }
    
    public void push(int x) {
        this.regular.push(x);
        if(this.minSt.size() == 0 || this.minSt.peek() >= x) {
            this.minSt.push(x);
        }
    }
    
    public void pop() {
        if(this.regular.size() > 0) {
            if(this.regular.peek().equals(this.minSt.peek())) {
                this.minSt.pop();
            }
            this.regular.pop();
        }
    }
    
    public int top() {
        return this.regular.size() > 0 ? this.regular.peek() : 0;
    }
    
    public int getMin() {
        return this.minSt.size() > 0 ? this.minSt.peek() : 0;
    }
    
    public static void main(String args[]) {
 
    	 //Your MinStack object will be instantiated and called as such:
    	 MinStack obj = new MinStack();
    	  obj.push(512);
    	  obj.push(-1024);
    	  obj.push(-1024);
    	  obj.push(512);
    	  obj.pop();
    	  System.out.println(obj.getMin());
    	  obj.pop();
    	  System.out.println(obj.getMin());
    	  obj.pop();
    	  System.out.println(obj.getMin());
    }
}