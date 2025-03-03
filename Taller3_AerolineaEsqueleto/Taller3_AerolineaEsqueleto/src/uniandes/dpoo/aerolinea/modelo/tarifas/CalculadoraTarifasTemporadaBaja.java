package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

	protected static final int COSTO_POR_KM_NATURAL = 600;
	protected static final int COSTO_POR_KM_CORPORATIVO = 900;
	protected static final double DESCUENTO_PEQ = 0.02;
	protected static final double DESCUENTO_MEDIANAS = 0.1;
	protected static final double DESCUENTO_GRANDES = 0.2;

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int costo;
		String tipo = cliente.getTipoCliente();
		if (tipo.equals("Natural")) {
			costo = COSTO_POR_KM_NATURAL;
		}else {
			costo = COSTO_POR_KM_CORPORATIVO;
		}
		Ruta ruta = vuelo.getRuta();
		int distancia = this.calcularDistanciaVuelo(ruta);
		return costo * distancia;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		
		return 0;
	}

}
