package com.tuempresa.rengifoproyecto.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity

@Getter
@Setter
@View(members = "numeroCedula,nombres,apellidos,direccion,numeroTelefono")

abstract public class Persona {
	@Id
	@Hidden
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	@Column(length = 32)
	String oid;
	
	@Column(length = 10)
	int numeroCedula;
	
	@Column(length = 50)
	String nombres;
	
	@Column(length = 50)
	String apellidos;
	
	@Column(length = 125)
	String direccion;
	
	@Column(length = 10)
	int numeroTelefono;
	
	
}
