package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
    private Avion avion;
    private List<Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
    }

	public Ruta getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }
    
    public Collection<Tiquete> getTiquetes(){
    	return tiquetes;
    }
    
    public int venderTiquete(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		return cantidad;
    	
    }
    
    public boolean equals(Object obj) {
		return false;
   
    }
}
