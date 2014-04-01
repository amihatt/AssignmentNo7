import java.util.Arrays;

//************************************************************************
// File: RingBuffer.java         Assignment 7
// 
// Author: <your name>           Email: <your email>
//
// Class: RingBuffer 
//
// Description  :  RingBuffer template
//  
//  Time spent on this problem: 3 hr 30 min
//	------------------------
//	This is a template file for RingBuffer.java. It lists the constructors 
//  and methods you need, along with descriptions of what they're supposed 
//  to do.
//  
//  Note: it won't compile until you fill in the constructors and methods
//        (or at least commment out the ones whose return type is non-void).
//
//************************************************************************

public class RingBuffer {
    private double[] rb;          // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
<<<<<<< HEAD
    private int size;             // number of items in buffer
=======
    private int size;             // number of items in the buffer
>>>>>>> FETCH_HEAD

    // create an empty buffer, with given max capacity
    public RingBuffer(int capacity) {
        rb = new double[capacity];
        first = 0;
        last = 0;
    }

    // return number of items currently in the buffer
    public int size() {
    	//System.out.println("size = " + size);
        return size;
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        if (size() == 0) {
        	return true;
        } else {
        	return false;
        }
    }

    // is the buffer full (size equals array capacity)?
    public boolean isFull() {
        if (size == rb.length) {
        	return true;
        } else {
        	return false;
        }
    }

    // add item x to the end
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else {
        	if (last == rb.length - 1) {
        		rb[last] = x;
        		last = 0;
        	} else {
        	rb[last] = x;
        	last++;
        	} 
        	size++;
        	//System.out.print(", " + last);
        }
    }

    // delete and return item from the front
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
        	double a = rb[first]; //changed to a to be more consistent with GuitarString
        	rb[first] = 0;
        	if (first == rb.length - 1) {
        		first = 0;
        	} else {
        		first++;
        	}
        	//System.out.printf("%n%.1f", a);
        	size--;
        	return a;
        }
    }

    // return (but do not delete) item from the front
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
        	double x = rb[first];
        	return x;
        }
    }
    
    public void print(int i) {
    	System.out.print(", " + rb[i]);
    }

    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) {
        RingBuffer test = new RingBuffer(10);
        for (int i = 1, j = 0; i <= 10; i++, j++) {
        	test.enqueue(i);
        	test.print(j);
        }
        double s = test.dequeue();
        System.out.println("size = " + test.size);
        
        
    	//int N = Integer.parseInt(args[0]);
    	int N = 10;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            System.out.println("size = " + buffer.size);
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }

}