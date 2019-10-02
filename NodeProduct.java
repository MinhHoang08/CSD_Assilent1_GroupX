/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NodeProduct {

    Product info;
    NodeProduct next;

    public NodeProduct() {
    }

    public NodeProduct(Product info, NodeProduct next) {
        this.info = info;
        this.next = next;
    }

    public NodeProduct(Product info){
        this(info, null);
    }
}
