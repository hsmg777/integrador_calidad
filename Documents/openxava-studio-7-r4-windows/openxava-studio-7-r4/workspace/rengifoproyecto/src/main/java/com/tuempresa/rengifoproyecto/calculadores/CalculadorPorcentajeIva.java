package com.tuempresa.rengifoproyecto.calculadores;
import java.math.*;

import org.openxava.calculators.*;

public class CalculadorPorcentajeIva implements ICalculator {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1972336126276308331L;

	public Object calculate() throws Exception {
        return new BigDecimal("0.15");
    }
}