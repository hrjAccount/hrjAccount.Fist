package zqu.eqms.domain;

/**
 * 部门类
 * @author jack88
 *
 */

public class Depa {
	private static String DepaNum;  //部门代号
	private static String DepaName;  //部门名称
	private static String EmpNum; //主管编号
	public Depa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Depa(String DepaNum, String DepaName, String EmpNum) {
		super();
		this.DepaNum = DepaNum;
		this.DepaName = DepaName;
		this.EmpNum = EmpNum;
	}


	public static String getDepaNum() {
		return DepaNum;
	}


	public static void setDepaNum(String depaNum) {
		DepaNum = depaNum;
	}


	public static String getDepaName() {
		return DepaName;
	}


	public static void setDepaName(String depaName) {
		DepaName = depaName;
	}


	public static String getEmpNum() {
		return EmpNum;
	}


	public static void setEmpNum(String empNum) {
		EmpNum = empNum;
	}


	@Override
	public String toString() {
		return DepaNum;
	}


	
	

	
}
