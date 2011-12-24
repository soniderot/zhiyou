package com.zy.domain.profile.dao;
import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyMemo;
public class MemoDaoImpl extends HibernateDao<ZyMemo,Integer> implements MemoDao {
	public List<ZyMemo> findMemoByUserId(int userId,int pageNo,int pageSize) {
		String hql="from BnsMemo where userId=?";
		return this.loadByPagenation(hql, pageNo, pageSize,userId);
	}
	
	public int getMemosCnt(int userId){
		String hql="select count(*) from BnsMemo where userId=?";
		return this.getTotalRows(hql,new Object[] { userId});
	}
	
	public ZyMemo getMemoByUidPid(int userId,int targetUserId){
		String hql="from BnsMemo where userId=? and memorid=?";
		List<ZyMemo> memoList = this.find(hql,new Object[] { userId,targetUserId});
		if(memoList==null || memoList.size()<1){
			return null;
		}else{
			return memoList.get(0);
		}
	}
}
