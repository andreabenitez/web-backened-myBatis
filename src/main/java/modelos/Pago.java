package modelos;

public class Pago {

	private Integer id_pago;

	private Integer id_venta;

	private Float monto_pagado;

	private String fecha;

	public Pago(){
	}

	public Integer getId_pago() {
		return id_pago;
	}

	public void setId_pago(Integer id_pago) {
		this.id_pago = id_pago;
	}

	public Integer getId_venta() {
		return id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	public Float getMonto_pagado() {
		return monto_pagado;
	}

	public void setMonto_pagado(Float monto_pagado) {
		this.monto_pagado = monto_pagado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
