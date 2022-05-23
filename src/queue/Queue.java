package queue;

public interface Queue<E> {
    public void offer(E val);

    public E peek();

    public E poll();

    public boolean isEmpty();
}
