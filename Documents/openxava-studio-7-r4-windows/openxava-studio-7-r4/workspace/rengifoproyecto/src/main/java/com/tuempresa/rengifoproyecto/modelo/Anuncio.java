package com.tuempresa.rengifoproyecto.modelo;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name="ANUNCIO")
@View(name="ConPrecio", members="descripcion, precio")
public class Anuncio {
    
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length=32)
    private String oid;
    
    @File
    @Column(length=32)
    private String fotos;

    @Column(length=256, name="DESCRIPCION")
    @Required
    @TextArea
    private String descripcion;
    
    @Money @Required
    private BigDecimal precioBase;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=true)
    @DescriptionsList 
    private Categoria categoria;
    
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Cliente cliente;


}
