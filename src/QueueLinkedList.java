import java.util.NoSuchElementException;


public class QueueLinkedList <Integer>{


    private class Node<Integer>{
        private Integer data;
        private Node  next;

    }

    private int n;
    private Node<Integer> first;
    private Node<Integer> last;


    public QueueLinkedList(){
        first = null;
        last = null;
        n = 0;

    }

    public int size(){ return n;}


    public boolean isEmpty(){return first == null;}

    public Integer peek(){
        if (isEmpty())throw new NoSuchElementException("Queue is empty");
        return first.data;
    }


    public void adToQueue(Integer d){
        Node oldlast = last;
        last = new Node<>();
        last.data = d;
        last.next = null;
        if (isEmpty()) { first = last;}
        else { oldlast.next = last;}
        n++;

    }

    public Integer takeFromQueue(){
        if (isEmpty())throw new NoSuchElementException("Queue is empty");
        Integer d = first.data;
        first = first.next;
        n--;
        return d;

    }




}

