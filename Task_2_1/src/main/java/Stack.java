import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Type> implements Iterable<Type> , Iterator<Type>{
    private Type arr[];
    private int cur;
    private int sz;

    @SuppressWarnings("unchecked")
    Stack() {
        arr = (Type[])new Object[10];
        cur = 0;
        sz = 10;
    }

    public Type pop() {
        if(cur == 0)
            throw new NoSuchElementException("Stack is empty");
        return arr[--cur];
    }

    public void push(Type inp){
        if(cur == sz){
            arr = Arrays.copyOf(arr, sz * 2);
            sz *= 2;
        }
        arr[cur++] = inp;
    }

    public int count(){
        return cur;
    }

    @Override
    public Iterator<Type> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return cur > 0;
    }

    @Override
    public Type next() {
        if(!hasNext()){
            throw new NoSuchElementException("Stack is empty");
        }
        return pop();
    }
}
