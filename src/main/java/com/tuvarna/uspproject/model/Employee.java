package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
public final class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Pattern(regexp = "^[A-Z][a-z]{1,20}([-]?[A-Z][a-z]{1,20})?$", message = "{name.invalid.regexp}")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{1,20}([-]?[A-Z][a-z]{1,20})?$", message = "{name.invalid.regexp}")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Pattern(regexp = "^[0-9]{10}$", message = "{telephoneNumber.invalid.regexp}")
    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profession_id", nullable = false)
    private Profession profession;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public Employee() {
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
