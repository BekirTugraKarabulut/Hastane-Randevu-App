package com.tugra.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "calisanlar")
@Schema(description = "Calisan Bilgileri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calisanlar implements UserDetails {

    @Id
    @Column(name = "calisan_id")
    private Long calisanId;

    @Column(name = "tc_no", unique = true)
    private String tcNo;

    @Column(name = "password")
    private String password;

    @Column(name = "calisan_ad")
    private String calisanAd;

    @Column(name = "calisan_soyad")
    private String calisanSoyad;

    @Column(name = "dogum_tarihi")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dogumTarihi;

    @Column(name = "telefon_no" , unique = true)
    private String telefonNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "bolum_id", referencedColumnName = "bolum_id")
    private Bolum bolum;

    @OneToMany(mappedBy = "calisanlar", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Randevu> randevular;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return calisanId.toString();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
