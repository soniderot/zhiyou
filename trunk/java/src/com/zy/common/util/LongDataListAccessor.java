package com.zy.common.util;

public interface LongDataListAccessor {
	  /**
	   * Returns the number of elements in this list.
	   * 
	   * @return the number of elements in this list.
	   */
	  public int size();

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
	  public long get(int index);

	}
