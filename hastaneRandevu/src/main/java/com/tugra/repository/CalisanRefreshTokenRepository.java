package com.tugra.repository;

import com.tugra.model.RefreshTokenCalisanlar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalisanRefreshTokenRepository extends JpaRepository<RefreshTokenCalisanlar, Integer> {

}
