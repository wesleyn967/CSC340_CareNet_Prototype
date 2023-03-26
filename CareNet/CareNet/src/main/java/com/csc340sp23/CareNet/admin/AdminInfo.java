package com.csc340sp23.CareNet.admin;

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
@Table(name = "Login In")
@NoArgsConstructor
@Getter
@Setter
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user;
    private String pass;
    private String userType;

    public AdminInfo(String user, String pass, String userType) {
        this.user = user;
        this.pass = pass;
        this.userType = userType;
    }

}
