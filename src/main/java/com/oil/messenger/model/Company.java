package com.oil.messenger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "companies", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "company_unique_email_idx")})
@Getter
@Setter
@ToString
public class Company extends AbstractRegisteredBaseEntity {

    public Company() {
    }

    public Company(String address) {
        this.address = address;
    }

    public Company(@NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(max = 100) @Email String email,
                   @NotBlank @Size(min = 6, max = 50) String password, @NotNull LocalDateTime registered,
                   boolean enabled, String address) {
        super(name, email, password, registered, enabled);
        this.address = address;
    }

    public Company(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.email = company.getEmail();
        this.password = company.getPassword();
        this.registered = company.getRegistered();
        this.enabled = company.isEnabled();
        this.address = company.getAddress();
    }

    @Column(name = "address")
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }
}
