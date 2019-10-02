
import java.util.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ProductList {
    NodeProduct head,tail; 

    public ProductList() {
    }

    public ProductList(NodeProduct head, NodeProduct tail) {
        this.head = head;
        this.tail = tail;
    }

    
    
    boolean isEmpty(){
        return(head==null); 
    }
    void clear(){
        head =null; 
        tail =null; 
    }
    void addLast(Product x){
        NodeProduct q = new NodeProduct(x); 
       if(isEmpty()) {
           head = tail =q; 
           return;
       }
       tail.next = q; 
       tail =q; 
    }
    int size(){
        NodeProduct p = head; 
        int i = 0; 
        while(p!= null){
           p = p.next; 
           i++; 
        }
        return(i); 
    }
     void loadFile(String fname) throws IOException {
            RandomAccessFile f = new RandomAccessFile(fname,"r");
            String s; String [] a;
            String pcode, pro_name;
            int quantity, saled; 
            double price;
            Product x;
            while(true) {
             s = f.readLine();
             if(s==null || s.trim().equals("")) break;
             a = s.split("[|]");
             pcode = a[0].trim();
             pro_name = a[1].trim();
             quantity = Integer.parseInt(a[2].trim());
             saled = Integer.parseInt(a[3].trim());
             price = Double.parseDouble(a[4].trim());
             x = new Product(pcode, pro_name, quantity, saled, price);
             addLast(x);
            }
            f.close();
    } 
     
    void visit(NodeProduct p){
        if(p!=null) System.out.println(p.info);
    }
    void display(){
        NodeProduct p =head; 
        while(p!= null){
            visit(p);
            p = p.next; 
        }
        System.out.println();
    }
    NodeProduct searchByBcode(String xCode){
        NodeProduct q = head; 
        if(isEmpty()) return(null); 
        while(q!= null){
          if(q.info.pcode.equals(xCode)) return(q); 
            q = q.next; 
        }
        return(null); 
    }
    void deleFirst(){
        if(isEmpty()) return; 
        head = head.next; 
        if(head == null) tail = null; 
    }
    void dele(NodeProduct p){
        if(p == null) return; 
        if(p == head) {
            deleFirst();
            return;
        } 
        NodeProduct q = head; 
        while(q != null && q.next != p){
            q = q.next; 
        }
        if(q == null) return; 
        q.next = p.next; 
        if(q.next == null) tail = q; 
        
    }
    void deleByCode(String xCode){
        NodeProduct p = searchByBcode(xCode); 
        dele(p);
    }
    void sortByCode(){
        if(isEmpty()) return; 
        NodeProduct q, p; 
        q = head; 
        while(q != null){
            p = q.next; 
            while(p!=null){
            if(q.info.pcode.compareTo(p.info.pcode) > 0){
                Product x = q.info; 
                q.info = p.info;
                p.info = x; 
            }
            p = p.next; 
            }
            q = q.next; 
        }
    }
    void addAfter(NodeProduct p, int k){ 
      if(p == null) return; 
      NodeProduct q = pos(k); 
      NodeProduct q1= q.next; 
        q.next = p; 
        p.next = q1; 
      if(q.next == null) tail = q; 
    }
     void addFirst(Product x) {
        head = new NodeProduct(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    NodeProduct pos(int k){
        int i =0; 
        NodeProduct p = head; 
        while(p !=null){
            if(i == k){
                return(p); 
            }
            i ++; 
            p=p.next;
        }
        return(null); 
    }
  
    void delePos(int k){
       NodeProduct p= pos(k); 
        dele(p);
    }
    
     void sortByQuantity(){
        if(isEmpty()) return; 
        NodeProduct q, p; 
        q = head; 
        while(q != null){
            p = q.next; 
            while(p!=null){
            if(q.info.quantity > p.info.quantity){
                Product x = q.info; 
                q.info = p.info;
                p.info = x; 
            }
            p = p.next; 
            }
            q = q.next; 
        }
    }
      void sortByPrice(){
        if(isEmpty()) return; 
        NodeProduct q, p; 
        q = head; 
        while(q != null){
            p = q.next; 
            while(p!=null){
            if(q.info.price > p.info.price){
                Product x = q.info; 
                q.info = p.info;
                p.info = x; 
            }
            p = p.next; 
            }
            q = q.next; 
        }
    }
     NodeProduct searchByName(String xTitle){
        NodeProduct q = head; 
        if(isEmpty()) return(null); 
        while(q!= null){
          if(q.info.pro_name.equals(xTitle)) return(q); 
            q = q.next; 
        }
        return(null); 
    }
}
