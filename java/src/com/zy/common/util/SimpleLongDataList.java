package com.zy.common.util;

import java.io.Serializable;

import org.apache.commons.collections.primitives.ArrayIntList;
import org.apache.commons.collections.primitives.ArrayLongList;
import org.apache.commons.lang.math.RandomUtils;

public final class SimpleLongDataList extends LongDataList implements Cloneable {
  /**
   * 
   */
  private static final long serialVersionUID = 3763098582911627825L;

  private ArrayLongList _list;

  public SimpleLongDataList(ArrayLongList list) {
    super(new SimpleAccessor(list));
    _list = list;
  }

  public SimpleLongDataList(int initialCapacity) {
    this(new ArrayLongList(initialCapacity));
  }

  public long removeElementAt(int index) {
    return _list.removeElementAt(index);
  }

  public long set(int index, long element) {
    return _list.set(index, element);
  }

  public void add(int index, long element) {
    _list.add(index, element);
  }

  public void trimToSize() {
    _list.trimToSize();
  }

  public Object clone() {
    return copy();
  }

  public SimpleLongDataList copy() {
    return new SimpleLongDataList(new ArrayLongList(_list));
  }

  private static class SimpleAccessor implements LongDataListAccessor,
      Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3258689901368457013L;

    private ArrayLongList _list;

    SimpleAccessor(ArrayLongList list) {
      _list = list;
    }

    public int size() {
      return _list.size();
    }

    public long get(int index) {
      return _list.get(index);
    }

  }

  public static SimpleLongDataList capedList(LongDataList list, int maxSize) {
    if (list == null || list.isEmpty()) {
      return null;
    }

    final int length = Math.min(list.size(), maxSize);
    final ArrayIntList indexes = new ArrayIntList(length);
    for (int i = 0; i < length;) {
      int rindex = RandomUtils.nextInt(list.size());
      if (indexes.contains(rindex))
        continue;
      indexes.add(rindex);
      i++;
    }

    SimpleLongDataList result = new SimpleLongDataList(length);
    for (int i = 0; i < length; i++) {
      result.add(list.get(indexes.get(i)));
    }

    return result;
  }

}
