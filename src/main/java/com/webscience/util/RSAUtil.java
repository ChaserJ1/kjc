package com.webscience.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Writer;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class RSAUtil
{
  public static final String KEY_ALGORITHM = "RSA";
  private static final int KEY_SIZE = 4096;
  private static final String PUBLIC_KEY = "xiaoxiaorenzhe";
  private static final String PRIVATE_KEY = "dadapangzi";

  public static Map<String, Object> initKey()
    throws Exception
  {
    KeyPairGenerator keyPairGenerator = 
      KeyPairGenerator.getInstance("RSA");

    keyPairGenerator.initialize(4096);

    KeyPair keyPair = keyPairGenerator.generateKeyPair();

    RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();

    RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();

    Map keyMap = new HashMap();
    keyMap.put("xiaoxiaorenzhe", publicKey);
    keyMap.put("dadapangzi", privateKey);
    return keyMap;
  }

  public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
    throws Exception
  {
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(1, privateKey);
    return cipher.doFinal(data);
  }

  public static byte[] encryptByPublicKey(byte[] data, byte[] key)
    throws Exception
  {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

    PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(1, pubKey);
    return cipher.doFinal(data);
  }

  public static byte[] decryptByPrivateKey(byte[] data, byte[] key)
    throws Exception
  {
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(2, privateKey);
    return cipher.doFinal(data);
  }

  public static byte[] decryptByPublicKey(byte[] data, byte[] key)
    throws Exception
  {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

    PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(2, pubKey);
    return cipher.doFinal(data);
  }

  public static byte[] getPrivateKey(Map<String, Object> keyMap)
  {
    Key key = (Key)keyMap.get("dadapangzi");
    return key.getEncoded();
  }

  public static byte[] getPublicKey(Map<String, Object> keyMap)
    throws Exception
  {
    Key key = (Key)keyMap.get("xiaoxiaorenzhe");
    return key.getEncoded();
  }

  public static String keyOper(String pathName, String operType, String key)
    throws IOException
  {
    if (operType.equals("read")) {
      BufferedReader bReader = new BufferedReader(new InputStreamReader(
        new FileInputStream(new File(pathName)), "UTF-8"));
      StringBuilder sb = new StringBuilder();
      String s = "";
      while ((s = bReader.readLine()) != null) {
        sb.append(s + "\n");
      }
      bReader.close();
      String str = sb.toString();
      return str;
    }
    Writer out = new FileWriter(new File(pathName));
    out.write(key);
    out.close();
    return "";
  }

  public static void main(String[] args)
    throws Exception
  {
    String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEApdPNzs/yvJkYui7iXXyHoa3aTWNurZh8OTHEP4uMecmMzTXf+Tf1iSLijin6YYtcEzIMulNufMzqzvWqZ8H1Own4MKv83E0uPBsV1oWYHOEz/MrdeSNlIGepxTcVkZZmnWDau5rUrj/dv+CpAuMbSQ+UZhOdam5SxxAteRsU2JbVBI8WEXmQ/zGuBKWD4ahJfpNhrD6bZB04IIBB0+OM0sd5D8vm0lKb+u6jI+FVQ9qgn1md7gBsnYy+1N6Mo/E8mbrM/Y4qKJrFm2JGJR9fY5Izxtf85sEzCMDitk7x6rOgbC7gvOztBhg5e2MKEbz/RlE4ZjDmS8qzIWoQJKNFRgoLnkIwA59qpDxSwfPZkCINwe2cU72qjufTblibBiW0yqUsbQBHYEQI73XXmTDGRbuJWNp+G3LLhtPRTs+rjoNmx3mNawqgq3h1oIEYrBDja1Z24Jr0d3bWdJZe5x8nVHEeBhcSgTJFyySzYRtBDeGLKedWSTxJns2axEKs3vP/k1nyPyZItPFifpibv0nfmiRer1tO0GToFbsmFTSKGHdTG98xr0EEQQRk2O1/5sUBdqoOHLV8ba2si5/5ztpZ/jxF0iTiZbSJAMMAZZaukMmD9MDP4PVwylZatXXdWykX0qiSZ0uP6XvsL7dmJAldsXeJ9eDfLSm/cgz1+yzLNAcCAwEAAQ==";
    String jsonStr = "abc123";
    byte[] json = encryptByPublicKey(jsonStr.getBytes(), 
    Base64.decode(publicKey));
    String json1 = Base64.encode(json);
    System.out.println("加密后的数据：" + json1);
   String privateKey = "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";
    byte[] decode2 = decryptByPrivateKey(Base64.decode(json1), 
    Base64.decode(privateKey));
    System.out.println(new String(decode2, "UTF-8"));
  }
}