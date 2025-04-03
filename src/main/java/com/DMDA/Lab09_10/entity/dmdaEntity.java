package com.DMDA.Lab09_10.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dmda_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class dmdaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dmdaUser;
    private String dmdaPass;
    private String dmdaName;
    private String dmdaEmail;
    private String dmdaPhone;
    private String dmdaAddress;
    private Integer dmdaStatus;
}

