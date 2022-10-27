package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	
	public List<Mutter> findAll(){
		
		String sql = "SELECT * FROM users";
		
		List<Mutter> mutterList = new ArrayList<>();
		
		try(Connection con = DBManager.createConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, name, text);
				mutterList.add(mutter);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}

	public boolean create(Mutter mutter) {
		
		String sql = "INSERT INTO users(name, text) VALUES(?,?)";
		
		try (Connection con = DBManager.createConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2,mutter.getText());
			
			int result = pstmt.executeUpdate();
			
			if (result != 1) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
