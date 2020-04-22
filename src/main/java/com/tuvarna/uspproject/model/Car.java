package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Table(name = "car")
public final class Car {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Min(value = 1920, message = "{car.yearOfProduction.invalid.min}")
    @Max(value = 2020, message = "{car.yearOfProduction.invalid.max}")
    @Column(name = "date", nullable = false)
    private Integer yearOfProduction;

    @Positive(message = "{car.distanceTraveled.invalid.positive}")
    @Column(name = "distance_traveled", nullable = false)
    private Integer distanceTraveled;

    @Min(value = 600, message = "{car.price.invalid.min}")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotBlank(message = "{car.color.invalid.notBlank}")
    @Column(name = "color", nullable = false)
    private String color;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Sale sale;

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    public Car() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(Integer distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
