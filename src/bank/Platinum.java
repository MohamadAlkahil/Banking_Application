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
public class Platinum extends Levels {
    private double fee=0;
    private String lev="Platinum";
    @Override
    public double fee(){
        return fee;
    }
    @Override
    public String lev(){
        return lev;
    }

}
