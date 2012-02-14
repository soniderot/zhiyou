package com.zy.domain.feed.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyBlockedfeeds;


public class BlockedFeedsDaoImpl extends HibernateDao<ZyBlockedfeeds, Integer> implements BlockedFeedsDao {

	@Override
	public List<ZyBlockedfeeds> getBlockedFeedsByUser(Integer userId) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, -14);
		date = calendar.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = df.format(date);
		String hql = "from ZyBlockedfeeds where userid = " + userId + " and createtime > '" + newDate + "'";
		return this.find(hql);
	}


}
