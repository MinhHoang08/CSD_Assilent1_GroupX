
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ProductList b = new ProductList();
        OrderingList d = new OrderingList();
        CustomerList r = new CustomerList();
        Scanner scan = new Scanner(System.in);
        int choice = 0, c = 0;
        while (choice != 4) {
            System.out.println("\t\tSale Management System");
            System.out.println("-------------------------------------------------");
            System.out.println("1.      Product List");
            System.out.println("2.      Customer List");
            System.out.println("3.      Ordering List");
            System.out.println("4.      Exist");
            System.out.println("-------------------------------");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            System.out.println("-------------------");
            switch (choice) {
                case 1: {
                    while (c != 14) {
                        System.out.println("1.      Load data from file");
                        System.out.println("2.      Input & add to the end");
                        System.out.println("3.      Display data");
                        System.out.println("4.      Save book list to file");
                        System.out.println("5.      Search by bcode");
                        System.out.println("6.      Delete by bcode");
                        System.out.println("7.      Sort by bcode");
                        System.out.println("8.      Add after position  k");
                        System.out.println("9.    Delete position k");
                        System.out.println("10.      Search and edit");
                        System.out.println("11.      sort by quantity");
                        System.out.println("12.      sort by price");
                        System.out.println("13.         delete ");
                        System.out.println("14.         Exist");
                        System.out.println("---------------------------------------");
                        System.out.print("Enter your choice: ");
                        c = scan.nextInt();
                        System.out.println("-------------------");
                        switch (c) {
                            case 1: {
                                String fname = "Product.txt";
                                b.loadFile(fname);
                                b.display();
                                break;
                            }
                            case 2: {
                                System.out.print("Enter product code: ");//product code
                                String xpro_name;
                                xpro_name = scan.next();//product name
                                System.out.print("Enter product name: ");
                                String xpcode;
                                xpcode = scan.next();
                                while (b.searchByBcode(xpcode) != null) {
                                    System.out.println("product code has already exsited.");
                                    System.out.println("Please enter again: ");
                                    xpcode = scan.next();
                                }
                                System.out.print("Enter quantity of product: ");
                                int xquantity;
                                xquantity = scan.nextInt();

                                System.out.print("Enter number of saled product(Must saled <= quantity): ");
                                int xsaled;
                                xsaled = scan.nextInt();
                                while (xsaled > xquantity) {
                                    System.out.println("Saled must lower than quantity");
                                    System.out.print("Please reEnter saled product: ");
                                    xsaled = scan.nextInt();
                                }
                                System.out.print("Enter product price: ");
                                double xprice;
                                xprice = scan.nextDouble();
                                b.addLast(new Product(xpcode, xpro_name, xquantity, xsaled, xprice));
                                System.out.println("Add succesfully");

                                break;
                            }
                            case 3: {
                                System.out.printf("%-4s%-4s%-4s%-4s%-8s%-4s%-8s%-4s%-8s\n", "code", "|", "Pro_name", "|", "Quantity", "|", "Saled", "|", "Price");
                                System.out.println("------------------------------------------------------");
                                b.display();
                                break;
                            }
                            case 4: {
                                b.display();
                                break;
                            }
                            case 5: {
                                System.out.println("Insert product code for searching: ");
                                String xbCode_search = scan.next();
                                NodeProduct search = b.searchByBcode(xbCode_search);
                                if (search != null) {
                                    b.visit(search);
                                } else {
                                    System.out.println("Do not found.");
                                }
                                break;
                            }
                            case 6: {
                                System.out.println("Enter code of deleting product");
                                String xbcode = scan.next();

                                if (b.searchByBcode(xbcode) != null) {
                                    b.deleByCode(xbcode);
                                    System.out.println("Have been deleted");
                                    System.out.println("Product list after delected: ");
                                    b.display();
                                } else {
                                    System.out.println("Can't find any product had that code to delete");
                                }
                                break;
                            }
                            case 7: {
                                System.out.println("Sorting...");
                                System.out.println("Product list after sorted: ");
                                b.sortByCode();
                                b.display();
                                break;
                            }
                            case 8: {
                                Product x = new Product(null, null, choice, choice, choice);
                                System.out.print("Enter product name: ");
                                String xpro_name;
                                xpro_name = scan.next();
                                x.pro_name = xpro_name;
                                System.out.print("Enter product code: ");
                                String xbcode;
                                xbcode = scan.next();
                                x.pcode = xbcode;
                                while (b.searchByBcode(xbcode) != null) {
                                    System.out.println("Product code has already exsited.");
                                    System.out.println("Please enter again: ");
                                    xbcode = scan.next();
                                }
                                System.out.print("Enter quantity of product: ");
                                int xquantity;
                                xquantity = scan.nextInt();
                                x.quantity = xquantity;
                                System.out.print("Enter product saled (<= quantity of Book): ");
                                int xsaled;
                                xsaled = scan.nextInt();
                                while (xsaled > xquantity) {
                                    System.out.println("product saled have to below or equal to quantity of product.");
                                    System.out.print("Please reEnter product saled: ");
                                    xsaled = scan.nextInt();
                                }
                                x.saled = xsaled;
                                System.out.print("Enter product price: ");
                                double xprice;
                                xprice = scan.nextDouble();
                                x.price = xprice;
                                NodeProduct p = new NodeProduct(x);
                                int pos;
                                System.out.print("Insert position you wanna add after: ");
                                pos = scan.nextInt();
                                b.addAfter(p, pos);
                                System.out.println("Add succesfully");
                                break;
                            }
                            case 9: {
                                System.out.println("Enter postion you wanna delete");
                                int pos = scan.nextInt();
                                b.delePos(pos);
                                System.out.println(" BooList after Deleted");
                                b.display();
                            }
                            case 10: {
                                System.out.println("Enter the code to search: ");
                                String xCode;
                                xCode = scan.next();
                                if (b.searchByBcode(xCode) == null) {
                                    System.out.println("Can't find the product ");
                                } else {
                                    NodeProduct p = b.searchByBcode(xCode);
                                    System.out.println("Enter the title to edit");
                                    String xpro_name;
                                    xpro_name = scan.next();
                                    p.info.pro_name = xpro_name;
                                    b.display();
                                }
                                break;
                            }
                            case 11: {
                                System.out.println("Sort by quantity: ");
                                b.sortByQuantity();
                                b.display();
                                break;
                            }
                            case 12: {
                                System.out.println("Sort by Price: ");
                                b.sortByPrice();
                                b.display();
                                break;
                            }
                            case 13: {
                                System.out.println("Delete by name");
                                String xpro_name;
                                xpro_name = scan.next();
                                NodeProduct p = b.searchByName(xpro_name);
                                b.dele(p);
                                b.display();
                                break;
                            }
                            case 14:
                                break;

                        }
                    }
                    break;
                }
                case 2: {
                    while (c != 7) {
                        System.out.println(".1.      Load data from file");
                        System.out.println("2.      Input & add to the end");
                        System.out.println("3.      Display data");
                        System.out.println(".4.      Save reader list to file");
                        System.out.println(".5.      Search by ccode");
                        System.out.println("6.      Delete by ccode");
                        System.out.println("7.      Exist");
                        System.out.println("----------------------------------------");
                        System.out.print("Enter your choice: ");
                        c = scan.nextInt();
                        System.out.println("-------------------");
                        switch (c) {
                            case 1: {
                                String f = "Customer.txt";
                                r.loadFile(f);
                                r.display();
                                break;
                            }
                            case 2: {
                                //product name
                                System.out.print("Enter Customer name: ");
                                String xcus_name;
                                xcus_name = scan.next();
                                //product code
                                System.out.print("Enter Customer code: ");
                                String xccode;
                                xccode = scan.next();
                                while (r.searchByCode(xccode) != null) {
                                    System.out.println("Customer code has already exsited.");
                                    System.out.println("Please enter again: ");
                                    xccode = scan.next();
                                }
                                System.out.print("Enter the phone of customer: ");
                                int xphone;
                                xphone = scan.nextInt();
                                break;
                            }
                            case 3: {
                                System.out.printf("%-4s%-4s%-4s%-4s%-8s\n", "code", "|", "name", "|", "phone");
                                System.out.println("------------------------------------------------------");
                                r.display();
                                break;
                            }
                            case 4: {
                                break;
                            }
                            case 5: {
                                System.out.println("Insert product code for searching: ");
                                String xcCode_search = scan.next();
                                NodeCustomer search = r.searchByCode(xcCode_search);
                                if (search != null) {
                                    r.visit(search);
                                } else {
                                    System.out.println("Do not found.");
                                }
                                break;
                            }
                            case 6: {
                                System.out.println("Enter code of deleting product");
                                String xccode = scan.next();
                                if (r.searchByCode(xccode) != null) {
                                    r.deleByCode(xccode);
                                    System.out.println("Have been deleted");
                                } else {
                                    System.out.println("Can't find any product had that code to delete");
                                }
                                break;
                            }
                            case 7:
                                break;
                        }
                    }
                    break;
                }
                case 3: {
                    while (c != 5) {

                        System.out.println("1.      Input data");
                        System.out.println("2.      Display data");
                        System.out.println("3.      Sort  by pcode + ccode");
                        System.out.println("4.      Load data");
                        System.out.println("5.      Exist");
                        System.out.println("-----------------------------------------");
                        System.out.print("Enter your choice: ");
                        c = scan.nextInt();
                        System.out.println("-------------------");
                        switch (c) {
                            case 1: {
                                d.search("C1", "C2");
                                break;
                            }
                            case 2: {
                                System.out.printf("%-8s%-8s%-8s\n", "Customer code", "Product code", "Quantity");
                                System.out.println("----------------------------------------------");
                                d.display();
                                break;
                            }
                            case 3: {
                                d.sortByCode();
                                System.out.println("Sort succesfully");
                                d.display();
                                break;
                            }
                            case 4: {
                                d.loadProduct("Product.txt");
                                d.loadProduct("Product.txt");
                                d.loadCustomer("Customer.txt");
                                d.traverseProduct();
                                d.traverseCustomer();
                                d.traverseProduct();
                                d.display();
                                break;

                            }
                            case 5:
                                break;

                        }
                    }
                    break;
                }
                case 4:
                    break;
            }
        }
    }
}
  
