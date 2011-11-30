package com.zy.domain.profile.dao;
import java.util.List;
import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyMemo;
public interface MemoDao extends BaseDao<ZyMemo, Integer> {
	public List<ZyMemo> findMemoByUserId(int userId,int pageNo,int pageSize);
	
	public int getMemosCnt(int userId);
	
	public ZyMemo getMemoByUidPid(int userId,int targetUserId);
}
