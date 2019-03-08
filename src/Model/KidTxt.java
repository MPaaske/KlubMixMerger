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
public class KidTxt {
    String  name;
    String  schoolClass;
    String  school;
    long    cpr;
    int     clubNo;
    
    public KidTxt(String name, String schoolClass, String school, long cpr, int clubNo){
        this.name   = name;
        this.schoolClass = schoolClass;
        this.school = school;
        this.cpr    = cpr;
        this.clubNo = clubNo;
    }
}
