/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NodeOrdering {

    Ordering info;
    NodeOrdering next;

    public NodeOrdering() {
    }

    public NodeOrdering(Ordering info, NodeOrdering next) {
        this.info = info;
        this.next = next;
    }

    public NodeOrdering(Ordering info) {
        this(info, null);
    }
}
