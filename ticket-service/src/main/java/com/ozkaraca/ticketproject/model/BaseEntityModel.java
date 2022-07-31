package com.ozkaraca.ticketproject.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate cretedAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;
}

