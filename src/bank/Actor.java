/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author kahil
 */
public class Actor {
    private String username="";
    private String password="";
    private String role="";
    
    public Actor(String u,String p,String r)throws Exception{
        setusername(u);
        setpassword(p);
        setrole(r);
    }
    
    public void setusername(String u){
        if(getusername().equals("")){
            username=u;
        } 
    }
    public String getusername(){
        return username;
    }
    public void setpassword(String p){
        if(getpassword().equals("")){
            password=p;
        } 
    }
    public String getpassword(){
        return password;
    }
    public void setrole(String r){
        if(getrole().equals("")){
            role=r;
        } 
    }
    public String getrole(){
        return role;
    }
    
    public boolean LoginCheck(){
        return false;
    }
    
}
