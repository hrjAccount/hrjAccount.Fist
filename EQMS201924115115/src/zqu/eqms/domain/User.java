package zqu.eqms.domain;


/**
 * 用户类
 * @author jack88
 * 
 */


public class User {
	private String EmpNum;  // 员工编号
	private String EmpName; //员工姓名
	private String EmpPass; // 员工密码
	private String EmpPhone; // 员工电话
	private String SvONot; // 是否为主管
	private String DepaNum; // 部门编号
	public User(String empNum, String empName, String empPass, String empPhone, String svONot, String depaNum) {
		super();
		EmpNum = empNum;
		EmpName = empName;
		EmpPass = empPass;
		EmpPhone = empPhone;
		SvONot = svONot;
		DepaNum = depaNum;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpNum() {
		return EmpNum;
	}
	public void setEmpNum(String empNum) {
		EmpNum = empNum;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpPass() {
		return EmpPass;
	}
	public void setEmpPass(String empPass) {
		EmpPass = empPass;
	}
	public String getEmpPhone() {
		return EmpPhone;
	}
	public void setEmpPhone(String empPhone) {
		EmpPhone = empPhone;
	}
	public String getSvONot() {
		return SvONot;
	}
	public void setSvONot(String svONot) {
		SvONot = svONot;
	}
	public String getDepaNum() {
		return DepaNum;
	}
	public void setDepaNum(String depaNum) {
		DepaNum = depaNum;
	}
	@Override
	public String toString() {
		return EmpNum;
	}
	
	
	
	
}