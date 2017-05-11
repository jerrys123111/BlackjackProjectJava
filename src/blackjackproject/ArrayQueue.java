package blackjackproject;



public class ArrayQueue<E> implements Queue<E>{
    private static final int CAPACITY = 100;
    private E[] data;
    private int f =0;
    private int counter =0;
    
    public ArrayQueue()
    {
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity)
    {
        data = (E[]) new Object[capacity];
    }
    
    public int size()
    {
        return counter;
    }
    public boolean isEmpty()
    {
        return (this.size() == 0);
    }
    
    public void enqueue(E e) throws IllegalStateException
    {
        if (size() == data.length)
            throw new IllegalStateException("Queue is full");
        
        int index = (f + counter) % data.length;
        data[index] = e;
        counter++;
    }
    
    public E first()
    {
        if(isEmpty())
            return null;
        return data[f];
    }
    
    public E dequeue()
    {
        if(isEmpty())
            return null;
        E result = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        counter--;
        return result;
    }
}
