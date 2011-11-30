package com.zy.domain.sns.service;

import cern.colt.function.LongObjectProcedure;

public class DegreeCondition implements LongObjectProcedure {
	short _degree = 0;

	// condition to do a query on the map
	public DegreeCondition(short deg) {
		_degree = deg;
	}

	public void setDegree(short deg) {
		_degree = deg;
	}

	public boolean apply(long key, Object value) {
		return ((GraphPath.PathNode) value).getDistance() == _degree;
	}

}
