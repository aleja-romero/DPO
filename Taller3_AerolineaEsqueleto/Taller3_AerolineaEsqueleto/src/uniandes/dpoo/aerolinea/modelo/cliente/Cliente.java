package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	protected List<Tiquete> tiquetesSinUsar;
	protected List<Tiquete> tiquetesUsados;
	
	public Cliente() {
        this.tiquetesSinUsar = new ArrayList<>();
        this.tiquetesUsados = new ArrayList<>();
    }

    public abstract String getTipoCliente();
    
    public abstract String getIdentificador();

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    public int calcularValorTotalTiquetes() {
    	int total = 0;
        for (int i = 0; i < tiquetesSinUsar.size(); i++) {
        	Tiquete tiquete = tiquetesSinUsar.get(i);
            total += tiquete.getTarifa();
        }
        return total;
    }

    public void usarTiquetes(Vuelo vuelo) {
        List<Tiquete> usados = new ArrayList<>();
        for (int i = 0; i < tiquetesSinUsar.size(); i++) {
        	Tiquete tiquete = tiquetesSinUsar.get(i);
            if (tiquete.getVuelo().equals(vuelo)) {
                usados.add(tiquete);
            }
        }
        tiquetesSinUsar.removeAll(usados);
        tiquetesUsados.addAll(usados);
    }
}

	    
