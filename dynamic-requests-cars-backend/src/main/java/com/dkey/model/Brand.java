package com.dkey.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Model> models = new HashSet<>();

    public Brand() {
    }

    public Brand(Long id, String name, Set<Model> models) {
        this.id = id;
        this.name = name;
        this.models = models;
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

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
