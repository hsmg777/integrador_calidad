package com.tuempresa.rengifoproyecto.modelo;

import java.math.*;
import java.time.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members = 
"datosGenerales[" +
"  anyo, fecha," +
"  cliente" +
"];" +
"anuncio;" +
"impuestos[" +
"  porcentajeIva," +
"  iva," +
"  total" +
"];" +
"observaciones"
)
public class Factura {
    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String oid;
    
    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int anyo;
    
    @Column(length = 6)
    @ReadOnly
    private int numero;
    
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate fecha;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("ConPrecio")
    @Required
    private Anuncio anuncio;
    
    @DefaultValueCalculator(value=IntegerCalculator.class, 
        properties=@PropertyValue(name="value", value="15"))
    private int porcentajeIva;
    
    @Money @ReadOnly
    @Depends("anuncio.precioBase, porcentajeIva")
    public BigDecimal getIva() {
        if (anuncio == null || anuncio.getPrecioBase() == null) {
            return BigDecimal.ZERO;
        }
        return anuncio.getPrecioBase()
                .multiply(new BigDecimal(porcentajeIva))
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    @Money @ReadOnly
    @Depends("anuncio.precioBase, porcentajeIva")
    public BigDecimal getTotal() {
        if (anuncio == null || anuncio.getPrecioBase() == null) {
            return BigDecimal.ZERO;
        }
        return anuncio.getPrecioBase().add(getIva());
    }
}