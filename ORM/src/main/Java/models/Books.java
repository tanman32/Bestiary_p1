package models;


import annotations.Columns;
import annotations.Tables;

@Tables(name = "books")
public class Books {

    @Columns(name = "b_id", primaryKey = true)
    private int id;

    @Columns(name = "title")
    private String title;
    @Columns(name = "series")
    private String series;
    @Columns(name = "author")
    private String author;
    @Columns(name = "publisher")
    private String publisher;
    @Columns(name = "genre")
    private String genre;





}
