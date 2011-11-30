package com.zy.domain.sns.service;

import cern.colt.list.ObjectArrayList;

public interface Graph
{
  public final static String PROPS_LOAD_WAIT = "graph.initDelay";
  public final static String PROPS_MAX_DEPTH = "graph.networkDepth";

  public static final int DEFAULT_INIT_DELAY = 1000;
  public static final int DEFAULT_FRIENDS_CAPACITY = 32;
  public static final short DEFAULT_MAX_DEPTH = 2;

  public void addNode(GraphNode node);

  public void addNode(GraphNode node, boolean replace);

  public void deleteNode(GraphNode node);

  public void deleteNode(long key);

  public void addEdge(GraphNode node1, GraphNode node2);

  public void addEdge(long key1, long key2);

  public void deleteEdge(GraphNode node1, GraphNode node2);

  public void deleteEdge(long key1, long key2);

  public GraphNode findNode(long key);

  public GraphNetwork getNetwork(GraphNode node, int depth);

  public GraphNetwork getNetwork(long key, int depth);

  public ObjectArrayList nodes();

  public int size();

  public void trimToSize();
  
  public Graph loadObject();
  

  public static final Graph EMPTY_GRAPH =
      new Graph()
  {
	  public Graph loadObject(){
		  throw new UnsupportedOperationException("Not supported");
	  }
	
    public void addNode(GraphNode node)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void addNode(GraphNode node, boolean replace)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void deleteNode(GraphNode node)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void deleteNode(long key)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void addEdge(GraphNode node1, GraphNode node2)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void addEdge(long key1, long key2)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void deleteEdge(GraphNode node1, GraphNode node2)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public void deleteEdge(long key1, long key2)
    {
      throw new UnsupportedOperationException("Not supported");
    }

    public GraphNode findNode(long key)
    {
      return null;
    }

    public GraphNetwork getNetwork(GraphNode node, int depth)
    {
      return null;
    }

    public GraphNetwork getNetwork(long key, int depth)
    {
      return null;
    }

    public ObjectArrayList nodes()
    {
      return null;
    }

    public int size()
    {
      return 0;
    }

    public void trimToSize() {}

  };
}
