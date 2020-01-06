package com.oil.messenger.repository;

import com.oil.messenger.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CompanyCrudRepository extends JpaRepository<Company, Integer> {

    @Modifying
    @Query("DELETE FROM Company c WHERE c.id=:id")
    int deleteById(@Param("id") int id);

    Optional<Company> findByEmail(String email);
}
