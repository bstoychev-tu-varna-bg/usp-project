package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "address")
public final class Address {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Pattern(regexp = "^[A-Z][a-z]+(?:[\\s-][a-zA-Z]+)*$", message = "{address.city.invalid.regexp}")
    @Size(max = 25, min = 3, message = "{address.city.invalid.size}")
    @Column(name = "city", nullable = false)
    private String city;

    @Pattern(regexp = "^[A-Z][a-z]+(?:[\\s-][a-zA-Z]+)*(\\d*)$", message = "{address.street.invalid.regexp}")
    @Size(max = 25, min = 3, message = "{address.street.invalid.size}")
    @Column(name = "street", nullable = false)
    private String street;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Client client;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
