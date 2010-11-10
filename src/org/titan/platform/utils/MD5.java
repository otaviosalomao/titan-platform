package org.titan.platform.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static MessageDigest digest;

	public static String md5(byte[] bytes) throws NoSuchAlgorithmException {
		if (digest == null) {
			digest = java.security.MessageDigest.getInstance("MD5");
		}
		digest.update(bytes);
		BigInteger bigInt = new BigInteger(1, digest.digest());
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		
		return hashtext;
	}
}
