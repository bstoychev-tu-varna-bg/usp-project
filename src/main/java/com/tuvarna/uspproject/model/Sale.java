package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "sale")
public final class Sale {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Valid
    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Sale() {
    }

    public UUID getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
