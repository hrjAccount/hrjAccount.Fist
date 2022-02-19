package zqu.eqms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zqu.eqms.domain.Depa;
import zqu.eqms.util.StringUtil;

public class Depadao {
	/**
	 * 添加新的部门
	 * @param conn
	 * @param dp
	 * @return
	 * @throws Exception
	 */
	public int addDepa(Connection conn,Depa dp)throws Exception {
		
		String sql = "insert into department values(null,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dp.getDepaName());
		if("".equals(dp.getEmpNum())) {
			ps.setNull(2,java.sql.Types.VARCHAR);
		}else {
			ps.setString(2, dp.getEmpNum());
		}
		return ps.executeUpdate();
	}
	
	
	
	/**
	 * 查询部门
	 * @param conn
	 * @param dp
	 * @return
	 * @throws SQLException
	 */
	public ResultSet list(Connection conn,Depa dp) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from department");
		if(StringUtil.IsNotEmpty(dp.getDepaName())) {
			sb.append(" and DepaName like '%" + dp.getDepaName() + "%'");	
		}
		if(StringUtil.IsNotEmpty(dp.getDepaNum())) {
			sb.append(" and DepaNum like '%" + dp.getDepaNum() + "%'");	
		}
		if(StringUtil.IsNotEmpty(dp.getEmpNum())) {
			sb.append(" and EmpNum like '%" + dp.getEmpNum() + "%'");	
		}
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps.executeQuery();
	}
	
	
	/**
	 * 删除部门信息
	 * @param conn
	 * @param DepaNum
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,String DepaNum)throws Exception {
		String sql = "delete from department where DepaNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, DepaNum);
		ps.setInt(1, Integer.parseInt(DepaNum));
		
		return ps.executeUpdate();
	}
	
	
	/**
	 * 更新部门信息
	 * @param conn
	 * @param dp
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,Depa dp)throws Exception {
		String sql = "update department set DepaName=?,EmpNum=? where DepaNum=?";
		PreparedStatement  ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, dp.getDepaName());
		
		if("".equals(dp.getEmpNum().trim())) {
			ps.setNull(2,java.sql.Types.VARCHAR);
		}else {
			ps.setString(2, dp.getEmpNum());
		}
		
		ps.setString(3, dp.getDepaNum());
//		ps.setInt(2, Integer.parseInt(dp.getEmpNum()));
//		int Depnum = Integer.parseInt(dp.getDepaNum());
//		ps.setInt(3, Integer.parseInt(dp.getDepaName()));
		
		
		return ps.executeUpdate();
	}

}
