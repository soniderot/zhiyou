package com.zy.domain.sns.service;

import java.util.Comparator;
import java.util.Date;

import cern.colt.list.LongArrayList;
import cern.colt.list.ObjectArrayList;

public interface Node
{
  public long getKey();
  
  public short getDistance(); 

  public short getPhotos();
  public short getGender();
  public short getCountry();

  public Date getCreated();

  public LongArrayList adjacentKeys();

  public ObjectArrayList adjacentNodes();

  static class PhotosComparator
      implements Comparator,java.io.Serializable
  {
    public int compare(Object o1, Object o2)
    {
      short photos1 = ((Node) o1).getPhotos();
      short photos2 = ((Node) o2).getPhotos();
      return (photos1<photos2 ? -1 : (photos1==photos2 ? 0 : 1));
    }

    public boolean equals(Object obj)
    {
      if (this == obj) { // quick check
        return true;
      }
      if (!(obj instanceof PhotosComparator)) { // (1) same object?
        return false;
      }
      PhotosComparator other = (PhotosComparator) obj;
      return true;
    }
  }

  static class DateComparator
      implements Comparator
  {
    public int compare(Object o1, Object o2)
    {
      Date date1 = ((Node) o1).getCreated();
      Date date2 = ((Node) o2).getCreated();
      return date1.compareTo(date2);
    }

    public boolean equals(Object obj)
    {
      if (this == obj) { // quick check
        return true;
      }
      if (!(obj instanceof DateComparator)) { // (1) same object?
        return false;
      }
      DateComparator other = (DateComparator) obj;
      return true;
    }
  }
}