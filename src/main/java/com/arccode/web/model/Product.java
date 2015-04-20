package com.arccode.web.model;

/**
 * Product : 商品实体, 主要用于ORM
 *
 * @author http://arccode.net
 * @since 2015-04-16 11:03
 */
public class Product {

    private String id;
    private String name;
    private String description;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
