/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kahil
 */
public class Customer extends Actor {
    private Levels level = new Silver();
    
     public Customer(String u,String p,String r) throws Exception{
        super(u,p,r);
    }
     
    public double getfee(){
        return level.fee();
    }
    public String getlevel(){
        return level.lev();
    }
    public void changeLevels(){
        double Balance = Customer.this.getbalance();
        if(Balance < 10000){
            level = new Silver();
        }
        else if( Balance >=10000 && Balance <20000){
            level = new Gold();
        }
        if(Balance >= 20000){
            level = new Platinum();
        }
    }
    
    @Override
    public boolean LoginCheck(){
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        String TypedID= Customer.this.getusername().trim();
        String TypedPass =Customer.this.getpassword().trim();
        String ID="", PASSWORD="";
        String query = "SELECT  CId, CPass\n" + "FROM CUSTR\n"+"WHERE CId='"+TypedID+"'\n";
        
        int i = 0;
        try {       
            Class.forName("org.sqlite.JDBC");       
            c = DriverManager.getConnection(url);
            System.out.println("Customer Opened database successfully");
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
        
        return(TypedID.equals(ID) && TypedPass.equals(PASSWORD));
    }
    

    public double getbalance(){
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        String TypedID= Customer.this.getusername().trim();
        double Balance=0.0;
        String query = "SELECT Balance\n"+"FROM CUSTR\n"+"WHERE CId='"+TypedID+"'\n";
        int i = 0;
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
            ResultSet myRes = myStmt.executeQuery(query);

            while(myRes.next()){
                i = 1;
                Balance= myRes.getDouble(i);
            }
            myStmt.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        return Balance;
    }
    
    public void UpdateBalance(double amount){
        String url = "jdbc:sqlite:C:/Users/kahil/Documents/NetBeansProjects/Bank/Manager.db";
        Connection c=null; 
        String TypedID= Customer.this.getusername().trim();
        String query = "UPDATE CUSTR\n"+"SET Balance=Balance+"+amount+"\n"+"WHERE CId='"+TypedID+"';\n";

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
        Customer.this.changeLevels();
    }
    
}
