package com.util;

// Md5.java
// $Id: Md5.java,v 1.4 1999/12/06 13:13:58 ylafon Exp $
// (c) COPYRIGHT MIT and INRIA, 1996.
// Please first read the full copyright statement in file COPYRIGHT.html
// http://www.jq-school.com
// Download by http://www.codefans.net
//		Add model hmac_Md5 ( String text , String key ) ;
//package md5java ;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

public  class MD5 {
	private static Logger logger = Logger.getLogger(MD5.class.getName());
	/**
	 * @sm 加密算法
	 * @author 李飞
	 * @param str 需要加密的参数
	 * @return String
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str)  {
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符串
			String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newstr;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.getMessage();
		}
		return null;
	}
}
