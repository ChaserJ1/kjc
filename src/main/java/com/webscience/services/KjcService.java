package com.webscience.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.webscience.json.*;
import org.springframework.stereotype.Service;

import com.webscience.crawl.KjcUtils;
import com.webscience.util.Config;

@Service
public class KjcService {

	@PersistenceContext
	private EntityManager em;

	public List<ws_a_cugb_dept> queryList(String flagCode, String typeCode, String year) {
		String sql = null;
		Query query = null;
		String beginYear = year;
		String endYear = year;
		if (year.contains("~")) {
			beginYear = year.split("~")[0];
			endYear = year.split("~")[1];
		}
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {
			sql = "SELECT deptName,count(1) c FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND typeCode = :typeCode AND year >= :beginYear AND year <= :endYear GROUP BY deptName ORDER BY c desc";
		} else {
			sql = "SELECT deptName,count(1) c FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND year >= :beginYear AND year <= :endYear GROUP BY deptName ORDER BY c desc";
		}
		query = this.em.createNativeQuery(sql);
		List<ws_a_cugb_dept> list = new ArrayList<ws_a_cugb_dept>();
		query.setParameter("flagCode", flagCode);
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {
			query.setParameter("typeCode", typeCode);
		}
		query.setParameter("beginYear", beginYear);
		query.setParameter("endYear", endYear);
		List resultList = query.getResultList();
		float total = 0;
		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = (Object[]) resultList.get(i);
			total += Integer.parseInt(obj[1] == null ? "" : obj[1].toString());
		}
		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = (Object[]) resultList.get(i);
			ws_a_cugb_dept dept = new ws_a_cugb_dept();
			dept.setId((i + 1) + "");
			dept.setDeptName(obj[0] == null ? "" : obj[0].toString());
			String number = obj[1] == null ? "" : obj[1].toString();
			dept.setNumber(number);
			dept.setRate(Math.round((Integer.parseInt(number) * 100) / total) + "");
			list.add(dept);
		}
		return list;
	}

	public List<ws_a_cugb_dept_detail> query(String curPage, String perPage, String flagCode, String deptCode,
			String typeCode, String year) {
		String sql = null;
		Query query = null;
		String beginYear = year;
		String endYear = year;
		if (year.contains("~")) {
			beginYear = year.split("~")[0];
			endYear = year.split("~")[1];
		}
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {// CAST(checkId as
														// SIGNED) ASC
			sql = "SELECT * FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND typeCode = :typeCode AND year >= :beginYear AND year <= :endYear AND deptCode = :deptCode ORDER BY id ASC LIMIT :start,:end";
		} else {
			sql = "SELECT * FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND year >= :beginYear AND year <= :endYear AND deptCode = :deptCode ORDER BY id ASC LIMIT :start,:end";
		}
		query = this.em.createNativeQuery(sql);
		List<ws_a_cugb_dept_detail> list = new ArrayList<ws_a_cugb_dept_detail>();
		int start = (Integer.parseInt(curPage) - 1) * Integer.parseInt(perPage);
		int end = Integer.parseInt(perPage);
		query.setParameter("flagCode", flagCode);
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {
			query.setParameter("typeCode", typeCode);
		}
		query.setParameter("deptCode", deptCode);
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("beginYear", beginYear);
		query.setParameter("endYear", endYear);
		List resultList = query.getResultList();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] obj = (Object[]) resultList.get(i);
			ws_a_cugb_dept_detail dept = new ws_a_cugb_dept_detail();
			dept.setId((start + i + 1) + "");
			dept.setFlagCode(flagCode);
			dept.setFlagName(obj[2] == null ? "" : obj[2].toString());
			dept.setDeptCode(deptCode);
			dept.setDeptName(obj[4] == null ? "" : obj[4].toString());
			dept.setTypeCode(typeCode);
			dept.setTypeName(obj[6] == null ? "" : obj[6].toString());
			dept.setCheckId(obj[7] == null ? "" : obj[7].toString());
			dept.setInfo(obj[8] == null ? "" : obj[8].toString());
			dept.setYear(obj[9] == null ? "" : obj[9].toString());
			dept.setCurPage(curPage);
			list.add(dept);
		}
		return list;
	}

	public int queryTotal(String perPage, String flagCode, String deptCode, String typeCode, String year) {
		String sql = null;
		Query query = null;
		String beginYear = year;
		String endYear = year;
		if (year.contains("~")) {
			beginYear = year.split("~")[0];
			endYear = year.split("~")[1];
		}
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {
			sql = "SELECT COUNT(1) FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND typeCode = :typeCode AND year >= :beginYear AND year <= :endYear AND deptCode = :deptCode";
		} else {
			sql = "SELECT COUNT(1) FROM ws_a_cugb_dept WHERE flagCode = :flagCode AND year >= :beginYear AND year <= :endYear AND deptCode = :deptCode";
		}
		query = this.em.createNativeQuery(sql);
		query.setParameter("flagCode", flagCode);
		if (!typeCode.equals(KjcUtils.TYPE_CODE_QBJJ)) {
			query.setParameter("typeCode", typeCode);
		}
		query.setParameter("deptCode", deptCode);
		query.setParameter("beginYear", beginYear);
		query.setParameter("endYear", endYear);
		return Integer.parseInt(query.getSingleResult().toString());
	}

	public List<ws_files> getCugbData(String typeCode) {
		String sql = null;
		Query query = null;
		sql = "SELECT * FROM ws_a_cugb_file WHERE typeCode = :typeCode";
		query = this.em.createNativeQuery(sql);
		query.setParameter("typeCode", typeCode);
		List resultList = query.getResultList();
		List<ws_files> ws_filesList = new ArrayList<ws_files>();
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Object[] obj = (Object[]) resultList.get(i);
				ws_files files = new ws_files();
				files.setId((int) obj[0]);
				files.setType(obj[2] == null ? "" : obj[2].toString());
				files.setSort((int) obj[3]);
				files.setName(obj[4] == null ? "" : obj[4].toString());
				files.setPath(obj[5] == null ? "" : obj[5].toString());
				files.setDesc(obj[6] == null ? "" : obj[6].toString());
				files.setAddTime(obj[7] == null ? "" : obj[7].toString());
				ws_filesList.add(files);
			}
		}
		return ws_filesList;
	}

	public List<ws_files> getCugbData() {
		String sql = null;
		Query query = null;
		sql = "SELECT * FROM ws_files WHERE typeCode = '0' ORDER BY sort ASC";
		query = this.em.createNativeQuery(sql);
		List resultList = query.getResultList();
		List<ws_files> ws_filesList = new ArrayList<ws_files>();
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Object[] obj = (Object[]) resultList.get(i);
				ws_files files = new ws_files();
				files.setId((int) obj[0]);
				files.setType(obj[2] == null ? "" : obj[2].toString());
				files.setSort((int) obj[3]);
				files.setName(obj[4] == null ? "" : obj[4].toString());
				files.setPath(
						"http://" + Config.getIp() + ":" + Config.getPort() + obj[5] == null ? "" : obj[5].toString());
				files.setDesc(obj[6] == null ? "" : obj[6].toString());
				files.setAddTime(obj[7] == null ? "" : obj[7].toString());
				ws_filesList.add(files);
			}
		}
		return ws_filesList;
	}

	public List<ws_a_cugb> getCugb(String topicCode) {
		String sql = null;
		Query query = null;
		sql = "SELECT * FROM ws_a_cugb WHERE topicCode = :topicCode";
		query = this.em.createNativeQuery(sql);
		query.setParameter("topicCode", topicCode);
		List resultList = query.getResultList();
		List<ws_a_cugb> ws_a_cugbList = new ArrayList<ws_a_cugb>();
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Object[] obj = (Object[]) resultList.get(i);
				ws_a_cugb cugb = new ws_a_cugb();
				cugb.setId((int) obj[0]);
				cugb.setTopicCode(obj[1] == null ? "" : obj[1].toString());
				cugb.setTopicName(obj[2] == null ? "" : obj[2].toString());
				cugb.setProjectCode(obj[3] == null ? "" : obj[3].toString());
				cugb.setProjectName(obj[4] == null ? "" : obj[4].toString());
				cugb.setUnit(obj[5] == null ? "" : obj[5].toString());
				cugb.setYear1((float) obj[6]);
				cugb.setYear2((float) obj[7]);
				cugb.setYear3((float) obj[8]);
				cugb.setYear4((float) obj[9]);
				cugb.setYear5((float) obj[10]);
				cugb.setYear6((float) obj[11]);
				cugb.setYear7((float) obj[12]);
				cugb.setYear8((float) obj[13]);
				cugb.setYear9((float) obj[14]);
				cugb.setYear10((float) obj[15]);
				cugb.setYear11((float) obj[16]);
				cugb.setYear12((float) obj[17]);
				cugb.setUpdateTime(obj[18] == null ? "" : obj[18].toString());
				ws_a_cugbList.add(cugb);
			}
		}
		return ws_a_cugbList;
	}

	public List<ws_award> getAward() {
		String sql = null;
		Query query = null;
		sql = "SELECT * FROM ws_a_cugb_award";
		query = this.em.createNativeQuery(sql);
		List resultList = query.getResultList();
		List<ws_award> ws_awardList = new ArrayList<ws_award>();
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Object[] obj = (Object[]) resultList.get(i);
				ws_award award = new ws_award();
				award.setId((int) obj[0]);
				award.setName(obj[1] == null ? "" : obj[1].toString());
				award.setLevel(obj[2] == null ? "" : obj[2].toString());
				award.setYear(obj[3] == null ? "" : obj[3].toString());
				award.setType(obj[4] == null ? "" : obj[4].toString());
				award.setPerson(obj[5] == null ? "" : obj[5].toString());
				award.setSort(obj[6] == null ? "" : obj[6].toString());
				award.setAddTime(obj[7] == null ? "" : obj[7].toString());
				ws_awardList.add(award);
			}
		}
		return ws_awardList;
	}

	public List<Patent> getPatentByCategory(String patent) {
		String sql = "SELECT * FROM ws_a_cugb_trans where type = :type";
		Query query = null;
		query = this.em.createNativeQuery(sql);
		query.setParameter("type", patent);
		List resultList = query.getResultList();
		List<Patent> patentList = new ArrayList<>();

		if(resultList != null && resultList.size() > 0) {
			for(int i = 0; i < resultList.size(); i ++) {
				Object[] obj = (Object[]) resultList.get(i);
				Patent p = new Patent();
				p.setId(Integer.parseInt(obj[0].toString()));
				p.setName(obj[1] == null ? "" : obj[1].toString());
				p.setInventor(obj[2] == null ? "" : obj[2].toString());
				p.setType(obj[3] == null ? "" : obj[3].toString());
				p.setDesc(obj[4] == null ? "" : obj[4].toString());
				p.setAppliDate(obj[5] == null ? "" : obj[5].toString());
				p.setOpenDate(obj[6] == null ? "" : obj[6].toString());
				p.setPubNum(obj[7] == null ? "" : obj[7].toString());
				p.setAddTime(obj[8] == null ? "" : obj[8].toString());
				patentList.add(p);
			}
		}
		return patentList;
	}
}