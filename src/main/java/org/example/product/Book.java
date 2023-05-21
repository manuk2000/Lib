package org.example.product;

import java.util.Date;
import java.util.Objects;

public abstract class Book {

    private String title;
    private String name;
    private String author;

    public Book(String title, String name, String author, Date date) {
        this.title = title;
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    private Date date;
    abstract public String reading();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(date, book.date) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, name, author, date);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}

