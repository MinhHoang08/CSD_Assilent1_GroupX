/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Product {
    String pcode;
    String pro_name;
    int quantity;
    int saled;
    double price;

    public Product() {
    }

    public Product(String pcode, String pro_name, int quanlity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    @Override
    public String toString() {
        return pcode+ " |  " +pro_name+ " |  " +quantity+ "  |  " +saled+ "  |  " +price;
    }

    
    
    
}
