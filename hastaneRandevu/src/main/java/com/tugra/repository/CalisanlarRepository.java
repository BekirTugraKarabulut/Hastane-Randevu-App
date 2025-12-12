package com.tugra.repository;

import com.tugra.model.Calisanlar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalisanlarRepository extends JpaRepository<Calisanlar, Long> {

    Optional<Calisanlar> findByCalisanId(Long calisanId);

}
