package com.kjcManager.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESUtil {
	// 算法名称
	public static final String KEY_ALGORITHM = "DES";
	// 算法名称/加密模式/填充方式
	// DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
	public static final String CIPHER_ALGORITHM = "DESede/CBC/PKCS5Padding";

	public static String key = "FHGT4KHVJKVKV2KHCTBM";

	/**
	 * 生成密钥key对象
	 * 
	 * @param KeyStr
	 *            密钥字符串
	 * @return 密钥对象
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws Exception
	 */
	private static SecretKey keyGenerator(String keyStr) throws Exception {
		byte input[] = HexString2Bytes(keyStr);
		DESKeySpec desKey = new DESKeySpec(input);
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(desKey);
		return securekey;
	}

	private static int parse(char c) {
		if (c >= 'a')
			return (c - 'a' + 10) & 0x0f;
		if (c >= 'A')
			return (c - 'A' + 10) & 0x0f;
		return (c - '0') & 0x0f;
	}

	// 从十六进制字符串到字节数组转换
	public static byte[] HexString2Bytes(String hexstr) {
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			char c0 = hexstr.charAt(j++);
			char c1 = hexstr.charAt(j++);
			b[i] = (byte) ((parse(c0) << 4) | parse(c1));
		}
		return b;
	}

	/**
	 * 加密数据
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return 加密后的数据
	 */
	public static String encrypt(String data, String key) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 现在，获取数据并加密
		// 正式执行加密操作
		byte[] results = cipher.doFinal(data.getBytes());
		return Base64.encodeBase64String(results);
	}

	/**
	 * 解密数据
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @return 解密后的数据
	 */
	public static String decrypt(String data, String key) throws Exception {

		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key.getBytes());
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		// 现在，获取数据并解密
		// 正式执行解密操作
		return new String(cipher.doFinal(Base64.decodeBase64(data)));
	}

	public static void main(String[] args) throws Exception {
		// String url =
		// "jdbc:mysql://127.0.0.1:3306/kjcManager?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		// String username = "kjcManager";
		// String password = "XXX";
		// System.out.println("url: " + url);
		// System.out.println("username: " + username);
		// System.out.println("password: " + password);
		// String e_url = encrypt(url, key);
		// String e_username = encrypt(username, key);
		// String e_password = encrypt(password, key);
		// System.out.println("加密后url: " + e_url);
		// System.out.println("加密后username: " + e_username);
		// System.out.println("加密后password: " + e_password);

		// String url =
		// "jdbc:mysql://localhost:3306/wsuwb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		// String username = "root";
		// String password = "MnVbzmB0Onka";
		// String url =
		// "jdbc:mysql://8.141.65.225:3306/kjcManager?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		String url = "jdbc:mysql://192.168.95.116:3306/webscience_analyze?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		String username = "root";
		String password = "Lw@admin123";

//		System.out.println("url: " + url);
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
		String e_url = encrypt(url, key);
		String e_username = encrypt(username, key);
		String e_password = encrypt(password, key);
		System.out.println("加密后url: " + e_url);
		System.out.println("加密后username: " + e_username);
		System.out.println("加密后password: " + e_password);
		String d_url = decrypt(e_url, key);
		String d_username = decrypt(e_username, key);
		String d_password = decrypt(e_password, key);
//		System.out.println("解密后url: " + d_url);
//		System.out.println("解密后username: " + d_username);
//		System.out.println("解密后password: " + d_password);
	}
}