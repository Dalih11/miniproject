package com.loyalty3.loyalty3.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "point")
@Data
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPoint;
    private String jumlahPoint;

}
