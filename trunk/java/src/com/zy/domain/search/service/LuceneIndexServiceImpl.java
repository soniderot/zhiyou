package com.zy.domain.search.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.zy.common.model.ZyIndexlog;
import com.zy.common.model.ZyIndexqueue;
import com.zy.common.util.LogUtil;
import com.zy.domain.search.BnsAnalyzer;
import com.zy.domain.search.IndexField;
import com.zy.domain.search.dao.IndexDao;
import com.zy.domain.search.dao.IndexLogDao;
import com.zy.facade.vo.LuceneProfileVo;

public class LuceneIndexServiceImpl implements LuceneIndexService {

	private IndexDao indexDao;
	private IndexLogDao indexLogDao;
	

	public IndexDao getIndexDao() {
		return indexDao;
	}

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	public IndexLogDao getIndexLogDao() {
		return indexLogDao;
	}

	public void setIndexLogDao(IndexLogDao indexLogDao) {
		this.indexLogDao = indexLogDao;
	}

	public void addProfileIndexQueue(int userId) {
		ZyIndexqueue index = new ZyIndexqueue();
		index.setUserid(userId);
		this.indexDao.save(index);
	}

	public void doProfileIndex(List<LuceneProfileVo> profiles, String fp) {
		IndexWriter writer = null;
		IndexReader reader = null;
		try {
			LogUtil.info("Indexing to directory '" + fp + "'...");
			File f = new File(fp);
			boolean isCreated = false;
			if (!f.exists()) {
				f.mkdirs();
			}
			LogUtil.info("---files len------------" + f.listFiles().length);
			if (f.listFiles().length <= 0) {
				isCreated = true;
			} else {
				try {
					reader = IndexReader.open(FSDirectory.open(f), false);
					for (LuceneProfileVo profile : profiles) {
						reader.deleteDocuments(new Term(
										IndexField.Profile.USER_ID, profile
												.getUserId()));
					}
					reader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					LogUtil.info("first to generate index ,no user to delete ");
				}
			}
			writer = new IndexWriter(FSDirectory.open(f),
					BnsAnalyzer.INDEX_ANALYZER, isCreated,
					IndexWriter.MaxFieldLength.LIMITED);
			for (LuceneProfileVo profile : profiles) {
				Document doc = new Document();
				doc.add(new Field(IndexField.Profile.USER_ID, profile
						.getUserId(), Store.YES, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.FULL_NAME, profile
						.getFullName(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.CAREER_BRIEF, profile
						.getCareerBrief(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.COMPANY_NAME, profile
						.getCompanyName(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.POSITION, profile
						.getPosition(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.SCHOOL_NAME, profile
						.getSchoolName(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.MAJOR, profile.getMajor(),
						Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.KEY_WORD, profile
						.getKeywords(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.FRIENDS_1D, profile
						.getFriendsCnt()
						+ "", Store.YES, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.INDUSTRY, profile
						.getIndustry(), Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.COUNTRY, profile
						.getCountryId()
						+ "", Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.REGION, profile
						.getRegionId()
						+ "", Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.CITY, profile.getCityId()
						+ "", Store.NO, Index.ANALYZED));
				doc.add(new Field(IndexField.Profile.GROUPS, profile
						.getGroups(), Store.NO, Index.ANALYZED));
				if (StringUtils.isNotBlank(profile.getContactSetting())) {
					doc.add(new Field(IndexField.Profile.CONTACT_SETTING,
							profile.getContactSetting(), Store.NO,
							Index.ANALYZED));
				}
				if (StringUtils.isNotBlank(profile.getCountrynamecn()))
					doc.add(new Field(IndexField.Profile.COUNTRY_NAME_CN,
							profile.getCountrynamecn(), Store.YES, Index.NO));
				if (StringUtils.isNotBlank(profile.getCitynamecn()))
					doc.add(new Field(IndexField.Profile.CITY_NAME_CN, profile
							.getCitynamecn(), Store.YES, Index.NO));
				if (StringUtils.isNotBlank(profile.getCountrynameen()))
					doc.add(new Field(IndexField.Profile.COUNTRY_NAME_EN,
							profile.getCountrynameen(), Store.YES, Index.NO));
				if (StringUtils.isNotBlank(profile.getCitynameen()))
					doc.add(new Field(IndexField.Profile.CITY_NAME_EN, profile
							.getCitynameen(), Store.YES, Index.NO));
				doc.add(new Field(IndexField.Profile.REG_TIME, profile
						.getRegTime(), Store.YES, Index.NOT_ANALYZED));
				if (StringUtils.isNotBlank(profile.getVerifiedCompanyId()))
					doc.add(new Field(IndexField.Profile.VERIFIED_COMPANY,
							profile.getVerifiedCompanyId(), Store.YES,
							Index.ANALYZED));
				if (StringUtils.isNotBlank(profile.getVerifiedSchoolId()))
					doc.add(new Field(IndexField.Profile.VERIFIED_SCHOOL,
							profile.getVerifiedSchoolId(), Store.YES,
							Index.ANALYZED));
				writer.addDocument(doc);
			}
			LogUtil.info("Optimizing...");
			writer.optimize();
			writer.close();
		} catch (IOException e) {
			LogUtil.error(e);
			LogUtil.info(" caught a " + e.getClass() + "\n with message: "
					+ e.getMessage());
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (CorruptIndexException e) {
			} catch (IOException e) {
			}
		}
	}

	public List<ZyIndexqueue> getUsersInQueue(int limitNum) {
		return this.indexDao.loadAll();
	}

	public void deleteDocument(int userId, String fp) {
		try {
			File f = new File(fp);
			if (f.exists() && f.listFiles().length > 0) {
				Directory dir = FSDirectory.open(f);
				if (IndexWriter.isLocked(dir)) {
					IndexWriter.unlock(dir);
				}
				IndexReader.open(dir, false).deleteDocuments(new Term(IndexField.Profile.USER_ID, userId + ""));
			}
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
			LogUtil.info(" caught a " + e.getClass() + "\n with message: " + e.getMessage());
		}
	}

	public void deleteDocument(List<Integer> profileIds, String fp) {
		IndexReader ir = null;
		try {
			File f = new File(fp);
			if (f.exists() && f.listFiles().length > 0) {
				Directory dir = FSDirectory.open(f);
				if (IndexWriter.isLocked(dir)) {
					IndexWriter.unlock(dir);
				}
				ir = IndexReader.open(dir, false);
				for (Integer userId : profileIds) {
					LogUtil.info("--------------" + userId);
					ir.deleteDocuments(new Term(IndexField.Profile.USER_ID, userId + ""));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
			LogUtil.info(" caught a " + e.getClass() + "\n with message: " + e.getMessage());
		} finally {
			try {
				if (ir != null)
					ir.close();
			} catch (IOException e) {
				LogUtil.error(e);
				LogUtil.info(" caught a " + e.getClass() + "\n with message: " + e.getMessage());
			}
		}

	}

	public void addIndexLog(ZyIndexlog log) {
		this.indexLogDao.save(log);
	}

	public ZyIndexlog getLastIndexLog() {
		return this.indexLogDao.getLastIndexLog();
	}

	public void deleteUsersInQueue(List<ZyIndexqueue> list) {
		this.indexDao.deleteAll(list);
	}
}
