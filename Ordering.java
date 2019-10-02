/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Ordering {
    String pcode;
    String ccode;
    int quanlity;

    public Ordering() {
    }

    public Ordering(String pcode, String ccode, int quanlity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quanlity = quanlity;
    }

    @Override
    public String toString() {
        return pcode+ "  |  " + ccode + "  |  " +quanlity;
    }

    
    
}
