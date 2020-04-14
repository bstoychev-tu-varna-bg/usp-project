package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @Column(name = "date", nullable = false)
    private Date yearOfProduction;

    @Column(name = "distance_traveled", nullable = false)
    private int distanceTraveled;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "color", nullable = false)
    private String color;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Sale sale;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    public Car() {
    }
}
