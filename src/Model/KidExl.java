/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Paaske
 */
public class KidExl {
    long    cprP;
    long    cprK;
    int     takst;
    double  friTs;
    int     fpPct;
    double  extraPct;
    
    public KidExl(long cprP, long cprK, int takst, double friTs, int fpPct, double extraPct){
        this.cprP       = cprP;
        this.cprK       = cprK;
        this.takst      = takst;
        this.friTs      = friTs;
        this.fpPct      = fpPct;
        this.extraPct   = extraPct;
    }
}
