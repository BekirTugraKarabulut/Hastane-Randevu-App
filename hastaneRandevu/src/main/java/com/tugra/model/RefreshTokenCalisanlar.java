package com.tugra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "refresh_token_calisanlar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenCalisanlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "expires_date")
    private Date expiresDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calisan_id" , referencedColumnName = "calisan_id")
    private Calisanlar calisanlar;

}
