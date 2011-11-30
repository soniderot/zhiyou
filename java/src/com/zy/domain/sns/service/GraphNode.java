package com.zy.domain.sns.service;

import java.util.Date;

import cern.colt.list.LongArrayList;
import cern.colt.list.ObjectArrayList;
import cern.colt.map.OpenLongObjectHashMap;

import com.zy.common.util.LongDataList;
import com.zy.common.util.SimpleLongDataList;

public final class GraphNode implements Node, java.io.Serializable {
	private long _key;
	private short _photos;
	private short _gender;
	private short _country;
	private short _distance;
	private Date _created;
	private OpenLongObjectHashMap _adj;

	protected GraphNode() {
		_adj = new OpenLongObjectHashMap(Graph.DEFAULT_FRIENDS_CAPACITY);

	}

	public GraphNode(long key, Date created) {
		this(key, (short) 0, created);
	}

	public GraphNode(long key, short photos, Date created, short gender,
			short country) {
		this();
		_key = key;
		_photos = photos;
		_created = created;
		_gender = gender;
		_country = country;
	}

	public GraphNode(long key, short photos, Date created) {
		this();
		_key = key;
		_photos = photos;
		_created = created;
	}

	public long getKey() {
		return _key;
	}

	public void setKey(long key) {
		_key = key;
	}

	public short getDistance() {
		return _distance;
	}

	public short getGender() {
		return _gender;
	}

	public void setGender(short gender) {
		_gender = gender;
	}

	public short getCountry() {
		return _country;
	}

	public void setCountry(short country) {
		_country = country;
	}

	public short getPhotos() {
		return _photos;
	}

	public void setPhotos(short photos) {
		_photos = photos;
	}

	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		_created = created;
	}

	public OpenLongObjectHashMap getAdjacent() {
		return _adj;
	}

	public void setAdjacent(OpenLongObjectHashMap adj) {
		_adj = adj;
	}

	public LongArrayList adjacentKeys() {
		return (_adj != null) ? _adj.keys() : null;
	}

	public ObjectArrayList adjacentNodes() {
		return (_adj != null) ? _adj.values() : null;
	}

	public LongDataList adjacentKeysSortedByPhotos() {
		ObjectArrayList v = adjacentNodes();
		if (v == null || v.isEmpty())
			return null;

		v.quickSortFromTo(0, v.size() - 1, new Node.PhotosComparator());
		SimpleLongDataList list = new SimpleLongDataList(v.size());
		for (int i = 0; i < v.size(); i++) {
			list.add(((Node) v.get(i)).getKey());
		}
		return list;
	}

	public void addEdgeTo(GraphNode node) {

		if (node == null)
			return;
		if (node._key == _key)
			return;
		if (!_adj.containsKey(node._key))
			_adj.put(node._key, node);

	}

	public void deleteEdgeTo(GraphNode node) {
		if (node != null)
			_adj.removeKey(node._key);
	}

	public void deleteAllEdges() {
		if (_adj == null || _adj.isEmpty())
			return;
		ObjectArrayList nodes = _adj.values();
		for (int i = 0; i < _adj.size(); i++) {
			GraphNode node = (GraphNode) nodes.get(i);
			if (node != null)
				node.deleteEdgeTo(this);
		}
	}

	public boolean isAdjacent(long key) {
		if (_adj == null || _adj.isEmpty())
			return false;
		return _adj.containsKey(key);
	}

	public boolean isAdjacent(GraphNode node) {
		if (node == null)
			return false;
		return isAdjacent(node._key);
	}

	public int edgeCount() {
		return _adj != null ? _adj.size() : 0;
	}

	public void incrementPhotos() {
		_photos++;
	}

	public void decrementPhotos() {
		if (_photos > 0)
			_photos--;
	}

	public void trimToSize() {
		if (_adj != null)
			_adj.trimToSize();
	}

	public boolean equals(Object o) {
		if (this == o) { // quick check
			return true;
		}
		if (!(o instanceof GraphNode)) { // (1) same object?
			return false;
		}
		GraphNode other = (GraphNode) o;
		if (_key != other._key) {
			return false;
		}
		return true;

	}

	public GraphNetwork getNetwork(int depth) {
		GraphNetwork network = new GraphNetwork(this, depth);

		return network;
	}

	public String toString() {
		return "key:" + _key + ",gender:" + _gender;
	}

}
