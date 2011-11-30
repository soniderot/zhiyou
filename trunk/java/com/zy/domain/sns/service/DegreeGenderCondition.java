package com.zy.domain.sns.service;

import cern.colt.function.LongObjectProcedure;


public class DegreeGenderCondition implements LongObjectProcedure {
	short _gender = 0;
	short _degree = 0;

	// condition to do a query on the map
	public DegreeGenderCondition(short deg, short gen) {
		_degree = deg;
		_gender = gen;
	}

	public void setDegree(short deg) {
		_degree = deg;
	}

	public void setGender(short gen) {
		_gender = gen;
	}

	public boolean apply(long key, Object value) {
		return (((GraphPath.PathNode) value).getDistance() == _degree && ((GraphPath.PathNode) value)
				.getGender() == _gender);
	}

}
