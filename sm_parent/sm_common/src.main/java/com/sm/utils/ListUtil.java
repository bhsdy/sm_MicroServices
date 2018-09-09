package com.sm.utils;

import java.util.HashSet;
import java.util.List;

/**
 * List集合相关工具类
 * @description 
 *
 * @author chenyang
 * @createDate 2018年7月5日 上午8:52:52
 */
public class ListUtil {

	/**
	 * List去重
	 * @param list
	 * @return
	 *
	 * @author chenyang
	 * @createDate 2018年7月5日 上午8:59:02
	 */
	public static List removeDuplicate(List list) {   
	    HashSet h = new HashSet(list);   
	    list.clear();   
	    list.addAll(h);   
	    
	    return list;   
	}   
}
