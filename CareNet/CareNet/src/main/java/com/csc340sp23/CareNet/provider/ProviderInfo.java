package com.csc340sp23.CareNet.provider;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sentini
 */
@AllArgsConstructor
@Entity
@Table(name = "Provider Login In")
@NoArgsConstructor
@Getter
@Setter
public class ProviderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String userType;

    public ProviderInfo(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

}
