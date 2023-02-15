package online_survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLmanage {
	
	Connection con;
	
	public SQLmanage() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/online_survey_system";
		String usr = "root";
		String pass = "Pravin08@";
		con = DriverManager.getConnection(url, usr, pass);
	}
	
	public int authUser(String uname, String pass) throws SQLException {
		String str = "SELECT * FROM admin WHERE username = '"+uname+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		if (!rst.next())
			return -1;
		else {
			if(rst.getString("password").equals(pass))
				return 1;
			else
				return 0;
		}
	}
	
	public int authUserpublic(String uname, String pass) throws SQLException {
		String str = "SELECT username,password FROM user WHERE username = '"+uname+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		if (!rst.next())
			return -1;
		else {
			if(rst.getString("password").equals(pass))
				return 1;
			else
				return 0;
		}
	}
	
	public void newQuestion( String question, String op1, String op2, String op3, String op4) throws SQLException {
		String str = "INSERT INTO question(question,option1,option2,option3,option4) values ('"+question+"', '"+op1+"', '"+op2+"', '"+op3+"', '"+op4+"')";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}
	
	public void deletequestion( String string) throws SQLException {
		String str1 = "DELETE FROM user_answer WHERE question_id_ref = "+string;
		Statement stm1 = con.createStatement();
		stm1.executeUpdate(str1);
		
		String str = "DELETE FROM question WHERE question_id = "+string;
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
}

	public ResultSet getQuestions() throws SQLException {
		String str = "SELECT * FROM question";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public ResultSet getid(String username) throws SQLException {
		String str = "SELECT* FROM user where username = '"+username+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public ResultSet getqid(String question) throws SQLException {
		String str = "SELECT question_id FROM question  where question= '"+question+"'";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}
	
	public void userquestion(String user_id_ref,String question_id_ref,String option1,String option2,String option3,String option4) throws SQLException {
		String str = "INSERT INTO user_answer( user_id_ref, question_id_ref, option1, option2, option3, option4) values ('"+user_id_ref+"', '"+question_id_ref+"', '"+option1+"', '"+option2+"', '"+option3+"'"+",'"+option4+"')";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}

	
	public void user(String name,String email_id,String username,String password) throws SQLException {
		String str = "INSERT INTO user( name, email_id, username, password) values ( '"+name+"', '"+email_id+"', '"+username+"', '"+password+"')";
		Statement stm = con.createStatement();
		stm.executeUpdate(str);
	}

	public ResultSet getpolls() throws SQLException {
		String str = "SELECT question_id_ref,sum(option1),sum(option2),sum(option3),sum(option4)FROM user_answer";
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str);
		return rst;
	}


	
}