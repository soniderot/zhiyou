package com.zy.domain.message.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyNotification;

public class NotificationDaoImpl extends HibernateDao <ZyNotification, Integer> implements NotificationDao  {

	@Override
	public List<ZyNotification> getUserNotification(int userid,int pageNo, int pageSize) {
		System.out.println("userid--"+userid);
		String hql="from ZyNotification where receiverid=? and (isdeleted is null or isdeleted!='T') order by id desc";
		return this.loadByPagenation(hql, pageNo, pageSize, new Object[] { userid});
		//System.out.println(this.find(hql).size());
		//return this.loadByPagenation(hql, pageNo, pageSize);
	}
	
	@Override
	public List<ZyNotification> getUserUnreadNotification(int userid,int num) {
		Calendar lastmonday = Calendar.getInstance();
		Calendar lastsunday = Calendar.getInstance();
		lastmonday.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		lastsunday.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		lastmonday = DateUtils.truncate(lastmonday,Calendar.DAY_OF_MONTH);
		lastsunday = DateUtils.truncate(lastmonday,Calendar.DAY_OF_MONTH);
		lastmonday.add(Calendar.DAY_OF_MONTH,-7);
		String hql="from ZyNotification where receiverid="+userid+" and isdeleted is null and isread is null and createtime>=? and createtime<? order by id desc";
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		hibernateTemplate.setMaxResults(num);
		return hibernateTemplate.find(hql,new Object[]{lastmonday.getTime(),lastsunday.getTime()});
	}

	@Override
	public int countForNotification(int userid) {
		String hql="select count(*) from ZyNotification where receiverid =? and isread is null and (isdeleted is null or isdeleted!='T')";
		return this.getTotalRows(hql, new Object[] { userid });
	}
	
	@Override
	public int getUserNotificationCNT(int userId){
		String hql="select count(*) from ZyNotification where receiverid =? and (isdeleted is null or isdeleted!='T')";
		return this.getTotalRows(hql, new Object[] { userId });
	}

	@Override
	public List<ZyNotification> getAllUserNotification(int userid) {
		String hql="from ZyNotification where receiverid=? and (isdeleted is null or isdeleted!='T')";
		return this.find(hql, new Object[] { userid});
	}

	


}
