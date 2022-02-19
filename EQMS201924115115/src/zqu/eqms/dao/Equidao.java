package zqu.eqms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zqu.eqms.domain.Depa;
import zqu.eqms.domain.Equi;
import zqu.eqms.domain.User;
import zqu.eqms.util.StringUtil;

public class Equidao {
	/**
	 * 添加新设备
	 * @throws SQLException 
	 * 
	 */
	public int addEque(Connection conn,Equi eq) throws SQLException {
		String sql = "insert into equipment values(null,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, eq.getEquName());
		
		ps.setString(2, eq.getEquSpc());
		if("".equals(eq.getEquPri())) {
			ps.setNull(3, java.sql.Types.FLOAT);
		}else {
			ps.setString(3, eq.getEquPri());
		}
		if("".equals(eq.getBuyTime())) {
			ps.setNull(4, java.sql.Types.DATE);
		}else {
			ps.setString(4, eq.getBuyTime());
		}
		if("".equals(eq.getEquLoc())) {
			ps.setNull(5,java.sql.Types.VARCHAR);
		}else {
			ps.setString(5, eq.getEquLoc());
		}
		
		
		
		ps.setString(6, eq.getEmpNum());
		
		
		return ps.executeUpdate();
		
		
	}
	
	/**
	 * 查询功能
	 * @throws SQLException 
	 */
	public ResultSet list(Connection conn,Equi eq,Depa dp,User us) throws SQLException {
		StringBuffer sb = new StringBuffer("SELECT equ.EquNum, equ.EquName, equ.BuyTime, equ.EquLoc, emp.EmpName, dep.DepaName, emp.EmpNum FROM equipment equ, employee emp, department dep WHERE equ.EmpNUm=emp.EmpNum AND emp.DepaNum=dep.DepaNum");
		if(StringUtil.IsNotEmpty(eq.getEquNum())) {
			sb.append(" and equ.EquNum like '%" + eq.getEquNum() + "%'");
		}
		if(StringUtil.IsNotEmpty(eq.getEquName())) {
			sb.append(" and equ.EquName like '%" + eq.getEquName() + "%'");
		}
		if(StringUtil.IsNotEmpty(eq.getBuyTime())) {
			sb.append(" and equ.BuyTime like '%" + eq.getBuyTime() + "%'");
		}
		if(StringUtil.IsNotEmpty(eq.getEquLoc())) {
			sb.append(" and equ.EquLoc like '%" + eq.getEquLoc() + "%'");
		}
		if(StringUtil.IsNotEmpty(us.getEmpName())) {
			sb.append(" and emp.EmpName like '%" + us.getEmpName() + "%'");
		}
		if(StringUtil.IsNotEmpty(dp.getDepaName())) {
			sb.append(" and dep.DepaName like '%" + dp.getDepaName() + "%'");
		}
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ps.executeQuery();
	}
	
	/**
	 * 更新操作
	 * @throws SQLException 
	 */
	public int update(Connection conn,Equi equ) throws SQLException {
		String sql = "update equipment set EquName=?,BuyTime=?,EquLoc=?,EmpNUm=? where EquNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, equ.getEquName());
		if("".equals(equ.getBuyTime())) {
			ps.setNull(2,java.sql.Types.VARCHAR);
		}else {
			ps.setString(2, equ.getBuyTime());
		}
		
		if("".equals(equ.getEquLoc())) {
			ps.setNull(3,java.sql.Types.VARCHAR);
		}else {
			ps.setString(3, equ.getEquLoc());
		}
		
		ps.setString(4, equ.getEmpNum());
		ps.setString(5, equ.getEquNum());
		return ps.executeUpdate();
	}
	/**
	 * 删除操作
	 * @throws SQLException 
	 * 
	 */
	public int delete(Connection conn,String EquNum) throws SQLException {
		String sql = "delete from equipment where EquNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, EquNum);
		return ps.executeUpdate();
	}
}

