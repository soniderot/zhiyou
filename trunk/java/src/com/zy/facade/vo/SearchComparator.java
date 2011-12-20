package com.zy.facade.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class SearchComparator implements Comparator<SearchResultVo> {

	public int compare(SearchResultVo v1, SearchResultVo v2) {
		// first sort by degree ,second by numbers
		int flag = 0;
		if (v1.getDegree() < v2.getDegree()) {
			flag = -1;
		} else if (v1.getDegree() > v2.getDegree()) {
			flag = 1;
		}
		if (flag == 0) {
			if (v1.getFriendsCnt() > v2.getFriendsCnt()) {
				flag = -1;
			} else if (v1.getFriendsCnt() < v2.getFriendsCnt()) {
				flag = 1;
			}
		}
		return flag;
	}
}
