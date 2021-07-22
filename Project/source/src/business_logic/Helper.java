package business_logic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author Dom
 *
 */
public class Helper {
		
	
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PHONE_NUMBER_PATTER ="0\\d{9,10}";
	/**
	 * @param password
	 * @return Trả về một chuỗi kí tự sau khi đã mã hóa.
	 * @throws NoSuchAlgorithmException nếu không có thuật toán
	 * @throws SQL nếu không truy vấn được dữ liệu
	 */
	public static String MD5encrypt(String password){            
        StringBuffer sb = new StringBuffer();
        try{ 
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            for (int i = 0; i < thedigest.length; i++) {
              sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
        	ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
        	ex.printStackTrace();
        }
        return sb.toString();
    }
	
	// default return false when email is invalid 
	/**
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {
		if (!email.matches(EMAIL_PATTERN)) return true;
		return false;
	}
	
	/**
	 * @param sdt
	 * @return
	 */
	public static boolean validatePhoneNumber(String sdt) {
		//start with 0, length 10 -> 11 letter
		if(!sdt.trim().matches(PHONE_NUMBER_PATTER)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(Helper.MD5encrypt("20160952"));
		
	}
}
