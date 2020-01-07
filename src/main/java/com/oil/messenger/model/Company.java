package com.oil.messenger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "company_unique_email_idx")})
@Getter
@Setter
@ToString
public class Company extends AbstractNamedBaseEntity {

    public Company() {
    }

    public Company(String name, @Email String email, String address) {
        super.name = name;
        this.email = email;
        this.address = address;
    }

    public Company(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.email = company.getEmail();
        this.address = company.getAddress();
    }

    @Size(max = 100)
    @Email
    @Column(name = "email")
    private String email;

    @Size(max = 200)
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(email, company.email) &&
                Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, address);
    }
}
