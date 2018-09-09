package com.sm.utils.number;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Percent {

	/**
	 * double转百分比
	 *
	 * @param num
	 * @param total
	 * @param scale
	 * @return
	 *
	 * @author HuangShaoFeng
	 * @createDate 2017年7月25日
	 */
	public static String percentum(double num, double total, int scale){  
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();  
        //设置精确几位小数  
        df.setMaximumFractionDigits(scale);  
        //四舍五入  
        df.setRoundingMode(RoundingMode.HALF_UP);  
        double accuracy_num = num / total * 100;  
        return df.format(accuracy_num)+"%";  
	}
	
}
