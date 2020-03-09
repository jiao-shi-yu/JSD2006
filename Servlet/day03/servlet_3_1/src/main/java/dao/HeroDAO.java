package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Hero;
import utils.DBUtils;

public class HeroDAO {
	public void insert(Hero hero) {
		try (Connection conn = DBUtils.getConn()) {
			String sql = "INSERT INTO hero VALUES(null, ?, ?, ?, ?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, hero.getName());
			pStatement.setString(2, hero.getType());
			pStatement.setString(3, hero.getGender());
			pStatement.setInt(4, hero.getPrice());
			
			pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Hero> findAll() {
		ArrayList<Hero> heros = new ArrayList<>();
		try (Connection conn = DBUtils.getConn()) {
			String sql = "SELECT * FROM hero";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String gender = rs.getString(4);
				int price = rs.getInt(5);
				
				Hero hero = new Hero(id, name, type, gender, price);
				heros.add(hero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heros;
	}
	
}
