package zqu.eqms.dao;
import java.sql.*;

import zqu.eqms.domain.User;
import zqu.eqms.util.StringUtil;

//用户dao
public class Userdao {
	
	/**
	 * 用户登录
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection conn,User user)throws Exception{
		User resultUser = null;
		
		String sql = "select * from employee where EmpNum=?";
//				+ " and EmpPass=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getEmpNum());
//		ps.setString(2, user.getEmpPass());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			if(rs.getString("EmpPass").equals(user.getEmpPass())) {
				resultUser.setEmpNum(rs.getString("EmpNum"));
				resultUser.setEmpName(rs.getString("EmpName"));
				resultUser.setEmpPass(rs.getString("EmpPass"));
				resultUser.setSvONot(rs.getString("SvOrNot"));
				
			}else {
				resultUser.setEmpName(rs.getString("EmpName"));
				resultUser.setEmpPass(null);
			}
			
		}else {
			return null;
		}
		
		return resultUser;
	}
	
	/**
	 * 用户添加
	 * @param conn
	 * @param us
	 * @return
	 * @throws SQLException
	 */
	public int addUser(Connection conn,User us) throws SQLException {
		String sql = "insert into employee values(null,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, us.getEmpName()); //用户名称
		ps.setString(2, us.getEmpPass()); //用户密码
		if("".equals(us.getEmpPhone().trim())) {
			ps.setNull(3,java.sql.Types.VARCHAR);
			
		}else {
			ps.setString(3, us.getEmpPhone()); //用户电话号码
		}
		
		if("".equals(us.getSvONot().trim())) {
			ps.setNull(4,java.sql.Types.VARCHAR);
			
		}else {
			ps.setString(4, us.getSvONot()); //是否为管理员
		}
		
		if("".equals(us.getDepaNum().trim())) {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}else {
			ps.setString(5, us.getDepaNum()); //部门编号
		}
		
		
		return ps.executeUpdate();
		
	}
	
	/**
	 * 查询用户
	 * @throws SQLException 
	 */
	public ResultSet list(Connection conn, User us) throws SQLException {
		StringBuffer sb = new StringBuffer("select * from employee");
		if(StringUtil.IsNotEmpty(us.getEmpNum())) {
			sb.append(" and EmpNum like '%" + us.getEmpNum() +"%'");
		}
		if(StringUtil.IsNotEmpty(us.getEmpName())) {
			sb.append(" and EmpName like '%" + us.getEmpName() +"%'");
		}
		if(StringUtil.IsNotEmpty(us.getEmpPhone())) {
			sb.append(" and EmpPhone like '%" + us.getEmpPhone() +"%'");
		}
		if(StringUtil.IsNotEmpty(us.getSvONot())) {
			sb.append(" and SvOrNot like '%" + us.getSvONot() +"%'");
		}
		if(StringUtil.IsNotEmpty(us.getDepaNum())) {
			sb.append(" and DepaNum like '%" + us.getDepaNum() +"%'");
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
	 * 更新
	 * @throws SQLException 
	 */
	public int update(Connection conn, User us) throws SQLException {
		String sql = "update employee set EmpName=?,EmpPass=?,EmpPhone=?,SvOrNot=?,DepaNum=? where EmpNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, us.getEmpName());
		ps.setString(2, us.getEmpPass());
		
		if("".equals(us.getEmpPhone().trim())) {
			ps.setNull(3,java.sql.Types.VARCHAR);
		}else {
			ps.setString(3, us.getEmpPhone());
		}
		
		ps.setString(4,us.getSvONot());
		
		if("".equals(us.getDepaNum().trim())) {
			ps.setNull(5,java.sql.Types.VARCHAR);
		}else {
			ps.setString(5, us.getDepaNum());
		}
		ps.setString(6, us.getEmpNum());
		
		return ps.executeUpdate();
	}
	
	/**
	 * 删除用户信息
	 * @throws SQLException 
	 */
	public int delete(Connection conn, String EmpNum) throws SQLException {
		
		String sql = "delete from employee where EmpNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, EmpNum);
		return ps.executeUpdate();
		
	}
	
	
}
