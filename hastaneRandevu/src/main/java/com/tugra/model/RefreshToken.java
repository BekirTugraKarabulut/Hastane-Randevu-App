package com.tugra.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table
@Schema(description = "Refresh Token Modeli")
@Entity(name = "refresh_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

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
    @JoinColumn(name = "tc_no" , referencedColumnName = "tc_no")
    private Kullanici kullanici;

}
