package com.tuempresa.rengifoproyecto.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Empleado extends Persona {

	@Column(length = 50)
	@Required
	@TextArea
	String descripcion;
	
	@Column(length = 10)
	int telefonoVendedor;
	
	

}
