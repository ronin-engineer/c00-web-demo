package dev.ronin_engineer.re_web_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "nation")
    private String nation;

    @Column(name = "version")
    private Long version;

//    @JsonIgnore
//    @OneToOne(mappedBy = "address")     // field name in Hotel class
//    private Hotel hotel;
}
