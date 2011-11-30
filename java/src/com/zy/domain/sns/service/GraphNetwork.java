package com.zy.domain.sns.service;

import cern.colt.list.LongArrayList;
import cern.colt.list.ObjectArrayList;
import cern.colt.map.OpenLongObjectHashMap;

import com.zy.common.util.LongDataListAccessor;
import com.zy.common.util.Queue;

public class GraphNetwork implements java.io.Serializable {
	private GraphNode _root;
	private int _depth;
	private OpenLongObjectHashMap _nodes;

	public GraphNetwork(GraphNode root, int depth) {
		_root = root;
		_depth = depth;
		init();
	}

	public GraphNode getRoot() {
		return _root;
	}

	public int getDepth() {
		return _depth;
	}

	public int getSize() {
		return getNodesMap().size();
	}

	public OpenLongObjectHashMap getNodesMap() {
		if (_nodes == null) {
			init();
		}
		return _nodes;
	}

	private synchronized void init() {
		if (_root == null) {
			_nodes = new OpenLongObjectHashMap(0);
			return;
		}

		// Loggable.log.info("GraphNetwork init :"+_root.getKey());
		_nodes = new OpenLongObjectHashMap(Graph.DEFAULT_FRIENDS_CAPACITY + 1);
		GraphPath.PathNode rootNode = new GraphPath.PathNode(_root, (short) 0);
		Queue queue = new Queue();
		// Mark top node as visited
		queue.enqueue(rootNode);
		_nodes.put(rootNode.getKey(), rootNode);
		int cnt = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		while (!queue.isEmpty()) {
			cnt++;

			GraphPath.PathNode current = (GraphPath.PathNode) queue.dequeue();
			if (current.getDistance() >= _depth) {
				continue;
			}

			ObjectArrayList adj = current.adjacentNodes();
			if (adj == null || adj.isEmpty()) {
				continue;
			}
			for (int i = 0; i < adj.size(); i++) {
				cnt2++;
				GraphNode gn = (GraphNode) adj.get(i);
				if (!_nodes.containsKey(gn.getKey())) {
					// mark node as visited
					GraphPath.PathNode pn = new GraphPath.PathNode(gn, current
							.getDistance() + 1);
					queue.enqueue(pn);
					_nodes.put(pn.getKey(), pn);
					cnt3++;
				}
			}
		}
		// remove root
		_nodes.removeKey(_root.getKey());
		// trim to size
		_nodes.trimToSize();
		// Loggable.log.info("GraphNetwork init "+_root.getKey()+ " "
		// +cnt+","+cnt2+","+cnt3);
	}

	public LongArrayList getNodesList() {
		return getNodesMap().keys();
	}

	public LongDataListAccessor getNodesListAccessor() {
		return new ColtLongListAccessor(getNodesMap().keys());
	}

	public LongArrayList keysSortedByDistance() {
		LongArrayList list = new LongArrayList(getNodesMap().size());
		getNodesMap().keysSortedByValue(list);
		return list;
	}

	public int getDistanceFromRoot(long key2) {
		Node v = (Node) getNodesMap().get(key2);
		return v.getDistance();
	}

	public LongArrayList keysSortedByDate() {
		ObjectArrayList v = getNodesMap().values();
		v.quickSortFromTo(0, v.size() - 1, new Node.DateComparator());
		LongArrayList list = new LongArrayList(v.size());
		for (int i = 0; i < v.size(); i++) {
			list.add(((Node) v.get(i)).getKey());
		}
		return list;
	}

	public LongArrayList keysByDegree(short degree) {
		DegreeCondition condition = new DegreeCondition(degree);
		LongArrayList keylist = new LongArrayList();
		ObjectArrayList vallist = getNodesMap().values();
		getNodesMap().pairsMatching(condition, keylist, vallist);
		return keylist;
	}

	public LongArrayList keysByDegreeGender(short degree, short gender) {
		DegreeGenderCondition condition = new DegreeGenderCondition(degree,
				gender);
		LongArrayList keylist = new LongArrayList();
		ObjectArrayList vallist = getNodesMap().values();
		getNodesMap().pairsMatching(condition, keylist, vallist);
		return keylist;
	}

	public LongArrayList getNeibours() {
		return _root.adjacentKeys();
	}

	public int getTotalNeibours() {
		return getNeibours().size();
	}

	public Node findNode(long key) {
		return (Node) getNodesMap().get(key);
	}

	public boolean isConnected(long node) {
		return getNodesMap().containsKey(node);
	}

	public boolean isConnected(GraphNode node) {
		if (node == null)
			return false;
		return isConnected(node.getKey());
	}

	public boolean isAdjacent(GraphNode node) {
		return _root.isAdjacent(node);
	}

	public boolean isAdjacent(long node) {
		return _root.isAdjacent(node);
	}

	protected static class ColtLongListAccessor implements LongDataListAccessor {
		private final LongArrayList _list;

		ColtLongListAccessor(LongArrayList list) {
			_list = list;
		}

		public int size() {
			return _list.size();
		}

		public long get(int index) {
			return _list.get(index);
		}

	}

}
