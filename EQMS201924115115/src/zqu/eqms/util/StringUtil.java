package zqu.eqms.util;


/**
 * 判断字符串是否为空
 * @author jack88
 *
 */
public class StringUtil {
	
	
	// 判断字符串为空
	public static boolean IsEmpty(String s) {
		if(s==null || "".equals(s.trim())) {
			return true;
		}else {
			return false;
		}
	}
	//
	
	
	//判断字符串不为空
	public static boolean IsNotEmpty(String s) {
		if(s!=null && !"".equals(s.trim())) {
			return true;
		}else {
			return false;
		}
	}
	//

}
