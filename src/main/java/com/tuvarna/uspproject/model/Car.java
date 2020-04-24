package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
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

    @NotNull(message = "{number.invalid.notNull}")
    @Min(value = 1920)
    @Max(value = 2020)
    @Column(name = "date", nullable = false)
    private Integer yearOfProduction;

    @NotNull(message = "{number.invalid.notNull}")
    @Positive
    @Column(name = "distance_traveled", nullable = false)
    private Integer distanceTraveled;

    @NotNull(message = "{number.invalid.notNull}")
    @Min(value = 600)
    @Column(name = "price", nullable = false)
    private Double price;

    @NotBlank(message = "{car.color.invalid.notBlank}")
    @Column(name = "color", nullable = false)
    private String color;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Sale sale;

    @Valid
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

    @Override
    public String toString() {
        return "Car{" +
                "yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", model=" + model +
                '}';
    }
}
