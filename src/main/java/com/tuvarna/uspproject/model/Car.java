package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
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
    private Date yearOfProduction;

    @Positive(message = "{car.distanceTraveled.invalid.positive}")
    @Column(name = "distance_traveled", nullable = false)
    private int distanceTraveled;

    @Min(value = 600, message = "{car.price.invalid.min}")
    @Column(name = "price", nullable = false)
    private double price;

    @NotBlank(message = "{car.color.invalid.notBlank}")
    @Column(name = "color", nullable = false)
    private String color;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Sale sale;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    public Car() {
    }

    public UUID getId() {
        return id;
    }
}
