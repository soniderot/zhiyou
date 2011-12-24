package com.zy.domain.sns.dao;
import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyFriend;
import com.zy.common.model.ZyFriendDetail;
import com.zy.common.model.ZyProfile;

public class FriendDaoImpl extends HibernateDao<ZyFriend,Integer> implements FriendDao {
	public List<ZyFriend> getFriends(int userId,int friendId) {
		String hql = "from ZyFriend where (userid=? and friendid=? or userid=? and friendid=?)";
		return this.find(hql, new Object[] { userId, friendId, friendId,userId});
	}
	
	public List<ZyFriend> getFriendsByGroupId(int userId,int ZyGroupId) {
		String hql = "from ZyFriend where userid=? and groupid=? ";
		return this.find(hql, new Object[] { userId, ZyGroupId});
	}
	
	public List<ZyFriend> getFriendsByGroupId(int ZyGroupId) {
		String hql = "from ZyFriend where groupid=? ";
		return this.find(hql, new Object[] {ZyGroupId});
	}
	
	public ZyFriend load(int userId,int friendId){
		String hql = "from ZyFriend where (userid=? and friendid=?)";
		List<ZyFriend> friends = this.find(hql, new Object[] { userId, friendId});
		if(friends!=null&&friends.size()>0){
			return friends.get(0);
		}else{
			return null;
		}
	}	
	
	public List<ZyFriendDetail> get1stFriends(int userId,int pageNo,int pageSize) {
		List<ZyFriendDetail> results = new java.util.ArrayList<ZyFriendDetail>();
		
		String sortingSql = "friend.createtime desc";
		
		
		String hql = "from ZyFriend friend,ZyProfile profile where friend.userid=? and friend.friendid=profile.userid order by "+sortingSql;
		
		java.util.Iterator iter = this.loadByPagenation(hql, pageNo,pageSize,new Object[] { userId}).iterator();
		while(iter.hasNext()){
			Object[] obj = (Object[])iter.next();
			for(int i=0;obj!=null&&i<obj.length/2;i++){
				ZyFriendDetail vo = new ZyFriendDetail();
				vo.setFriend((ZyFriend)obj[0]);
				vo.setProfile((ZyProfile)obj[1]);
				results.add(vo);
			}
		}
		return results;
	}
	
	
	public List<ZyFriendDetail> get1stFriends(int userId,Object value,int pageNo,int pageSize,int type,int sorting) {
		List<ZyFriendDetail> results = new java.util.ArrayList<ZyFriendDetail>();
		String appendHql = "";
		if(type==1)
			appendHql = "and friend.groupid = ?";
		if(type==2)
			appendHql = "and profile.username like  ?";
		
		
		String sortingSql = "friend.createtime desc";
		if(sorting==1){
			sortingSql = "profile.lastlogintime desc";
		}else if(sorting==2){
			sortingSql = "convert(profile.fullname,gbk )";
		}
		String hql = "from ZyFriend friend,ZyProfile profile where friend.userid=? "+appendHql+" and friend.friendid=profile.userid order by "+sortingSql;
		
		java.util.Iterator iter = null;
		if(type!=2){
			iter = this.loadByPagenation(hql, pageNo,pageSize,new Object[] { userId,value}).iterator();
		}else{
			iter = this.loadByPagenation(hql, pageNo,pageSize,new Object[] { userId,"%"+value+"%"}).iterator();
		}
		
		//String hql = "from SnsFriend friend inner join BnsProfile profile on friend.friendid=profile.userid  ";
		
		while(iter.hasNext()){
			Object[] obj = (Object[])iter.next();
			for(int i=0;obj!=null&&i<obj.length/2;i++){
				ZyFriendDetail vo = new ZyFriendDetail();
				vo.setFriend((ZyFriend)obj[0]);
				vo.setProfile((ZyProfile)obj[1]);
				results.add(vo);
			}
		}
		return results;
	}
}

