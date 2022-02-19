package zqu.eqms.domain;


/**
 * 设备类
 * @author jack88
 *
 */
public class Equi {
	
	private String EquNum; //设备编号
	private String EquName; //设备名称
	private String EquSpc; //设备规格
	private String EquPri; //设备价格
	private String BuyTime; //购买日期
	private String EquLoc; //设备存放地点
	private String EmpNum; //设备负责人
	public Equi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equi(String equNum,String equName,String equSpc,String equPri, String buyTime, String equLoc, String empNum) {
		
		this.EquNum = equNum;
		this.EquName =equName;
		this.EquSpc = equSpc;
		this.EquPri = equPri;
		this.BuyTime = buyTime;
		this.EquLoc = equLoc;
		this.EmpNum = empNum;
		
	}
	public String getEquNum() {
		return EquNum;
	}
	public void setEquNum(String equNum) {
		EquNum = equNum;
	}
	public String getEquName() {
		return EquName;
	}
	public void setEquName(String equName) {
		EquName = equName;
	}
	public String getEquSpc() {
		return EquSpc;
	}
	public void setEquSpc(String equSpc) {
		EquSpc = equSpc;
	}
	public String getEquPri() {
		return EquPri;
	}
	public void setEquPri(String equPri) {
		EquPri = equPri;
	}
	public String getBuyTime() {
		return BuyTime;
	}
	public void setBuyTime(String buyTime) {
		BuyTime = buyTime;
	}
	public String getEquLoc() {
		return EquLoc;
	}
	public void setEquLoc(String equLoc) {
		EquLoc = equLoc;
	}
	public String getEmpNum() {
		return EmpNum;
	}
	public void setEmpNum(String empNum) {
		EmpNum = empNum;
	}
	@Override
	public String toString() {
		return EquNum;
	}
	
	
	
}