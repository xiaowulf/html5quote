package com.venus.finance.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString().toUpperCase();
	}
	public static void main(String [] args){
		String s = "豆一                      1603       3493       3497       3483       3492       3483       3489          9          6            78          1234            -6              272.15";
		String [] s2 = s.split(" ");
		s2.toString();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s2.length; i++){
			if(null!=s2[i]&&!"".equals(s2[i])){
				sb.append(s2[i]).append(",");
			}
		}
		System.out.println(sb);
	}

}
