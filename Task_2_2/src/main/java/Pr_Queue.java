import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Pr_Queue<Key extends Comparable<Key>, Val> implements Iterable<Val> {
    private int modCount = 0;
    private Node<Key, Val>[] arr;
    private int sz, cur;

    private static class Node<Key extends Comparable<Key>, Val> {
        public final Key key;
        public final Val value;

        Node(Key key, Val value) {
            this.value = value;
            this.key = key;
        }

    }

    @SuppressWarnings("unchecked")
    Pr_Queue() {
        arr =  new Node[10];
        cur = 0;
        sz = 10;
    }

    public Val extract_Minimum() {
        modCount++;
        if(cur == 0)
            throw new NoSuchElementException();
        Node<Key, Val> min = arr[0];
        arr[0] = arr[--cur];
        siftDown(0);
        return min.value;
    }

    public void insert(Key K, Val V) {
        modCount++;
        if(cur == sz){
            arr = Arrays.copyOf(arr, sz * 2);
            sz *= 2;
        }
        Node<Key, Val> inc = new Node<>(K, V);
        arr[cur] = inc;
        cur++;
        siftUp(cur - 1);
    }

    private void swap(int a, int b){
        Node<Key, Val> buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }

    private void siftDown(int nod){
        int min = nod;
        int l = nod * 2 + 1;
        int r = nod * 2 + 2;
        if (l < cur && arr[min].key.compareTo(arr[l].key) > 0) {
            min = l;
        }
        if (r < cur && arr[min].key.compareTo(arr[r].key) > 0) {
            min = r;
        }
        if (min != nod) {
            swap(min, nod);
            siftDown(min);
        }
    }

    private void siftUp(int idx) {
        int par = (idx - 1) / 2;
        while (arr[idx].key.compareTo(arr[par].key) < 0 && idx > 0) {
            swap(idx, par);
            idx = par;
            par = (idx - 1) / 2;
        }
    }

    @Override
    public Iterator<Val> iterator() {
        Iterator<Val> it = new Iterator<Val>() {
            private final int expectedModCount = modCount;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return currentIndex < cur;
            }

            @Override
            public Val next() {

                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return arr[currentIndex++].value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }


    public Stream<Val> stream() {
        return StreamSupport.stream(new Pr_QueueSpliterator(), false);
    }

    public class Pr_QueueSpliterator implements Spliterator<Val> {
        private int firstPosition;
        private final int lastPosition;

        //первичный конструктор сплитератора
        public Pr_QueueSpliterator() {
            firstPosition = -1;
            lastPosition = cur - 1;
        }

        //внутренний конструктор сплитератора
        public Pr_QueueSpliterator(int f, int l) {
            firstPosition = f;
            lastPosition = l;
        }

        //проверяем есть ли следующий элемент и если есть, переходим к нему
        @Override
        public boolean tryAdvance(Consumer<? super Val> action) {
            if (firstPosition <= lastPosition) {
                firstPosition++;
                action.accept(arr[firstPosition].value);
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(Consumer<? super Val> action) {
            for (;firstPosition <= lastPosition; firstPosition++) {
                action.accept(arr[firstPosition].value);
            }
        }

        //пытаемся разбить контейнер на 2 части и иттерироваться по ним параллельно
        @Override
        public Spliterator<Val> trySplit() {
            int half = (lastPosition - firstPosition) / 2;
            if (half<=1) {
                //Not enough data to split
                return null;
            }
            int f = firstPosition;
            int l = firstPosition + half;

            firstPosition = firstPosition + half +1;

            return new Pr_QueueSpliterator(f, l);
        }

        //узнать диапазон итерирования
        @Override
        public long estimateSize() {
            return lastPosition - firstPosition;
        }

        @Override
        public long getExactSizeIfKnown() {
            return estimateSize();
        }

        @Override
        public int characteristics() {
            return IMMUTABLE | SIZED | SUBSIZED;
        }
    }
}