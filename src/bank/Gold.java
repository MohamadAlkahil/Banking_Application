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
public class Gold extends Levels {
    private double fee=10;
    private String lev="Gold";
    @Override
    public double fee(){
        return fee;
    }
    @Override
    public String lev(){
        return lev;
    }

}
