package com.rcg.com.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Crypt 
{
	 	private static final String encryptionKey           = System.getenv("RCYC_KEY_VALUE");
	    private static final String characterEncoding       = "UTF-8";
	    private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
	    private static final String aesEncryptionAlgorithem = "AES";


	    /**
	     * Method for Encrypt Plain String Data
	     * @param plainText
	     * @return encryptedText
	     */
	    public static String encrypt(String plainText) {
	        String encryptedText = "";
	        try {
	            Cipher cipher   = Cipher.getInstance(cipherTransformation);
	            byte[] key      = encryptionKey.getBytes("UTF-8");
	            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
	            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
	            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
	            Base64.Encoder encoder = Base64.getEncoder();
	            encryptedText = encoder.encodeToString(cipherText);

	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        return encryptedText;
	    }


	    /**
	     * Method For Get encryptedText and Decrypted provided String
	     * @param encrypted
	     * @return decryptedText
	     *
	     */


	    public static String decrypt(String encrypted) {
	        String decryptedText = "";
	        try {
	            decryptedText=decryptE(encrypted);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }


	    private static String decryptE(String encrypted) throws Exception{
	        String decryptedText = "";
	        Cipher cipher = Cipher.getInstance(cipherTransformation);
	        byte[] key = encryptionKey.getBytes(characterEncoding);
	        SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
	        IvParameterSpec ivparameterspec = new IvParameterSpec(key);
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
	        Base64.Decoder decoder = Base64.getDecoder();
	        byte[] cipherText = decoder.decode(encrypted.getBytes("UTF8"));
	        decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
	        return decryptedText;
	    }
	    
	    
	/*
	 * public static void main(String args[]) {
	 * System.out.println("URL       : "+Crypt.encrypt(
	 * "jdbc:mysql://192.168.15.245:3306/ritzkidz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
	 * )); System.out.println("Username  : "+Crypt.encrypt("root"));
	 * System.out.println("Passworrd : "+Crypt.encrypt("E2i7SfWKMmHKofcC"));
	 * System.out.println(" KEY : "+Crypt.encrypt("ABC123ABC123ABC1"));
	 * 
	 * 
	 * }
	 */
	 
}
