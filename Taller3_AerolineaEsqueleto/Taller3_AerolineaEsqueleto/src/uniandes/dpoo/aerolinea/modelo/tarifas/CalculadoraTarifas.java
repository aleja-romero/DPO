package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public static final double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        
        int tarifaFinal = (int) (costoBase - (costoBase*porcentajeDescuento));
        tarifaFinal -= (int) (tarifaFinal + (tarifaFinal*valorImpuestos));
        
        return tarifaFinal;
    }

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularDistanciaVuelo(Ruta ruta) {
    	return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
    }

    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    
	}

	
}
