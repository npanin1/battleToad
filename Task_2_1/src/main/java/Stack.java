import java.util.*;

public class Stack<Type> implements Iterable<Type> {
    private int modCount = 0;
    private Type[] arr;
    private int cur;
    private int sz;

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {
            private final int expectedModCount = modCount;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return currentIndex < cur && arr[currentIndex] != null;
            }

            @Override
            public Type next() {

                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return arr[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @SuppressWarnings("unchecked")
    Stack() {
        arr = (Type[]) new Object[10];
        cur = 0;
        sz = 10;
    }

    public Type pop() {
        modCount++;
        if (cur == 0)
            throw new NoSuchElementException("Stack is empty");
        return arr[--cur];
    }

    public void push(Type inp) {
        modCount++;
        if (cur == sz) {
            arr = Arrays.copyOf(arr, sz * 2);
            sz *= 2;
        }
        arr[cur++] = inp;
    }

    public int count() {
        return cur;
    }

}
