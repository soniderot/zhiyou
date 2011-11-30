package com.zy.domain.sns.dao;
import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyFriendintroduce;
import com.zy.Constants;
import java.util.List;
public class SNSIntroduceDaoImpl extends HibernateDao<ZyFriendintroduce,Integer> implements SNSIntroduceDao {
	public List<ZyFriendintroduce> getAllIntroduces(int userId){
		String hql = "from ZyFriendintroduce where userid=? ";
		return this.find(hql, new Object[] { userId});
	}
	
	public List<ZyFriendintroduce> getAllIntroduces(int userId,short status){
		String hql = "from ZyFriendintroduce where userid=? and status=?";
		return this.find(hql, new Object[] { userId,status});
	}
	
	public List<ZyFriendintroduce> getAllPendingForward(int userId){
		String hql = "from ZyFriendintroduce where introducerid=? and status=?";
		return this.find(hql, new Object[] { userId,Constants.SNS_INTRODUCE_PENDING});
	}
	
	public List<ZyFriendintroduce> getIntroduceHisByRoot(int introduceId){
		String hql = "from ZyFriendintroduce where rootid=?";
		return this.find(hql, new Object[] {introduceId});
	}
	
	public ZyFriendintroduce getIntroduce(int userid,int rootid)
	{
		ZyFriendintroduce ZyFriendintroduce=null;
		String hql = "from ZyFriendintroduce where userid=? and rootid=?";
		List<ZyFriendintroduce> introduceList=this.find(hql, new Object[] {userid,rootid});
		if(introduceList != null && !introduceList.isEmpty())
		{
			ZyFriendintroduce=introduceList.get(0);
		}
		return ZyFriendintroduce;
	}
	
	public List<ZyFriendintroduce> getIntroduces(int sourceUserId,int targetUserId){
		String hql = "from ZyFriendintroduce where userid=? and targetid=?";
		return this.find(hql, new Object[] {sourceUserId,targetUserId});
	}
	
	public ZyFriendintroduce getIntroduces(int sourceUserId,int middleIntroducerId,int targetUserId){
		ZyFriendintroduce ZyFriendintroduce=null;
		String hql = "from ZyFriendintroduce where userid=? and targetid=? and introducerid=? and (status =? or status=?)";
		List<ZyFriendintroduce> introduceList = this.find(hql, new Object[] {sourceUserId,targetUserId,middleIntroducerId,Constants.SNS_INTRODUCE_PENDING,Constants.SNS_INTRODUCE_FORWARED});
		if(introduceList != null && !introduceList.isEmpty())
		{
			ZyFriendintroduce=introduceList.get(0);
		}
		return ZyFriendintroduce;
	}
	
	public List<ZyFriendintroduce> getPendingIntroduces(int sourceUserId,int targetUserId){
		String hql = "from ZyFriendintroduce where userid=? and targetid=? and (status =? or status=?)";
		return this.find(hql, new Object[] {sourceUserId,targetUserId,Constants.SNS_INTRODUCE_PENDING,Constants.SNS_INTRODUCE_FORWARED});
	}
}
