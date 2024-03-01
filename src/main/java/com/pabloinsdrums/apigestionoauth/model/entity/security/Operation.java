package com.pabloinsdrums.apigestionoauth.model.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    private String httpMethod;
    private boolean permitAll;
//    @ManyToOne
//    @JoinColumn(name = "module_id")
//    private Module module;
    @Column(name = "module_id")
    private Long moduleId;
}
