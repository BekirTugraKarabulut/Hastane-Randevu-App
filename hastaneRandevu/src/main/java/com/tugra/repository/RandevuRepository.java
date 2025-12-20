package com.tugra.repository;

import com.tugra.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findByKullanici_Username(String username);

}
