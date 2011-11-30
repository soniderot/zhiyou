package com.zy.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.collections.primitives.RandomAccessLongList;

public class LongDataList extends RandomAccessLongList implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 3257847662509308214L;

  public final static LongDataList EMPTY_LIST = new LongDataList(
      new LongDataListAccessor() {
        public long get(int index) {
          throw new IndexOutOfBoundsException("List is empty");
        }

        public int size() {
          return 0;
        }
      });

  private LongDataListAccessor _accessor;

  /**
   * Constructs a list with an Accessor.
   */
  public LongDataList(LongDataListAccessor accessor) {
    _accessor = accessor;
  }

  /**
   * Constructs a list with a SimpleAccessor.
   */
  // public LongDataList(LongList list)
  // {
  // this(new SimpleAccessor(list));
  // }
  /**
   * Constructs a list with a SimpleAccessor.
   */
  // public LongDataList(long list[])
  // {
  // this(new SimpleAccessor(list));
  // }
  /**
   * Returns the number of elements in this list.
   * 
   * @return the number of elements in this list.
   */
  public int size() {
    return _accessor.size();
  }

  /**
   * Returns the element at the specified position in this list.
   * 
   * @param index
   *          index of element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException
   *           if index is out of range <tt>(index
   * 		  &lt; 0 || index &gt;= size())</tt>.
   */
  public long get(int index) {
    return _accessor.get(index);
  }

  /*
   * private static class SimpleAccessor implements LongDataListAccessor {
   * private LongList list;
   * 
   * SimpleAccessor(LongList list) { this.list = new ArrayLongList(list); }
   * 
   * SimpleAccessor(long array[]) { this.list = new ArrayLongList(); for (int i =
   * 0; i < array.length; i++) { this.list.add(array[i]); } }
   * 
   * public int size() { return list.size(); }
   * 
   * public long get(int index) { return list.get(index); } }
   */

  public static void main(String[] args) {
    try {
      LongDataList list = new SimpleLongDataList(10);
      for (int i = 0; i < 10; i++) {
        list.add(1000L + i);
      }

      for (int i = 0; i < list.size(); i++) {
        System.out.print(" " + list.get(i));
      }
    

      // IOUtils.

      byte buffer[] = null;
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(list);
      buffer = bos.toByteArray();

      ByteArrayInputStream bin = new ByteArrayInputStream(buffer);
      ObjectInputStream ois = new ObjectInputStream(bin);
      LongDataList list2 = (LongDataList) ois.readObject();

      for (int i = 0; i < list2.size(); i++) {
        System.out.print(" " + list2.get(i));
      }
     

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}