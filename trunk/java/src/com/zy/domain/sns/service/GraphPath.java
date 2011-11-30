package com.zy.domain.sns.service;

import java.util.Date;

import cern.colt.list.LongArrayList;
import cern.colt.list.ObjectArrayList;

import com.zy.common.util.LongDataList;
import com.zy.common.util.SimpleLongDataList;
import com.zy.common.exception.GraphIsInitializingException;
     
public class GraphPath implements java.io.Serializable
{
  private SimpleLongDataList _nodes;

  public GraphPath(int maxDistance) throws GraphIsInitializingException
  {
    this(new SimpleLongDataList(maxDistance));
  }

  public GraphPath() throws GraphIsInitializingException
  {
    this((int)Graph.DEFAULT_MAX_DEPTH);
  }

  public GraphPath(SimpleLongDataList nodes) throws GraphIsInitializingException
  {
    if (nodes != null)
      _nodes = nodes;
    else
      _nodes =
          new SimpleLongDataList(3);
  }

  public LongDataList getNodes()
  {
    return _nodes;
  }

  public void add(long key)
  {
    _nodes.add(key);
  }

  public boolean contains(long key)
  {
    return _nodes.contains(key);
  }

  public int size()
  {
    return _nodes.size();
  }
  
  public void reverse(){
  SimpleLongDataList _newnodes = new SimpleLongDataList(_nodes.size());
  for(int i = _nodes.size()-1;i>=0;i--)
      _newnodes.add(_nodes.get(i));
  _nodes = _newnodes; 
}

  public int getLength()
  {
    return size();
  }
  
  
  public GraphPath copy() throws GraphIsInitializingException
  {
    GraphPath newPath =
        new GraphPath(_nodes.copy());
    return newPath;
  }


  
      public String toString() {
        return _nodes.toString();
    }
      
      
      
    static class PathNode
      implements Comparable, Node,java.io.Serializable
  {
    private Node _node;
    private short _distance;

    

    PathNode(Node node, short distance)
    {
      _node = node;
      _distance = distance;
    }
    
    

    PathNode(Node node, int depth)
    {
      this(node, (short)depth);
    }

    public long getKey()
    {
      return _node.getKey();
    }

    public short getPhotos()
    {
      return _node.getPhotos();
    }

    public Date getCreated()
    {
      return _node.getCreated();
    }

    public short getDistance()
    {
      return _distance;
    }
    
    public short getGender()
    {
      return _node.getGender();
    }
    
    public short getCountry()
    {
      return _node.getCountry();
    }

    public LongArrayList adjacentKeys()
    {
      return _node.adjacentKeys();
    }

    public ObjectArrayList adjacentNodes()
    {
      return _node.adjacentNodes();
    }


    

    public boolean equals(Object o)
    {
      if (this == o) { // quick check
        return true;
      }
      if (!(o instanceof PathNode)) { // (1) same object?
        return false;
      }
      PathNode other = (PathNode) o;
      if (_node.equals(other) || _distance != other._distance)
        return false;
      return true;
    }

    public int compareTo(Object o)
    {
      if (equals(o))
        return 0;
      if (_distance < ((PathNode) o)._distance)
        return -1;
      if (_distance > ((PathNode) o)._distance)
        return +1;
      if (getKey() < ((PathNode) o).getKey())
        return -1;
      if (getKey() > ((PathNode) o).getKey())
        return +1;

      return 0;
    }

  }
}
