package com.example.dataaccess;



import java.sql.DriverManager;
import java.sql.ResultSet;




import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class Daobject {
	
	//note: these string should be moved to a prop file but are here for demo purposes only
	final String conString = "jdbc:mysql://127.0.0.1:3306/workout_schema";
	final String user = "user";
	final String pwd = "password";
	Connection conn;
	
	//constructor
	public Daobject() throws Exception{
		
		    //you need the mysql driver located here: https://dev.mysql.com/downloads/connector/j/
		    // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.jdbc.Driver");
	        //setup your connection
	        conn = (Connection) DriverManager.getConnection(conString, user, pwd);
	}
	
	//example connection using stored procedure with no parameters
	public List<User> getAllUsers(){
		
		List<User> userList = new ArrayList<User>();
		User u;
		String query = "{ call sp_getall_usr }";//<-named of stored procedure in mysql db
        ResultSet rs;
        try{    	
           CallableStatement stmt = (CallableStatement) conn.prepareCall(query);
           
         
            rs = stmt.executeQuery();
            while (rs.next()) {
            	u = new User();
            	u.setName(rs.getString("usr_name"));
            	u.setWeight(rs.getInt("usr_weight"));
            	u.setLastupdate(rs.getDate("usr_lastupdate"));
                userList.add(u);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
		return userList;
		
	}
	
	//example connection using stored procedure with multiple parameters
	public List<Max> getAllMax(String uName, String exName){
		List<Max> maxList = new ArrayList<Max>();
		Max m;
		String query = "{ call sp_getall_max(?,?) }";//<-named of stored procedure in mysql db
        ResultSet rs;
        try{    	
            CallableStatement stmt = (CallableStatement) conn.prepareCall(query);
            stmt.setString("p_usr_name", uName );//note: p_usr_name is the name of the stored procedure parameter
            stmt.setString("p_ex_name", exName );
         
            rs = stmt.executeQuery();
            while (rs.next()) {
            	m = new Max();
            	m.setWeight(rs.getInt("max_weight"));
            	m.setLastupdate(rs.getDate("max_lastupdate"));
            	maxList.add(m);
            	

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
		
		return maxList;
	}

}
