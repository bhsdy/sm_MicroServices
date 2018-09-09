package com.sm.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 *
 * @description 
 *
 */
public class GenericsUtils {

	private GenericsUtils() {
	}

	/**
	 * 获取继承链中泛型(父类没有，索引父类的父类，顶多线上索引4层)
	 * @param clazz
	 * @return
	 */
	public static Class getInheritChainGenricType(Class clazz){
		Class genricType = getSuperClassGenricType(clazz,0);
		if (genricType != null) {
			
			return genricType;
		}
		
		Class super1 = clazz.getSuperclass();
		genricType = getSuperClassGenricType(super1,0);
		if (genricType != null) {
			
			return genricType;
		}
		
		Class super2 = clazz.getSuperclass();
		genricType = getSuperClassGenricType(super2,0);
		if (genricType != null) {
			
			return genricType;
		}
		
		Class super3 = clazz.getSuperclass();
		genricType = getSuperClassGenricType(super3,0);
		if (genricType != null) {
			
			return genricType;
		}

		return genricType;
	}
	
	
	/**
	 * 超早某个类的父类的泛型
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return null;
		}
		
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			
			return Object.class;
		}
		return (Class) params[index];
	}
}
