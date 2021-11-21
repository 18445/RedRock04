import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterator<T> {
    private T data;
    private MyList<T> last;
    private MyList<T> next;
    private MyList<T> head;
    private static int length;
    private int position;

    public MyList(){

    }
    {
        length++;
        position = 0;
    }

    public Object getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public MyList<T> getLast() {
        return last;
    }
    public void setLast(MyList<T> last) {
        this.last = last;
    }
    public MyList<T> getNext() {
        return next;
    }
    public void setNext(MyList<T> next) {
        this.next = next;
    }

    public void addNode(T data){
        MyList<T> newNode = new MyList<T>();
        newNode.data = data;
        if(head == null){
            head = newNode;
        }else {//新的节点在原节点头的后面，并将新节点赋值为节点头
            head.next = newNode;
            newNode.last = head;
            head = newNode;
        }
    }

    public void show(){
        MyList<T> list = head;
        while(list != null){//倒序遍历
            System.out.println(list.data);
            list = list.last;
        }
    }

    public void add(T data,int index){
        if(index <0||index>length){
            throw new NoSuchElementException("位置非法越界");
        }
        if(index == 0){
            addNode(data);
            return;
        }
        MyList<T> newNode = new MyList<T>();
        MyList<T> current = head;
        int point = 0;
        while(point != index){
            point ++;
            current = current.last;
        }
        current.next.last = newNode;
        current.next = next;
        newNode.last =current;
        newNode.next =current.next;
    }

    public void remove(int index){
        if(index <0||index>length){
            throw new NoSuchElementException("位置非法越界");
        }
        if(index == 0){
            head = head.last;
            head.next = null;
            return;
        }
        int point = 0;
        MyList<T> current = head;
        while(point != index){
            point ++;
            current = current.last;
        }
        current.last.next = current.next;
        current.next.last = current.last;
    }

    public void change(T data,int index){
        if(index <0||index>length){
            throw new NoSuchElementException("位置非法越界");
        }
        int point = 0;
        MyList<T> current = head;
        while(point != index){
            point ++;
            current = current.last;
        }
        current.data = data;
    }

    public T search(int index){
        if(index <0||index>length){
            throw new NoSuchElementException("位置非法越界");
        }
        int point = 0;
        MyList<T> current = head;
        while(point != index){
            point ++;
            current = current.last;
        }
        return data;
    }


    @Override
    public boolean hasNext() {
        return (position < length);
    }

    @Override
    public T next() {
        if(hasNext()){
            position++;
            return search(position-1);
        }else{
            throw new NoSuchElementException("没有该元素");
        }
    }
}
