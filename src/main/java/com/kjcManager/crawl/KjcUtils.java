package com.kjcManager.crawl;

import java.util.HashMap;
import java.util.Map;

public class KjcUtils {
	public static final String YEAR_CODE_LW = "2012~2017";
	public static final String YEAR_CODE_JJ = "2013~2021";
	
	public static final String FLAG_CODE_LW = "paper";
	public static final String FLAG_CODE_JJ = "fund";
	
	public static final String FLAG_NAME_LW = "论文";
	public static final String FLAG_NAME_JJ = "基金";
	
	public static final String TYPE_CODE_QBLW = "null";
	public static final String TYPE_CODE_BKLW = "2";
	public static final String TYPE_CODE_QBJJ = "0";
	public static final String TYPE_CODE_QNJJ = "1";
	public static final String TYPE_CODE_QTJJ = "2";
	public static final String TYPE_CODE_RCJJ = "3";
	public static final String TYPE_CODE_ZDJJ = "4";
	public static final String TYPE_CODE_MSJJ = "5";
	
	public static final String TYPE_NAME_QBLW = "全部论文";
	public static final String TYPE_NAME_BKLW = "榜刊论文";
	public static final String TYPE_NAME_QBJJ = "全部基金";
	public static final String TYPE_NAME_QNJJ = "青年基金";
	public static final String TYPE_NAME_QTJJ = "其他基金";
	public static final String TYPE_NAME_RCJJ = "人才基金";
	public static final String TYPE_NAME_ZDJJ = "重点基金";
	public static final String TYPE_NAME_MSJJ = "面上基金";

	public static Map<String,String> departMap(){
		Map<String,String> map = new HashMap<String, String>();
//		map.put("30000", "教学单位");
		map.put("30100", "地科学院");
		map.put("30200", "工程学院");
		map.put("30300", "材料学院");
		map.put("30400", "信工学院");
		map.put("30500", "水环学院");
		map.put("30600", "能源学院");
		map.put("30700", "经管学院");
		map.put("30800", "外语学院");
		map.put("30900", "珠宝学院");
		map.put("31000", "地信学院");
		map.put("31100", "海洋学院");
		map.put("31200", "土科学院");
		map.put("31600", "继教学院");
		map.put("31800", "马列学院");
		map.put("31900", "数理学院");
		map.put("50100", "科研院");
		return map;
	}
}
