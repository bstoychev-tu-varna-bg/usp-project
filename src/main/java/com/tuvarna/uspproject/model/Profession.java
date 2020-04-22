package com.tuvarna.uspproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profession")
public final class Profession {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @NotBlank(message = "{profession.name.invalid.notBlank}")
    @Column(name = "name", nullable = false)
    private String name;

    @Min(value = 560, message = "{profession.salary.invalid.min}")
    @Column(name = "salary", nullable = false)
    private Integer salary;

    @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Profession() {
    }
}
