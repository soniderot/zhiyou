package com.zy.domain.sns.service;

import java.io.Serializable;
import java.util.List;


import com.zy.common.model.ZyProfile;
import com.zy.common.util.LongDataListAccessor;
import com.zy.common.util.SimpleLongDataList;
import com.zy.common.exception.GraphIsInitializingException;

public class UserNetwork
    extends GraphNetwork
    implements Serializable
{
  private long _userId;
  private static final long serialVersionUID = 1615610626692331538L;
  private Graph graph;  
  
  public Graph getGraph() {
	return graph;
}

public void setGraph(Graph graph) {
	this.graph = graph;
}

public UserNetwork(long userId, Graph graph, int depth) throws GraphIsInitializingException
  {
    super(graph.findNode(userId), depth);
    _userId = userId;
  }

  public UserNetwork(long userId, int depth) throws GraphIsInitializingException
  {
    this(userId, GraphSingleton.getInstance().getGraph(), depth);
  }
  
  public UserNetwork(long userId) throws GraphIsInitializingException
  {
    this(userId, GraphSingleton.getInstance().getGraph(),Graph.DEFAULT_MAX_DEPTH);
  }

  public long getUserId(){
	    return _userId;
  }

  public LongDataListAccessor nodesSortedByDistance()
  {
    ColtLongListAccessor keys =
        new ColtLongListAccessor(keysSortedByDistance());
    return keys;
  }

  public LongDataListAccessor nodesSortedByDate()
  {
    ColtLongListAccessor keys =
        new ColtLongListAccessor(keysSortedByDate());
    return keys;
  }
  
  public LongDataListAccessor nodesByDegree(short degree)
  {
    ColtLongListAccessor keys =
        new ColtLongListAccessor(keysByDegree(degree));
    return keys;
  }
  
  public int getDegreeGenderNodeCount (short degree,short gender)
  {
    return keysByDegreeGender(degree,gender).size();
  }
  

  public int getTotalNeibours()
  {
    return getNeibours().size();
  }


  public Connections getConnections(long targetId) throws GraphIsInitializingException
  {
    return new Connections(this, findNode(targetId));
  }

  public List<Integer> getFriendsByDegree(short degree) {
	    try{  
	         LongDataListAccessor ldal = nodesByDegree(degree);
	         java.util.ArrayList<Integer> results = new java.util.ArrayList<Integer>();
	         for (int i=0; i < ldal.size();i++)
	             results.add((int)ldal.get(i));
	         return results;
	    }
	    catch(Exception e ) {
	        return new java.util.ArrayList<Integer>();
	    }
	 }
}
