package MD5;

import java.security.MessageDigest;

/**
 * md5加密
 *
 * 固定加盐,使用字符串的hash值
 */
public class MD5Encoder {
	
	public static String encode(String string)  {
	    try {
	        byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
	        StringBuilder hex = new StringBuilder(hash.length * 2);
	        for (byte b : hash) {
	            if ((b & 0xFF) < 0x10) {
	                hex.append("0");
	            }
	            hex.append(Integer.toHexString(b & 0xFF));
	        }
	        return hex.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return null;
	    
	}

	public static void main(String[] args) {
		String password = encode("123456");
		System.out.println(password);


	}
}
