package com.ozkaraca.ticketproject.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "uname")
    private String username;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "pwd")
    private String password;

    @Column(value = "created_at")
    private LocalDate createdAt;

    @Column(value = "is_active")
    private Boolean active;
}
