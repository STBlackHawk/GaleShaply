import java.util.NoSuchElementException;
public class StacK<Object> {

    private static class Node<Object>{
        private Object data;
        private Node<Object> next;

    }


    private Node<Object> first;
    private int n;

    public StacK(){
        first = null;
        n = 0;

    }

    public int size(){
        return n;
    }


    public boolean isEmpty(){ return first == null; }



    public void push(Object data){
        Node <Object> oldfirst = first;
        first = new Node<Object>();
        first.data = data;
        first.next = oldfirst;
        n++;
    }

    public Object peek(){
        if (isEmpty())throw new NoSuchElementException("Stack is empty");
        return first.data;
    }

    public Object pop(){
        if (isEmpty())throw new NoSuchElementException("Stack is empty");
        else {
            Object data = first.data;
            first = first.next;
            n--;
            return data;
        }
    }




}




