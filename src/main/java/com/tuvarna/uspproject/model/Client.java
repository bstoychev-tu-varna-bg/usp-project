package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "client")
public final class Client {
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

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public Client() {
    }

    public UUID getId() {
        return id;
    }
}
