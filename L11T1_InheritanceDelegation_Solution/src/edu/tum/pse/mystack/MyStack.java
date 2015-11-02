package edu.tum.pse.mystack;

import java.util.Arrays;
import java.util.Vector;

public class MyStack<T> {

	private Vector _vector = new Vector();
	
    public <T> void push(T element) {
        _vector.insertElementAt(element,_vector.size());
    }
    
    public T pop() {
        T result = (T) _vector.get(_vector.size() - 1);
        _vector.removeElementAt(_vector.size() - 1);
        return result;
    }

	public int size() {
		return _vector.size();
	}
	
	public boolean isEmpty() {
		return _vector.isEmpty();
	}
	
	public void display() {
		System.out.println(Arrays.deepToString(_vector.toArray()));
	}
    
    public static void main(String argv[]) {
    	MyStack<String> stack = new MyStack<String>();
    	
    	stack.push(new String("first"));
    	stack.push(new String("second"));
    	stack.push(new String("third"));
    	
    	stack.display();
    	
    	System.out.println(stack.pop());
    	stack.display();
    	System.out.println(stack.pop());
    	stack.display();
    	System.out.println(stack.pop());
    	stack.display();
    }
        
    
}