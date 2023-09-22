/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kahil
 */
public class Manager extends Actor {
    
    public Manager(String u,String p,String r)throws Exception{
        super(u,p,r);
    }
    

    @Override
    public boolean LoginCheck(){
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        
        String TypedID= Manager.this.getusername().trim();
        String TypedPass =Manager.this.getpassword().trim();
        String ID="", PASSWORD="";
        String query = "SELECT  MId, MPass\n"+"FROM MANGR\n";
        
        int i = 0;
        try {       
            Class.forName("org.sqlite.JDBC");       
            c = DriverManager.getConnection(url);
            System.out.println("Manager Opened database successfully");
        } 
        catch ( Exception e )  {      
                    System.err.println(e.getMessage());     
        }

        try{
            Connection myCon = DriverManager.getConnection(url);
            Statement myStmt = myCon.createStatement();
            ResultSet myRes = myStmt.executeQuery(query);

            while(myRes.next()){
                i = 1;
                ID = myRes.getString(i++);
                PASSWORD = myRes.getString(i++);
            }
            myStmt.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        return(TypedID.contains(ID) && TypedPass.contains(PASSWORD));
    }
    
    public void RemoveCustomer(String TypedID){
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        String query = "DELETE FROM CUSTR\n"+"WHERE CId='"+TypedID+"';\n";

        try {       
            Class.forName("org.sqlite.JDBC");       
            c = DriverManager.getConnection(url);
            System.out.println("Opened database successfully");
	    } 
            catch ( Exception e )  {      
                    System.err.println(e.getMessage());     
	    }

        try{
            Connection myCon = DriverManager.getConnection(url);
            Statement myStmt = myCon.createStatement();
            myStmt.executeUpdate(query);
            myStmt.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void AddCustomer(String TypedID, String TypedPass){
        SHA256 HashObj = new SHA256();
        String HashedPass = "";
        try {
            HashedPass = HashObj.toHexString(HashObj.getSHA(TypedPass));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        String query = "INSERT INTO CUSTR\n"+"VALUES('"+TypedID+"','"+HashedPass+"',0.0,'Manager');\n";

        try {       
            Class.forName("org.sqlite.JDBC");       
            c = DriverManager.getConnection(url);
            System.out.println("Opened database successfully");
	    } 
            catch ( Exception e )  {      
                    System.err.println(e.getMessage());     
	    }

        try{
            Connection myCon = DriverManager.getConnection(url);
            Statement myStmt = myCon.createStatement();
            myStmt.executeUpdate(query);
            myStmt.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
