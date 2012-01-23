package com.zy.domain.sns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cern.colt.list.ObjectArrayList;
import cern.colt.map.OpenLongObjectHashMap;

import com.zy.common.db.HibernateDao;
import com.zy.common.util.JDBCUtil;
import com.zy.domain.sns.service.Graph;
import com.zy.domain.sns.service.GraphNetwork;
import com.zy.domain.sns.service.GraphNode;

public class GraphDao extends HibernateDao implements Graph,java.io.Serializable{

	private final OpenLongObjectHashMap _nodes = new OpenLongObjectHashMap(1);
	private static  long serialVersionUID = 2140403704078250823L;
	
	private static  String SQL_NODE_COUNT = "select count(*) from  zy_profile profile inner join (select userid from zy_friend union select friendid from zy_friend) a on profile.userid = a.userid  ";
	private static  String SQL_NODE_LIST = "select zy_profile.userid,gender, countryid from  zy_profile inner join (select userid from zy_friend union select friendid from zy_friend) a on zy_profile.userid = a.userid  ";
	private static  String SQL_EDGES_LIST = "select distinct least(userid,friendid), greatest(userid,friendid) from zy_friend";
	
	private static Connection conn = null;
	
	private  PreparedStatement prepareStatement(String sql)
			throws SQLException {
		
		if(conn==null){
			//ComboPooledDataSource source = (ComboPooledDataSource)GetBeanUtil.getInstance().getBean("dataSource");
			conn = JDBCUtil.getConnection();
			//conn = source.getConnection();
			//return this.getHibernateTemplate().getSessionFactory().openSession().connection().prepareStatement(sql);
		}
		return conn.prepareStatement(sql);
	}

	private void releaseConnection(PreparedStatement pstmt,
			ResultSet rs) {
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	
	public  Graph loadObject(){
		return loadObjectFromDb();
	}
	
	
	private Graph loadObjectFromDb() {
		//GraphDao graph = new GraphDao();
		System.out.println("--------------load graph from db");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// get graph max vertex count
			pstmt = prepareStatement(SQL_NODE_COUNT.toLowerCase());
			rs = pstmt.executeQuery();
			rs.next();
			//graph.ensureCapacity(rs.getInt(1));
			this.ensureCapacity(rs.getInt(1));
			rs.close();
			rs = null;
			pstmt.close();
			pstmt = null;

			// load graph vertices
			pstmt = prepareStatement(SQL_NODE_LIST.toLowerCase());
			rs = pstmt.executeQuery();
			int c_ = 0;
			int rc_ = 0;
			while (rs.next()) {
				GraphNode node = new GraphNode(rs.getLong(1), (short) 0, null,rs.getShort(2), rs.getShort(3));
				//graph.addInitNode(node, true);
				this.addInitNode(node, true);
				c_++;
				rc_++;
				if (c_ == 100) {
					c_ = 0;
				}
			}
			rs.close();
			rs = null;
			pstmt.close();
			pstmt = null;
			
			// load graph edges
			pstmt = prepareStatement(SQL_EDGES_LIST.toLowerCase());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//graph.addInitEdge(rs.getLong(1), rs.getLong(2));
				this.addInitEdge(rs.getLong(1), rs.getLong(2));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NullPointerException();
		} finally {
			releaseConnection(pstmt, rs);
		}
		
		System.out.println("finish************");
		return this;
	}


	public int size() {
		return _nodes.size();
	}

	public void trimToSize() {
		_nodes.trimToSize();

		ObjectArrayList list = _nodes.values();
		for (int i = 0; i < list.size(); i++) {
			GraphNode node = (GraphNode) list.get(i);
			if (node != null) {
				node.trimToSize();
			}
		}
		list = null;

		Runtime.getRuntime().gc();
	}

	public ObjectArrayList nodes() {
		return _nodes.values();
	}

	public void addNode(GraphNode node) {
		addNode(node, false);
	}

	public void addNode(GraphNode node, boolean replace) {
		if (!replace && _nodes.containsKey(node.getKey())) {
			return;
		}
		//System.out.println("nodesize is:"+_nodes.size());
		_nodes.put(node.getKey(), node);
	}

	public void addInitNode(GraphNode node, boolean replace) {
		if (!replace && _nodes.containsKey(node.getKey())) {
			return;
		}
		_nodes.put(node.getKey(), node);
	}

	public GraphNode findNode(long key) {
		return (GraphNode) _nodes.get(key);
	}

	public void deleteNode(GraphNode node) {
		if (node == null) {
			return;
		}
		node.deleteAllEdges();
		_nodes.removeKey(node.getKey());
	}

	public void deleteNode(long key) {
		deleteNode(findNode(key));
		// updateAllCacheInfo();
	}

	public void addEdge(GraphNode node1, GraphNode node2) {
		if (node1 == null || node2 == null || node1.equals(node2)) {
			return;
		}
		node1.addEdgeTo(node2);
		node2.addEdgeTo(node1);
	}

	public void addInitEdge(long key1, long key2) {
		if (key1 == key2) {
			return;
		}
		addInitEdge(findNode(key1), findNode(key2));
	}

	public void addInitEdge(GraphNode node1, GraphNode node2) {
		if (node1 == null || node2 == null || node1.equals(node2)) {
			return;
		}
		node1.addEdgeTo(node2);
		node2.addEdgeTo(node1);
	}

	public void addEdge(long key1, long key2) {
		if (key1 == key2) {
			return;
		}
		addEdge(findNode(key1), findNode(key2));
		// updateAllCacheInfo();
	}

	public void deleteEdge(GraphNode node1, GraphNode node2) {
		if (node1 != null) {
			node1.deleteEdgeTo(node2);
		}
		if (node2 != null) {
			node2.deleteEdgeTo(node1);
		}
	}

	public void deleteEdge(long key1, long key2) {
		deleteEdge(findNode(key1), findNode(key2));
		// updateAllCacheInfo();
	}

	public GraphNetwork getNetwork(long key, int depth) {
		return getNetwork(findNode(key), depth);
	}

	public GraphNetwork getNetwork(GraphNode node, int depth) {
		GraphNetwork network = new GraphNetwork(node, depth);

		return network;
	}

	private synchronized void ensureCapacity(int minCapacity) {
		_nodes.ensureCapacity(minCapacity);
	}
	
	public static void main(String[] args){
		GraphDao graph = new GraphDao();
		Graph newGraph = graph.loadObject();
		System.out.println(newGraph.size());
	}
}
