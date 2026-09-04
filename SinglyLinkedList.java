public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
     
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(" ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public E removeLast(){

        if (isEmpty()){
            return null;
        }

        E answer = tail.getElement();

        if (size == 1){
            // only one element in the list
            head = null;
            tail = null;
        } else {
            // walk to the node just before the current tail
            Node<E> walk = head;
            while (walk.getNext() != tail){
                walk = walk.getNext();
            }
            walk.setNext(null);
            tail = walk;
        }

        size--;
        return answer;
    }

    public void reverse(){       

        Node<E> prev = null;
        Node<E> current = head;
        tail = head; 

        while (current != null){
            Node<E> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }           
}