package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	// 将需要传递的三个信息封装到EMP实体对象中
	// 这样调用方法只需要传递一个参数即可
	public void insert(Emp emp) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "INSERT INTO emp(empno, ename, sal) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setDouble(3, emp.getSal());
			ps.executeUpdate();
			System.out.println("保存完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Emp> findAll() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		try (Connection conn = DBUtils.getConn()) {
			String sql = "SELECT empno, ename, sal FROM emp";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				double sal = rs.getDouble(3);
				list.add(new Emp(empno, ename, sal));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
}
