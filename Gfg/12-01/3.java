import java.util.*;

class SpecialStack
{

    private Stack<Integer> stack, minStack, maxStack;

    SpecialStack() {
        stack = minStack = maxStack = new Stack<>();
    }

    public void push(int x) {
        
        stack.push(x);

        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
        
        if (maxStack.isEmpty() || x >= maxStack.peek()) maxStack.push(x);

    }

    public void pop() {
        
        if (!stack.isEmpty()) {

            int popped = stack.pop();

            if (popped == minStack.peek()) minStack.pop();
            
            if (popped == maxStack.peek()) maxStack.pop();
            
        }
    }
    
    public int getMax() {

        return maxStack.isEmpty() ? -1 : maxStack.peek();
    
    }
    
    public int getMin() {
        
        return minStack.isEmpty() ? -1 : minStack.peek();
    
    }
}
