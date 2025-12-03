package com.tugra.repository;

import com.tugra.model.Hastane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HastaneRepository extends JpaRepository<Hastane,Long> {

    Optional<Hastane> findByHastaneId(Long hastaneId);

}
