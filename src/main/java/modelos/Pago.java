
package modelos;

import java.io.Serializable;

public class Pago implements Serializable {

	private static final long serialVersionUID = 8157232896330549773L;

	private Integer id_pago;

	private Venta id_venta;

	private Float monto_pagado;

	private String fecha;


	public Integer getIdPago() {
		return id_pago;
	}

	public void setIdPago(Integer id) {
		this.id_pago = id;
	}


	public Venta getVenta() {
		return id_venta;
	}

	public void setVenta(Venta venta) {
		this.id_venta = venta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Float getMontoPagado() {
		return monto_pagado;
	}

	public void setMontoPagado(Float montoPagado) {
		this.monto_pagado = montoPagado;
	}

}

