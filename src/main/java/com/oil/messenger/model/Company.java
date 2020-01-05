package com.oil.messenger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "companies", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "company_unique_email_idx")})
@Getter
@Setter
@ToString
public class Company extends AbstractRegisteredBaseEntity {

    @Column(name = "address")
    private String address;
}
