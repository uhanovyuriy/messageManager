package com.oil.messenger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
abstract class AbstractRegisteredBaseEntity extends AbstractBaseEntity {

    AbstractRegisteredBaseEntity() {
    }

    AbstractRegisteredBaseEntity(@NotBlank @Size(min = 2, max = 100) String name,
                                        @NotBlank @Size(max = 100) @Email String email,
                                        @NotBlank @Size(min = 6, max = 50) String password,
                                        @NotNull LocalDateTime registered, boolean enabled) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
    }

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    protected String name;

    @NotBlank
    @Size(max = 100)
    @Email
    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @NotBlank
    @Size(min = 6, max = 50)
    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected LocalDateTime registered = LocalDateTime.now();

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    protected boolean enabled = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractRegisteredBaseEntity that = (AbstractRegisteredBaseEntity) o;
        return enabled == that.enabled &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, password, enabled);
    }
}
