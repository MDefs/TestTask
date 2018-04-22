package com.example.demo.domain;

import org.hibernate.mapping.Table;

import javax.persistence.*;

@Entity
public class DataRelatedItem{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer number;
    private String hash;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String dateModified;
    private String relatedItem;
    private String id;

    public DataRelatedItem() {
    }

    public DataRelatedItem(String hash, String format, String url, String title, String documentOf, String datePublished, String dateModified, String relatedItem, String id) {
        this.hash = hash;
        this.format = format;
        this.url = url;
        this.title = title;
        this.documentOf = documentOf;
        this.datePublished = datePublished;
        this.dateModified = dateModified;
        this.relatedItem = relatedItem;
        this.id = id;
    }
}
