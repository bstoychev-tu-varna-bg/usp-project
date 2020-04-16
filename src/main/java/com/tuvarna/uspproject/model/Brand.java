package com.tuvarna.uspproject.model;

import com.tuvarna.uspproject.annotation.BrandNameConstraint;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brand")
public final class Brand {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @BrandNameConstraint
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;

    public Brand() {
    }
}
