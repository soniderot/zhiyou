package com.zy.domain.event.dao;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyEvent;
import com.zy.common.model.ZyEventmember;
import com.zy.facade.vo.EventVO;

public class EventDaoImpl extends HibernateDao<ZyEvent, Integer> implements EventDao{
	public List<EventVO> getEvents(String userIds,int pageNo,int pageSize){
		List<EventVO> results = new ArrayList<EventVO>();
		String hql = "from ZyEvent event,ZyEventmember member1  where event.id=member1.eventid and member1.userid in ("+userIds+") order by event.id desc";
		//return this.loadByPagenationf(hql, pageNo, pageSize, new Object[]{1});
		java.util.Iterator iter = this.loadByPagenation(hql, pageNo,pageSize).iterator();
		while(iter.hasNext()){
			Object[] obj = (Object[])iter.next();
			for(int i=0;obj!=null&&i<obj.length/2;i++){
				EventVO vo = new EventVO();
				vo.setEvent((ZyEvent)obj[0]);
				vo.setMember((ZyEventmember)obj[1]);
				results.add(vo);
			}
		}
		return results;
	}
}	
