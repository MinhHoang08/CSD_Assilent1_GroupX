/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang-MACpro
 */
public class Customer {
    String ccode;
    String cus_name;
    int phone;

    public Customer() {
    }

    public Customer(String ccode, String cus_name, int phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ccode+ "  |  " +cus_name+ "  |  " +phone;
    }

    
    
}
