package com.gjozef.devicesservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parameters")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Parameter extends AbstractDeviceServiceEntity {

    @Column(name = "param_name", nullable = false, unique = true)
    private String paramName;

    @Column(name = "value")
    private String value;
}
