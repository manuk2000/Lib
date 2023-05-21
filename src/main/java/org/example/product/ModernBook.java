package org.example.product;

import java.util.Date;

public class ModernBook extends Book {
    public ModernBook(String title, String name, String author, Date date){
        super(title,name,author,date);
    }
    @Override
    public String reading() {
        return "ModernBook";
    }
}