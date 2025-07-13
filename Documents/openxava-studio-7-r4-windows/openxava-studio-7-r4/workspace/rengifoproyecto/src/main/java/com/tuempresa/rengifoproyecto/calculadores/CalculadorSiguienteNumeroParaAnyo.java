package com.tuempresa.rengifoproyecto.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

@Getter @Setter     
public class CalculadorSiguienteNumeroParaAnyo implements ICalculator {


/**
	 * 
	 */
	private static final long serialVersionUID = 1957589236343245236L;
int anyo; 

public Object calculate() throws Exception { 
    Query query = XPersistence.getManager() 
    						  .createQuery("select max(f.numero) from Factura f where f.anyo = :anyo"); 
    						  query.setParameter("anyo", anyo); 
    Integer ultimoNumero = (Integer) query.getSingleResult();
    return ultimoNumero == null ? 1 : ultimoNumero + 1; 

}

}