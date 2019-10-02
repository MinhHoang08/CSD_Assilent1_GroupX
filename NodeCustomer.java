/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NodeCustomer {

    Customer info;
    NodeCustomer next;

    public NodeCustomer() {
    }

    public NodeCustomer(Customer info, NodeCustomer next) {
        this.info = info;
        this.next = next;
    }

    public NodeCustomer(Customer info) {
        this(info, null);
    }
}
