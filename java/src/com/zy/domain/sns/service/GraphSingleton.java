package com.zy.domain.sns.service;

import com.zy.common.exception.GraphIsInitializingException;
import com.zy.domain.sns.dao.GraphDao;
public class GraphSingleton {
	/**
	   * Singleton access point to the manager.
	   */
	  private static final GraphSingleton _singleton = new GraphSingleton();
	  private static boolean _isinit = false; 
	  private short _networkDepth = Graph.DEFAULT_MAX_DEPTH;
	  private Graph _graph = Graph.EMPTY_GRAPH;

	  private GraphSingleton()
	  {
	  }
	  
	  private void init(){
	      try{
	      System.out.println("GraphSingleton.init()"); 
	      GraphDao graphDao = new GraphDao();
	      Graph graph = graphDao.loadObject();
	      _singleton.setGraph(graph);
	      } catch (Exception ex ) {
	          ex.printStackTrace();
	      }
	  }
	          

	  public static GraphSingleton getInstance() 
	  throws GraphIsInitializingException
	  {
	    if (_isinit)
	        throw new GraphIsInitializingException(); 
	    if (_singleton.getGraph().size()==0){
	        _isinit = true; 
	       _singleton.init();
	       _isinit = false; 
	    }
	    return _singleton;
	  }

	  public final short getNetworkDepth()
	  {
	    return _networkDepth;
	  }

	  final void setNetworkDepth(short networkDepth)
	  {
	    _networkDepth = networkDepth;
	  }

	  public final Graph getGraph()
	  {
	    return _graph;
	  }

	  final void setGraph(Graph graph)
	  {
	    _graph = graph;
	  }

	  public static void main(String[] args) throws Exception{
	      long size = GraphSingleton.getInstance().getGraph().size();
	      System.out.println(size);
	      
	      long size1 = GraphSingleton.getInstance().getGraph().size();
	      System.out.println(size1);
	  }
}
