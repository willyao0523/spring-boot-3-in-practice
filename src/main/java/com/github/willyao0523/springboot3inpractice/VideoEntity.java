package com.github.willyao0523.springboot3inpractice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VideoEntity {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    protected VideoEntity() {
        this(null, null);
    }

    VideoEntity(String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
