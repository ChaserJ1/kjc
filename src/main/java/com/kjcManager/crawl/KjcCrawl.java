package com.kjcManager.crawl;

import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kjcManager.util.CrawlUtil;

public class KjcCrawl {
	public static final String kjcManagerUrl = "https://www1.cugb.edu.cn/research/";
	public static boolean getKjc(String curPage, String flagCode, String deptCode, String typeCode, String year) throws Exception {
		boolean res = false;
		String paperUrl  = kjcManagerUrl + "paperList.action?curPage="+curPage+"&year="+year+"&deptCode="+deptCode+"&paperTypeCode="+typeCode;
		String fundUrl  = kjcManagerUrl + "fundList.action?curPage="+curPage+"&year="+year+"&deptCode="+deptCode+"&fundTypeCode="+typeCode;
		String flagName = "",deptName,typeName = "",checkId,info = "";
		Map<String, String> departMap = KjcUtils.departMap();
		deptName = departMap.get(deptCode);
		if(flagCode.equals(KjcUtils.FLAG_CODE_LW)){
			flagName = KjcUtils.FLAG_NAME_LW;
			if(typeCode.equals(KjcUtils.TYPE_CODE_BKLW)){
				typeName = KjcUtils.TYPE_NAME_BKLW;
			}else if(typeCode.equals(KjcUtils.TYPE_CODE_QBLW)){
				typeName = KjcUtils.TYPE_NAME_QBLW;
			}
		}else if(flagCode.equals(KjcUtils.FLAG_CODE_JJ)){
			flagName = KjcUtils.FLAG_NAME_JJ;
			if(typeCode.equals(KjcUtils.TYPE_CODE_QNJJ)){
				typeName = KjcUtils.TYPE_NAME_QNJJ;
			}else if(typeCode.equals(KjcUtils.TYPE_CODE_QTJJ)){
				typeName = KjcUtils.TYPE_NAME_QTJJ;
			}else if(typeCode.equals(KjcUtils.TYPE_CODE_RCJJ)){
				typeName = KjcUtils.TYPE_NAME_RCJJ;
			}else if(typeCode.equals(KjcUtils.TYPE_CODE_ZDJJ)){
				typeName = KjcUtils.TYPE_NAME_ZDJJ;
			}else if(typeCode.equals(KjcUtils.TYPE_CODE_MSJJ)){
				typeName = KjcUtils.TYPE_NAME_MSJJ;
			}
		}
		System.out.println(flagCode+"("+flagName+")-"+typeCode+"("+typeName+")-"+deptCode+"("+deptName+")-"+year+"年-"+"第"+curPage+"页");
		try {
			CrawlUtil.trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			Document doc = null;
			if(flagCode.equals(KjcUtils.FLAG_CODE_LW)){
				doc = Jsoup.connect(paperUrl).ignoreContentType(true).post();
			}else if(flagCode.equals(KjcUtils.FLAG_CODE_JJ)){
				doc = Jsoup.connect(fundUrl).ignoreContentType(true).post();
			}
//			System.out.println(doc);
			Elements elementsByClass = doc.getElementsByClass("list_title");
			Elements els = elementsByClass.select("table");
			Elements ele = new Elements();
			for (Element el : els) {
//				System.out.println(el);
				ele = el.select("table").select("tbody").select("tr").select("td");
				String eleStr = ele.toString();
				checkId = eleStr.split("\">")[1].split("、")[0];
				if(!KjcJdbc.checkDataFromDB(flagCode,deptCode,typeCode,checkId,year)){
					System.out.println("checkId:"+checkId);
					String[] infoTempSplit = eleStr.split(">");
					//for (int i = 0; i < infoTempSplit.length; i++) {
					//	System.out.println(infoTempSplit[i]);
					//}
					int infoTempLen = infoTempSplit.length;
					if(infoTempLen>2){
						if(flagCode.equals(KjcUtils.FLAG_CODE_LW)){
							info= infoTempSplit[2].split("<")[0];
						}else if(flagCode.equals(KjcUtils.FLAG_CODE_JJ)){
							info= infoTempSplit[1].split("<")[0]+infoTempSplit[2].split("<")[0];
						}
					}else{
						if(flagCode.equals(KjcUtils.FLAG_CODE_LW)){
							info= infoTempSplit[1].split("<")[0];
						}else if(flagCode.equals(KjcUtils.FLAG_CODE_JJ)){
							info= infoTempSplit[0].split("<")[0]+infoTempSplit[1].split("<")[0];
						}
					}
					System.out.println("info:"+info);
					System.out.println("year:"+year);
					KjcJdbc.writeContextIntoDB(flagCode, flagName, deptCode, deptName, typeCode, typeName, checkId, info, year, curPage);
					res = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		KjcJdbc.connectionDB();
		Map<String, String> departMap = KjcUtils.departMap();
		Set<String> keySet = departMap.keySet();
		String yearCodeLw = KjcUtils.YEAR_CODE_LW;
		String yearCodeJj = KjcUtils.YEAR_CODE_JJ;
		int beginYearLw = Integer.parseInt(yearCodeLw.split("~")[0]);
		int endYearLw = Integer.parseInt(yearCodeLw.split("~")[1]);
		int beginYearJj = Integer.parseInt(yearCodeJj.split("~")[0]);
		int endYearJj = Integer.parseInt(yearCodeJj.split("~")[1]);
		for (String deptCode : keySet) {
			for (int i = beginYearLw; i <= endYearLw; i++) {
				int j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_LW, deptCode, KjcUtils.TYPE_CODE_QBLW, i+"")){
						break;
					}
					j++;
				}
				j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_LW, deptCode, KjcUtils.TYPE_CODE_BKLW, i+"")){
						break;
					}
					j++;
				}
			}
			for (int i = beginYearJj; i <= endYearJj; i++) {
				int j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_JJ, deptCode, KjcUtils.TYPE_CODE_QNJJ, i+"")){
						break;
					}
					j++;
				}
				j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_JJ, deptCode, KjcUtils.TYPE_CODE_QTJJ, i+"")){
						break;
					}
					j++;
				}
				j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_JJ, deptCode, KjcUtils.TYPE_CODE_RCJJ, i+"")){
						break;
					}
					j++;
				}
				j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_JJ, deptCode, KjcUtils.TYPE_CODE_ZDJJ, i+"")){
						break;
					}
					j++;
				}
				j = 1;
				while(true){
					if(!getKjc(j+"", KjcUtils.FLAG_CODE_JJ, deptCode, KjcUtils.TYPE_CODE_MSJJ, i+"")){
						break;
					}
					j++;
				}
			}
		}
	}
	
	static HostnameVerifier hv = new HostnameVerifier() {
		@Override
		public boolean verify(String urlHostName, SSLSession session) {
			System.out.println("Warning: URL Host: " + urlHostName + " vs. "
					+ session.getPeerHost());
			return false;
		}
	};
}
