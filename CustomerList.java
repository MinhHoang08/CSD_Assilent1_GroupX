
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class CustomerList {

    NodeCustomer head, tail;

    public CustomerList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null && tail == null);
    }

    void clear() {
        head = null;
        tail = null;
    }

    void addLast(Customer x) {
        NodeCustomer p = new NodeCustomer(x);
        if (isEmpty()) {
            head = tail = p;
        }
        tail.next = p;
        tail = p;
    }

    void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String ccode, cos_name;
        int phone;
        Customer x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");
            ccode = a[0].trim();
            cos_name = a[1].trim();
            phone = Integer.parseInt(a[2].trim());
            x = new Customer(ccode, cos_name, phone);
            addLast(x);
        }
        f.close();
    }

    void visit(NodeCustomer p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void display() {
        NodeCustomer p = head;
        if (isEmpty()) {
            return;
        }
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    NodeCustomer searchByCode(String xRcode) {
        NodeCustomer p = head;
        while (p != null) {
            if (p.info.ccode.equals(xRcode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    void deleFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void dele(NodeCustomer p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            deleFirst();
            return;
        }
        NodeCustomer q = head;
        while (q != null && q != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = p.next;
        if (q.next == null) {
            tail = q;
        }

    }

    void deleByCode(String xCode) {
        NodeCustomer p = searchByCode(xCode);
        dele(p);
    }
}
