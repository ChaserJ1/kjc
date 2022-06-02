package com.kjcManager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjcManager.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjcManager.services.KjcService;
import com.kjcManager.util.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KjcController {
	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private KjcService kjcService;
	static String charset = Config.getCharset();
	static String title = Config.getTitle();

	@RequestMapping(value = "/cugb.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String cugb(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/management.jsp";
		List<ws_files> filesList = kjcService.getCugbData();
		request.setAttribute("filesList", filesList);
		request.setAttribute("title", title);
		return toPage;
	}

	public List<String> getYearList() {
		Calendar cal = Calendar.getInstance();
		int curYear = cal.get(Calendar.YEAR);
		List<String> ws_a_cugb_k = new ArrayList<String>();
		for (int i = curYear - 9; i < curYear + 1; i++) {
			ws_a_cugb_k.add(i + "");
		}
		for (int i = 0; i < ws_a_cugb_k.size(); i++) {
			System.out.println(ws_a_cugb_k.get(i));
		}
		return ws_a_cugb_k;
	}

	public List<Float> getDataList(ws_a_cugb a_cugb) {
		List<Float> ws_a_cugb_v = new ArrayList<Float>();
		// ws_a_cugb_v.add(a_cugb.getYear1());
		// ws_a_cugb_v.add(a_cugb.getYear2());
		ws_a_cugb_v.add(a_cugb.getYear3());
		ws_a_cugb_v.add(a_cugb.getYear4());
		ws_a_cugb_v.add(a_cugb.getYear5());
		ws_a_cugb_v.add(a_cugb.getYear6());
		ws_a_cugb_v.add(a_cugb.getYear7());
		ws_a_cugb_v.add(a_cugb.getYear8());
		ws_a_cugb_v.add(a_cugb.getYear9());
		ws_a_cugb_v.add(a_cugb.getYear10());
		ws_a_cugb_v.add(a_cugb.getYear11());
		ws_a_cugb_v.add(a_cugb.getYear12());
		return ws_a_cugb_v;
	}

	@RequestMapping(value = "/cugbResearchers.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String cugbResearchers(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/cugbResearchers.jsp";
		// 科研队伍
		List<ws_a_cugb> ws_a_cugbList = kjcService.getCugb("KYDW");
		List<String> ws_a_cugb_k = getYearList();
		List<Float> ws_a_cugb_JJR_v = new ArrayList<Float>();
		List<Float> ws_a_cugb_LWR_v = new ArrayList<Float>();
		List<Float> ws_a_cugb_KYR_v = new ArrayList<Float>();
		String ws_a_cugb_JJR_unit = "";
		String ws_a_cugb_LWR_unit = "";
		String ws_a_cugb_KYR_unit = "";
		String ws_a_cugb_JJR_project = "";
		String ws_a_cugb_LWR_project = "";
		String ws_a_cugb_KYR_project = "";
		String ws_a_cugb_JJR_update = "";
		String ws_a_cugb_LWR_update = "";
		String ws_a_cugb_KYR_update = "";
		for (int i = 0; i < ws_a_cugbList.size(); i++) {
			ws_a_cugb a_cugb = ws_a_cugbList.get(i);
			if (a_cugb.getProjectCode().equals("JJR")) {
				ws_a_cugb_JJR_v = getDataList(a_cugb);
				ws_a_cugb_JJR_unit = a_cugb.getUnit();
				ws_a_cugb_JJR_project = a_cugb.getProjectName();
				ws_a_cugb_JJR_update = a_cugb.getUpdateTime();
			}
			if (a_cugb.getProjectCode().equals("LWR")) {
				ws_a_cugb_LWR_v = getDataList(a_cugb);
				ws_a_cugb_LWR_unit = a_cugb.getUnit();
				ws_a_cugb_LWR_project = a_cugb.getProjectName();
				ws_a_cugb_LWR_update = a_cugb.getUpdateTime();
			}
			if (a_cugb.getProjectCode().equals("KYR")) {
				ws_a_cugb_KYR_v = getDataList(a_cugb);
				ws_a_cugb_KYR_unit = a_cugb.getUnit();
				ws_a_cugb_KYR_project = a_cugb.getProjectName();
				ws_a_cugb_KYR_update = a_cugb.getUpdateTime();
			}
		}
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(0);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		request.setAttribute("ws_a_cugb_k", ws_a_cugb_k);
		request.setAttribute("ws_a_cugb_JJR_v", ws_a_cugb_JJR_v);
		request.setAttribute("ws_a_cugb_LWR_v", ws_a_cugb_LWR_v);
		request.setAttribute("ws_a_cugb_KYR_v", ws_a_cugb_KYR_v);
		request.setAttribute("ws_a_cugb_JJR_unit", ws_a_cugb_JJR_unit);
		request.setAttribute("ws_a_cugb_LWR_unit", ws_a_cugb_LWR_unit);
		request.setAttribute("ws_a_cugb_KYR_unit", ws_a_cugb_KYR_unit);
		request.setAttribute("ws_a_cugb_JJR_project", ws_a_cugb_JJR_project);
		request.setAttribute("ws_a_cugb_LWR_project", ws_a_cugb_LWR_project);
		request.setAttribute("ws_a_cugb_KYR_project", ws_a_cugb_KYR_project);
		request.setAttribute("ws_a_cugb_JJR_update", ws_a_cugb_JJR_update);
		request.setAttribute("ws_a_cugb_LWR_update", ws_a_cugb_LWR_update);
		request.setAttribute("ws_a_cugb_KYR_update", ws_a_cugb_KYR_update);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/cugbFunds.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String cugbFunds(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/cugbFunds.jsp";
		// 科研项目
		List<ws_a_cugb> ws_a_cugbList = kjcService.getCugb("KYXM");
		List<String> ws_a_cugb_k = getYearList();
		List<Float> ws_a_cugb_NDZ_v = new ArrayList<Float>();
		List<Float> ws_a_cugb_ZRK_v = new ArrayList<Float>();
		String ws_a_cugb_NDZ_unit = "";
		String ws_a_cugb_ZRK_unit = "";
		String ws_a_cugb_NDZ_project = "";
		String ws_a_cugb_ZRK_project = "";
		String ws_a_cugb_NDZ_update = "";
		String ws_a_cugb_ZRK_update = "";
		for (int i = 0; i < ws_a_cugbList.size(); i++) {
			ws_a_cugb a_cugb = ws_a_cugbList.get(i);
			if (a_cugb.getProjectCode().equals("NDZ")) {
				ws_a_cugb_NDZ_v = getDataList(a_cugb);
				ws_a_cugb_NDZ_unit = a_cugb.getUnit();
				ws_a_cugb_NDZ_project = a_cugb.getProjectName();
				ws_a_cugb_NDZ_update = a_cugb.getUpdateTime();
			}
			if (a_cugb.getProjectCode().equals("ZRK")) {
				ws_a_cugb_ZRK_v = getDataList(a_cugb);
				ws_a_cugb_ZRK_unit = a_cugb.getUnit();
				ws_a_cugb_ZRK_project = a_cugb.getProjectName();
				ws_a_cugb_ZRK_update = a_cugb.getUpdateTime();
			}
		}
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(1);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		request.setAttribute("ws_a_cugb_k", ws_a_cugb_k);
		request.setAttribute("ws_a_cugb_NDZ_v", ws_a_cugb_NDZ_v);
		request.setAttribute("ws_a_cugb_NDZ_unit", ws_a_cugb_NDZ_unit);
		request.setAttribute("ws_a_cugb_NDZ_project", ws_a_cugb_NDZ_project);
		request.setAttribute("ws_a_cugb_NDZ_update", ws_a_cugb_NDZ_update);
		request.setAttribute("ws_a_cugb_ZRK_v", ws_a_cugb_ZRK_v);
		request.setAttribute("ws_a_cugb_ZRK_unit", ws_a_cugb_ZRK_unit);
		request.setAttribute("ws_a_cugb_ZRK_project", ws_a_cugb_ZRK_project);
		request.setAttribute("ws_a_cugb_ZRK_update", ws_a_cugb_ZRK_update);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/cugbPapers.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String cugbPapers(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/cugbPapers.jsp";
		// 学术论文
		List<ws_a_cugb> ws_a_cugbList = kjcService.getCugb("XSLW");
		List<String> ws_a_cugb_k = getYearList();
		List<Float> ws_a_cugb_SCI_v = new ArrayList<Float>();
		List<Float> ws_a_cugb_BZX_v = new ArrayList<Float>();
		String ws_a_cugb_SCI_unit = "";
		String ws_a_cugb_BZX_unit = "";
		String ws_a_cugb_SCI_project = "";
		String ws_a_cugb_BZX_project = "";
		String ws_a_cugb_SCI_update = "";
		String ws_a_cugb_BZX_update = "";
		for (int i = 0; i < ws_a_cugbList.size(); i++) {
			ws_a_cugb a_cugb = ws_a_cugbList.get(i);
			if (a_cugb.getProjectCode().equals("SCI")) {
				ws_a_cugb_SCI_v = getDataList(a_cugb);
				ws_a_cugb_SCI_unit = a_cugb.getUnit();
				ws_a_cugb_SCI_project = a_cugb.getProjectName();
				ws_a_cugb_SCI_update = a_cugb.getUpdateTime();
			}
			if (a_cugb.getProjectCode().equals("BZX")) {
				ws_a_cugb_BZX_v = getDataList(a_cugb);
				ws_a_cugb_BZX_unit = a_cugb.getUnit();
				ws_a_cugb_BZX_project = a_cugb.getProjectName();
				ws_a_cugb_BZX_update = a_cugb.getUpdateTime();
			}
		}
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(2);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		request.setAttribute("ws_a_cugb_k", ws_a_cugb_k);
		request.setAttribute("ws_a_cugb_SCI_v", ws_a_cugb_SCI_v);
		request.setAttribute("ws_a_cugb_SCI_unit", ws_a_cugb_SCI_unit);
		request.setAttribute("ws_a_cugb_SCI_project", ws_a_cugb_SCI_project);
		request.setAttribute("ws_a_cugb_SCI_update", ws_a_cugb_SCI_update);
		request.setAttribute("ws_a_cugb_BZX_v", ws_a_cugb_BZX_v);
		request.setAttribute("ws_a_cugb_BZX_unit", ws_a_cugb_BZX_unit);
		request.setAttribute("ws_a_cugb_BZX_project", ws_a_cugb_BZX_project);
		request.setAttribute("ws_a_cugb_BZX_update", ws_a_cugb_BZX_update);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/fmzlSta.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String fmzlSta(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/fmzlSta.jsp";
		List<ws_a_cugb> ws_a_cugbList = kjcService.getCugb("CGZH");
		List<String> ws_a_cugb_k = getYearList();
		List<Float> ws_a_cugb_ZLS_v = new ArrayList<Float>();
		List<Float> ws_a_cugb_FMZ_v = new ArrayList<Float>();
		String ws_a_cugb_ZLS_unit = "";
		String ws_a_cugb_FMZ_unit = "";
		String ws_a_cugb_ZLS_project = "";
		String ws_a_cugb_FMZ_project = "";
		String ws_a_cugb_ZLS_update = "";
		String ws_a_cugb_FMZ_update = "";
		for (int i = 0; i < ws_a_cugbList.size(); i++) {
			ws_a_cugb a_cugb = ws_a_cugbList.get(i);
			if (a_cugb.getProjectCode().equals("ZLS")) {
				ws_a_cugb_ZLS_v = getDataList(a_cugb);
				ws_a_cugb_ZLS_unit = a_cugb.getUnit();
				ws_a_cugb_ZLS_project = a_cugb.getProjectName();
				ws_a_cugb_ZLS_update = a_cugb.getUpdateTime();
			}
			if (a_cugb.getProjectCode().equals("FMZ")) {
				ws_a_cugb_FMZ_v = getDataList(a_cugb);
				ws_a_cugb_FMZ_unit = a_cugb.getUnit();
				ws_a_cugb_FMZ_project = a_cugb.getProjectName();
				ws_a_cugb_FMZ_update = a_cugb.getUpdateTime();
			}
		}
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(3);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		request.setAttribute("ws_a_cugb_k", ws_a_cugb_k);
		request.setAttribute("ws_a_cugb_ZLS_v", ws_a_cugb_ZLS_v);
		request.setAttribute("ws_a_cugb_ZLS_unit", ws_a_cugb_ZLS_unit);
		request.setAttribute("ws_a_cugb_ZLS_project", ws_a_cugb_ZLS_project);
		request.setAttribute("ws_a_cugb_ZLS_update", ws_a_cugb_ZLS_update);
		request.setAttribute("ws_a_cugb_FMZ_v", ws_a_cugb_FMZ_v);
		request.setAttribute("ws_a_cugb_FMZ_unit", ws_a_cugb_FMZ_unit);
		request.setAttribute("ws_a_cugb_FMZ_project", ws_a_cugb_FMZ_project);
		request.setAttribute("ws_a_cugb_FMZ_update", ws_a_cugb_FMZ_update);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/pingtaiList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String pingtaiList(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/pingtaiList.jsp";
		List<ws_files> pingtaiList = kjcService.getCugbData("1");
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(4);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		JSONArray pingtaiJson = JSONArray.fromObject(pingtaiList);
		request.setAttribute("pingtaiList", pingtaiList);
		request.setAttribute("pingtaiJson", pingtaiJson);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/huojiangList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String huojiangList(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/huojiangList.jsp";
		List<ws_award> awardList = kjcService.getAward();
		List<ws_files> getCugbData = kjcService.getCugbData();
		ws_files ws_files = getCugbData.get(5);
		String title = ws_files.getName();
		String type = ws_files.getType();
		String addTime = ws_files.getAddTime();
		JSONArray awardJson = JSONArray.fromObject(awardList);
		request.setAttribute("awardList", awardList);
		request.setAttribute("awardJson", awardJson);
		request.setAttribute("title", title);
		request.setAttribute("type", type);
		request.setAttribute("addTime", addTime);
		return toPage;
	}

	@RequestMapping(value = "/kyxm/fund.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String kyxmFund(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/kyxm/fundList.html";
		return toPage;
	}

	@RequestMapping(value = "/kyxm/nstProject.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String kyxmNstProject(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/kyxm/nstProject.html";
		return toPage;
	}

	@RequestMapping(value = "/kyxm/yxdb.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String kyxmYxdb(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/kyxm/yxdb.html";
		return toPage;
	}

	@RequestMapping(value = "/xslw/sjlw.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String xslwSjlw(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/xslw/sjlw.html";
		return toPage;
	}

	@RequestMapping(value = "/xslw/yxdb.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String xslwYxdb(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/xslw/yxdb.html";
		return toPage;
	}

	@RequestMapping(value = "/xslw/paperList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String xslwPaperList(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/xslw/paperList.html";
		return toPage;
	}

	@RequestMapping(value = "/kyxm/fundList.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String kyxmFundList(HttpServletRequest request) {
		String toPage = "forward:/ws/kjc/kyxm/fundList.html";
		return toPage;
	}

	@RequestMapping(value = { "/kjcQueryList.do" }, method = {RequestMethod.POST, RequestMethod.GET })
	public void kjcQueryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		response.setHeader("Access-Control-Allow-Origin", "*");
		String jsonString = getRequestJsonString(request, charset);
		ws_a_cugb_dept_detail bean = (ws_a_cugb_dept_detail) JSONObject.toBean(JSONObject.fromObject(jsonString),
				ws_a_cugb_dept_detail.class);
		List<ws_a_cugb_dept> query = this.kjcService.queryList(bean.getFlagCode(), bean.getTypeCode(), bean.getYear());
		JSONArray json = JSONArray.fromObject(query);
		JSONObject reJson = new JSONObject();
		reJson.put("kjcQueryList", json);
		response.getWriter().print(reJson.toString());
	}

	@RequestMapping("/kjcQuery.do")
	public void kjcQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		response.setHeader("Access-Control-Allow-Origin", "*");
		String jsonString = getRequestJsonString(request, charset);
		ws_a_cugb_dept_detail bean = (ws_a_cugb_dept_detail) JSONObject.toBean(JSONObject.fromObject(jsonString),
				ws_a_cugb_dept_detail.class);
		int total = this.kjcService.queryTotal(bean.getPerPage(), bean.getFlagCode(), bean.getDeptCode(),
				bean.getTypeCode(), bean.getYear());
		int maxPage = total / Integer.parseInt(bean.getPerPage()) + 1;
		List<ws_a_cugb_dept_detail> query = this.kjcService.query(bean.getCurPage(), bean.getPerPage(),
				bean.getFlagCode(), bean.getDeptCode(), bean.getTypeCode(), bean.getYear());
		JSONArray json = JSONArray.fromObject(query);
		JSONObject reJson = new JSONObject();
		reJson.put("kjcQuery", json);
		reJson.put("maxPage", maxPage);
		reJson.put("total", total);
		response.getWriter().print(reJson.toString());
	}

	public static String getRequestJsonString(HttpServletRequest request, String charset) throws IOException {
		String submitMehtod = request.getMethod();
		if (submitMehtod.equals("GET")) {
			return new String(request.getQueryString().getBytes("GBK"), charset).replaceAll("%22", "\"");
		}
		byte[] buffer = getRequestPostBytes(request);
		return new String(buffer, charset);
	}

	public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte[] buffer = new byte[contentLength];
		for (int i = 0; i < contentLength;) {
			int readlen = request.getInputStream().read(buffer, i, contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

	@RequestMapping(value = "/fmzl/zhzl.do", method = RequestMethod.GET)
	public String fmzlYxdb(@RequestParam("patent") String patent, Model model) {
		String toPage = "forward:/ws/kjc/fmzl/patentList.jsp";
		List<Patent> list = kjcService.getPatentByCategory(patent);
		ws_files file = kjcService.getCugbData().get(3);
		JSONArray awardJson = JSONArray.fromObject(list);
		model.addAttribute("awardJson", awardJson);
		model.addAttribute("title", file.getName());
		model.addAttribute("type", patent);
		model.addAttribute("addTime", file.getAddTime());
		return toPage;
	}
}
