package com.zy.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.collections.list.TreeList;


/**
 * A generic queue.
 * 
 * Note that this implementation is not synchronized. If multiple threads access
 * a queue concurrently, and at least one of the threads modifies the queue
 * structurally, it must be synchronized externally. (A structural modification
 * is any operation that enqueue(Object)s or dequeue()s one or more elements;
 * merely peek()ing the value of an element is not a structural modification.)
 * This is typically accomplished by synchronizing on some object that naturally
 * encapsulates the queue.
 */
public class Queue {
  /**
   * The List that backs this queue.
   */
  private List _queue;

  /**
   * Create the queues underlying TreeList
   */
  public Queue() {
    this(new TreeList());
  }

  protected Queue(List queue) {
    _queue = queue;
  }

  /**
   * Enqueue (add) the given Object to the queue.
   * 
   * @param object
   *          the Object to be added to the end of the queue
   * @return the given Object
   */
  public Object enqueue(Object object) {
    // Add to end of queue
    _queue.add(object);
    return object;
  }

  /**
   * Dequeue (remove) the Object that is first in the queue.
   * 
   * @throws NoSuchElementException
   *           if there are no more Objects in the queue to return
   * @return the first Object #enqueue(Object)'ed in the queue
   */
  public Object dequeue() throws NoSuchElementException {
    // Get head of queue
    return _queue.remove(0);
  }

  /**
   * Peek at the indexed Object added to the queue. The peek occurs in queue
   * order -- that is, peek(0) is the same as peek() which is the first element
   * enqueued in the queue. The queue is left unchanged. The index is
   * zero-based.
   * 
   * @param index
   *          the index of the element in the queue
   * @throws NoSuchElementException
   *           if there is no Object in the queue to return
   * @return the index'th Object enqueue(Object)'ed in the queue
   * 
   */
  public Object peek(int index) throws NoSuchElementException {
    return _queue.get(index);
  }

  /**
   * Retrieve the number of Objects in this queue.
   * 
   * @return the number of Objects
   */
  public int size() {
    return _queue.size();
  }

  /**
   * Returns <tt>true</tt> if this queue contains no elements.
   * 
   * @return <tt>true</tt> if this queue contains no elements.
   */
  public boolean isEmpty() {
    return _queue.isEmpty();
  }

  /**
   * Retrieve an immutable Iterator over all Objects in the queue in proper
   * (queue) order. The Queue will remain unchanged as a result of this
   * operation -- that is, the elements are not dequeue()'ed. Concurrent
   * modifications of the Queue and Iterator are not supported. Undefined
   * results will occur.
   * 
   * @return an Iterator over the elements in this queue in proper (queue) order
   */
  public Iterator iterator() {
    return IteratorUtils.unmodifiableIterator(_queue.iterator());
  }

  /**
   * Retrieve an immutable Iterator over all Objects in the queue in proper
   * (queue) order. Each element will be dequeue()d as it is returned. If the
   * iterated until Iterator.hasNext() returns false then the Queue will be
   * empty. Concurrent modifications of the Queue and Iterator are not
   * supported. Undefined results will occur.
   * 
   * @return an Iterator over the elements in this queue in proper (queue) order
   *         that will dequeue as it retrieves values
   */
  public Iterator dequeueIterator() {
    throw new UnsupportedOperationException("dequeueIterator() not implemented");
  }
}