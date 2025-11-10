package SanadUI;
import java.sql.*;

public class DatabaseLoader {
	private Connection connection;
	private Statement statement;
	
	public void establishConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanad" , "root" , "app@mysql");
			statement = connection.createStatement();
			
		}catch(Exception e) {
			System.out.println("Error In Connection !");
		}
		
	}
	
	public void loadToDatabase(Contribution contribution) {
		try {
			getStatement().executeUpdate("INSERT INTO doner(`name`,`helptype`,`phone#`,`facbook`,`zone`) VALUES('"+contribution.organization+"','"+contribution.contributionType+"','"+ contribution.phoneNumber +"'','"+ contribution.facebookLink +"','"+ contribution.location+"') ");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Statement getStatement() {
		return statement;
	}
	public void closeConnection() {
		try {
			connection.close();
			
		} catch (SQLException e) {
			
			System.out.println("Error at closing connection");
		}
	}

	public static void main(String[] args) {
		    DatabaseLoader d  = new DatabaseLoader();
			d.establishConnection();
			d.loadToDatabase(new Contribution("fatima", "fashir", "12345678", "food", ""));
			
		}

}
