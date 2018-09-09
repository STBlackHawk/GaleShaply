import java.util.NoSuchElementException;


public class QueueLinkedList <Object>{


    private class Node<Object>{
        private Object data;
        private Node  next;

    }

    private int n;
    private Node<Object> first;
    private Node<Object> last;


    public QueueLinkedList(){
        first = null;
        last = null;
        n = 0;

    }

    public int size(){ return n;}


    public boolean isEmpty(){return first == null;}

    public Object peek(){
        if (isEmpty())throw new NoSuchElementException("Queue is empty");
        return first.data;
    }


    public void adToQueue(Object d){
        Node oldlast = last;
        last = new Node<>();
        last.data = d;
        last.next = null;
        if (isEmpty()) { first = last;}
        else { oldlast.next = last;}
        n++;

    }

    public Object takeFromQueue(){
        if (isEmpty())throw new NoSuchElementException("Queue is empty");
        Object d = first.data;
        first = first.next;
        n--;
        return d;

    }




}

