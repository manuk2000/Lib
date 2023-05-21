package org.example.main;

import org.example.borrowers.Borrowers;
import org.example.lib.Lib;
import org.example.librarian.Librarian;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Lib lib = new Lib();
        Date date = new Date();
        lib.addBook("a","a","a",date , "sdf");
        lib.addBook("a","a","a",date , "sdf");

        lib.getBook("a","a","a",date , "sdf");
        lib.addBook("a","a","a",date , "sdf");

        System.out.println(lib.toString());

        Borrowers bo = new Borrowers("name" , "0980908098" ,
                new Librarian("Tikin" , "09090909",lib));
        System.out.println(bo.byBook("a", "a", "a", date, "sdf").reading());

    }
}