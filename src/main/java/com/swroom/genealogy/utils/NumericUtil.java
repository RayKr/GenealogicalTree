package com.swroom.genealogy.utils;

/**
 * 数字工具类
 * Created by jingz on 2017/2/7.
 */
public class NumericUtil {

    private static final String[] digits = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
    private static final String[] radices = new String[] { "", "十", "百", "千" };
    private static final String[] bigRadices = new String[] { "", "万", "亿", "万" };

    /**
     * 阿拉伯数字转中文大写
     * @param currencyDigits 阿拉伯数字
     * @return 中文大写
     */
    public static String arabicToNumeric(String currencyDigits) {
        String integral = null; 				// 整数部分
        String decimal = null; 					// 小数部分
        String outputCharacters = null; 		// 最终转换输出结果
        String d = null;
        int zeroCount = 0, p = 0, quotient = 0, modulus = 0;
        currencyDigits = currencyDigits.replace("/,/g", "");	// 删除数字中的逗号,
        currencyDigits = currencyDigits.replace("/^0+/", "");	// 删除数字左边的0
        String[] parts = currencyDigits.split("\\.");			// 拆分数字中的整数与小数部分
        if (parts.length > 1) {
            integral = parts[0];
            decimal = parts[1];
            if (decimal.length() > 2) {							// 如果小数部分长度大于2，四舍五入，保留两位小数
                long dd = Math.round(Double.parseDouble("0."+decimal) * 100) ;
                decimal = Long.toString(dd);
            }
        }else{
            integral = parts[0];
            decimal = "0";
        }
        outputCharacters = "";
        if (Double.parseDouble(integral) > 0) {
            zeroCount = 0;
            for (int i = 0; i < integral.length(); i++) {
                p = integral.length() - i - 1;
                d = integral.substring(i, i + 1);
                quotient = p / 4;
                modulus = p % 4;
                if (d.equals("0")){
                    zeroCount++;
                }else{
                    if(zeroCount > 0)outputCharacters += digits[0];
                    zeroCount = 0;
                    outputCharacters += digits[Integer.parseInt(d)] + radices[modulus];
                }
                if(modulus == 0 && zeroCount < 4)outputCharacters += bigRadices[quotient];
            }
        }
        if(Double.parseDouble(decimal) > 0) for(int i = 0; i < decimal.length(); i++)d = decimal.substring(i,i+1);
        return outputCharacters;
    }

}
