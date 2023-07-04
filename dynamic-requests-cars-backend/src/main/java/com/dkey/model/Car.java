package com.dkey.model;

import com.dkey.enums.Color;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private boolean changed;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Min(0)
    private int km;
    @ManyToOne(optional = false)
    private Model model;

    public Car() {
    }

    public Car(Long id, String version, boolean changed, Color color, int km, Model model) {
        this.id = id;
        this.version = version;
        this.changed = changed;
        this.color = color;
        this.km = km;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChange(boolean changed) {
        this.changed = changed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

