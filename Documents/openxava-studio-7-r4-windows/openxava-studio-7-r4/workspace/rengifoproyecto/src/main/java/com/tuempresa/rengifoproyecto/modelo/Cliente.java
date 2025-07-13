package com.tuempresa.rengifoproyecto.modelo;
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@Views({
    @View(name="DatosFactura", members="nombre, direccion"),
    @View(name="Simple", members="numeroCedula, nombres") 
})
public class Cliente extends Persona{
	
	
	@Column(length = 25)
	String nombresComercial;	

}
