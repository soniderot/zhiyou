package com.zy.domain.sns.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.list.TreeList;

import cern.colt.list.ObjectArrayList;

import com.zy.common.exception.GraphIsInitializingException;

public class Connections {
	private List paths;
	private List shortestPaths;
	private Map shortpathmap = new HashMap();
	private int cnt = 0;

	public Connections(GraphNetwork network, Node target)
			throws GraphIsInitializingException {
		init(network, target);
	}

	public Connections(GraphNetwork network, long targetId)
			throws GraphIsInitializingException {
		init(network, network.findNode(targetId));
	}

	public int getTotal() {
		return paths != null ? paths.size() : 0;
	}

	public List getPaths() {
		return paths != null ? paths : Collections.EMPTY_LIST;
	}

	public List getShortestPaths() {
		return shortestPaths != null ? shortestPaths : Collections.EMPTY_LIST;
	}

	private void init(GraphNetwork network, Node end)
			throws GraphIsInitializingException {

		if (network == null || end == null) {
			return;
		}
		if (network.getRoot().getKey() == end.getKey()) {
			return;
		}
		if (!network.isConnected(end.getKey())) {
			return;
		}
		shortestPaths = new TreeList();
		// find_all_paths(network, network.getRoot(), end, null,0);

		find_all_paths2(network, end, network.getRoot(), null, 0, end
				.getDistance());
		for (int i = 0; i < shortestPaths.size(); i++) {
			GraphPath list = (GraphPath) shortestPaths.get(i);
			list.add(network.getRoot().getKey());
			list.reverse();
			shortestPaths.set(i, list);
		}

	}

	private void find_all_paths2(GraphNetwork network, Node start, Node end,
			GraphPath path, int currentpathlength, int degree)
			throws GraphIsInitializingException {

		cnt++;
		GraphPath newpath;
		if (path == null)
			newpath = new GraphPath(0);
		else
			newpath = path.copy();
		newpath.add(start.getKey());

		// not a shortest path - so cutoff search from here.
		if (currentpathlength > 0 && newpath.size() > currentpathlength) {
			return;
		}

		if (start.getDistance() == 1) {
			// we got ourselves a newpath. Do we add it to the shortest paths or
			// not?
			boolean replace = true;
			boolean add = false;

			for (int i = 0; i < shortestPaths.size(); i++) {
				GraphPath list = (GraphPath) shortestPaths.get(i);
				// same size as the others - lets add it :)
				if (list.size() == newpath.size()) {
					add = true;
					replace = false;
				}
				// shorter than the others - get rid of them!
				else if (list.size() > newpath.size()) {
					replace = true;
				}
				if (list.size() > currentpathlength)
					currentpathlength = list.size();
			}

			if (replace) {
				shortestPaths = new TreeList();
				shortestPaths.add(newpath);
				currentpathlength = newpath.size();
			} else if (add) {
				shortestPaths.add(newpath);
			}
			// Loggable.log.info("map " + shortpathmap);
			return;

		}
//System.out.println("start=="+start.getKey()+",start.adj=="+start.adjacentKeys());
		ObjectArrayList adj = start.adjacentNodes();
		if (adj == null || adj.isEmpty()) {
			return;
		}

		for (int i = 0; i < adj.size(); i++) {
			try {
				Node gn = (Node) adj.get(i);
				gn = network.findNode(gn.getKey());
				
				if(gn==null) continue;
				
				if (newpath.contains(gn.getKey())
						|| gn.getDistance() >= start.getDistance()
						|| gn.getDistance() >= degree)
					continue;
				find_all_paths2(network, gn, end, newpath, currentpathlength,
						degree);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

	}

	private void find_all_paths(GraphNetwork network, Node start, Node end,
			GraphPath path, int currentpathlength)
			throws GraphIsInitializingException {
		cnt++;

		if (start.getDistance() >= end.getDistance())
			return;
		GraphPath newpath;
		if (path == null)
			newpath = new GraphPath(0);
		else
			newpath = path.copy();

		if (newpath.size() > end.getDistance())
			return;

		newpath.add(start.getKey());
		// not a shortest path - so cutoff search from here.
		if (currentpathlength > 0 && newpath.size() > currentpathlength) {
			return;
		}
		// Loggable.log.info(start.getKey() + " " + end.getKey()+ " " +
		// (start.getKey()
		// == end.getKey()));
		if (start.getKey() == end.getKey()) {

			// we got ourselves a newpath. Do we add it to the shortest paths or
			// not?
			boolean replace = true;
			boolean add = false;
			for (int i = 0; i < shortestPaths.size(); i++) {
				GraphPath list = (GraphPath) shortestPaths.get(i);
				// same size as the others - lets add it :)
				if (list.size() == newpath.size()) {
					add = true;
					replace = false;
				}
				// shorter than the others - get rid of them!
				else if (list.size() > newpath.size()) {
					replace = true;
				}
				if (list.size() > currentpathlength)
					currentpathlength = list.size();
			}

			if (replace) {
				shortestPaths = new TreeList();
				shortestPaths.add(newpath);
				currentpathlength = newpath.size();
			} else if (add) {
				shortestPaths.add(newpath);
			}
			// Loggable.log.info("map " + shortpathmap);
			return;

		}

		ObjectArrayList adj = start.adjacentNodes();
		if (adj == null || adj.isEmpty()) {
			return;
		}

		for (int i = 0; i < adj.size(); i++) {
			Node gn = (Node) adj.get(i);
			if (newpath.contains(gn.getKey())) {
				continue;
			}
			find_all_paths(network, gn, end, newpath, currentpathlength);
		}
	}

	void sortByLength() {
		if (paths == null || paths.isEmpty())
			return;

		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((GraphPath) o1).getLength()
						- ((GraphPath) o2).getLength();
			}
		};

		Collections.sort(paths, c);
	}
}
