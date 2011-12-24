package com.zy.domain.profile.service;

import java.util.List;

import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZyMemo;
import com.zy.common.model.ZyProfile;
public interface ProfileService {
	
	public ZyProfile findProfileById(int profileId);
	
	public ZyProfile findProfileByEmail(String email);
	
	public ZyProfile findProfileByName(String userName);
	
	public ZyProfile checkProfileLogin(String email,String password);
	
	public void insertProfile(ZyProfile profile);
	
	public void updateProfile(ZyProfile profile);
	
	public void updateLogo(int userId,String path);

	public List<ZyMemo> findMemoByUserId(int userId,int pageNo,int pageSize);
	
	public void deleteMemoByMemoId(int userId,int memoId);
	
	public int getUserMemoCnt(int userId);
	
	public void saveMemo(String content,int userId,int targetUserId);
	
	public ZyMemo getMemoByUidPid(int userId,int targetUserId);
	
	public ZyEducation getByEductioinId(Integer id);
	public List<ZyEducation> findByEducationsUserId(Integer userId);
	public void updateEducation(ZyEducation education);
	
	public List<ZyProfile> findProfileByPoint(String userIds);
}
