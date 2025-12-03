package com.tugra.repository;

import com.tugra.model.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolumRepository extends JpaRepository<Bolum,Long> {


}
