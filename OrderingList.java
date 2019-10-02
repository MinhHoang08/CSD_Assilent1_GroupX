/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class OrderingList {
    NodeOrdering head, tail; 
    ProductList pl = new ProductList(); 
    CustomerList cl = new CustomerList();
    Scanner scan = new Scanner(System.in);    
    public OrderingList(){
            head = tail = null;
    }

    public OrderingList(NodeOrdering head, NodeOrdering tail) {
        this.head = head;
        this.tail = tail;
    }
    boolean isEmpty(){
        return head == null; 
    }
    void clear(){
        head = null; 
        tail = null; 
    }
    void addLast(Ordering x){
        NodeOrdering p = new NodeOrdering(x); 
        
        if(isEmpty()){
            head = tail = p;
            return; 
        }
        tail.next = p; 
        tail = p;
    }
    void visit(NodeOrdering p){
        if(p!= null){
            System.out.println(p.info);
        }
    }
    void display(){
        NodeOrdering p = head; 
        if(isEmpty()) return; 
        while(p!= null){
            visit(p);
            p = p.next;
        }
        System.out.println("");
    }
    
     NodeOrdering search(String xbCode, String xrCode) {
        NodeOrdering p = head;
        while (p != null) {
            if (p.info.ccode.equals(xbCode) && p.info.ccode.equals(xrCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

  void sortByCode(){
      if(isEmpty()) return; 
      NodeOrdering p =head; 
      NodeOrdering q; 
      while(p!=null){
          q = p.next; 
          while(q!= null){
               if  (p.info.pcode.compareToIgnoreCase(q.info.pcode) > 0 || (p.info.pcode.compareToIgnoreCase(q.info.pcode) == 0
                        && p.info.ccode.compareToIgnoreCase(q.info.ccode) > 0)) {
                  Ordering x = p.info; 
                  p.info = q.info; 
                  q.info = x; 
              }
              q = q.next; 
          }
          p = p.next; 
      }
  } 
   void loadProduct(String Bname) throws IOException {
       pl.loadFile(Bname);
   }
   void loadCustomer(String Rname) throws IOException{
       cl.loadFile(Rname);
   }
    void traverseProduct() {
        if (pl.isEmpty()) {
            return;
        }
        pl.display();
        System.out.println();
    }
    
    void traverseCustomer() {
        if (cl.isEmpty()) {
            return;
        }
        cl.display();
        System.out.println();
    }
    
   void Order(String xBcode, String xRcode){
       
                            if (cl.searchByCode(xRcode) == null) {
                                System.out.println("There is no customer with this code.");
                                return; 
                            }
                           
                            if (pl.searchByBcode(xBcode) == null) {
                                System.out.println("There is no product with this code.");
                               return; 
                            }

                            
   }
}
