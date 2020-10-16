public class Task2_1_Stack {

Object arr[] = new Object[10];
int size = 10, cur = 0;

    public void Push(Object elem){
        if(cur == size){
            Object buf[] = new Object[size];

            System.arraycopy(arr, 0, buf, 0, size);

            arr = new Object[size*2];

            System.arraycopy(buf, 0, arr, 0, 3);

        }
        arr[cur] = elem;
        cur++;
        size++;

    }

    public Object Pop(){
        int y = cur;
        cur--;

        return arr[y];
    }

    public int Count(){

        return cur;
    }

}
