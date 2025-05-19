package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {
	
	private Restaurante restaurante1;
	
	@BeforeEach
    void setUp( ) throws Exception
    {
		restaurante1 = new Restaurante();
		File carpeta = new File("./facturas");
		if (!carpeta.exists()) {
		    carpeta.mkdirs();
		}
    }

	@AfterEach
    void  cleanup() {
        File carpetaFacturas = new File("./facturas");
        if (carpetaFacturas.exists()) {
            for (File archivo : carpetaFacturas.listFiles()) {
                archivo.delete();
            }
        }
    }
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    	resetNumeroPedidos();
    	restaurante1.getPedidos().clear();
    	restaurante1.getIngredientes().clear();
    }
    
    private void resetNumeroPedidos() throws Exception {
    	Field field = Pedido.class.getDeclaredField("numeroPedidos");
    	field.setAccessible(true);
        field.setInt(null, 0);
    }
    
    @Test
    void testIniciarPedido() throws Exception {
    	restaurante1.iniciarPedido("Pepito Perez", "Calle 100 #1-10");
    	assertNotNull(restaurante1.getPedidoEnCurso(), "El pedido no se inicializo correctamente");
    }
    
    @Test
    void testIniciarPedidoException() throws Exception {
    	restaurante1.iniciarPedido("Pepito Perez", "Calle 100 #1-10");
    	assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            restaurante1.iniciarPedido("Luis Lopez", "Calle 57 #15-5");
        });
    }
    
    @Test
    void testCerrarYGuardarPedido() throws Exception {
    	restaurante1.iniciarPedido("Pepito Perez", "Calle 100 #1-10");
    	int idPedido = restaurante1.getPedidoEnCurso().getIdPedido();
    	restaurante1.cerrarYGuardarPedido();
    	
    	String nombreArchivo = "factura_" + idPedido + ".txt";
    	File archivoFactura = new File("./facturas/" + nombreArchivo);
    	
    	assertTrue(archivoFactura.exists(), "El archivo de la factura no fue creado");
    	
    	ArrayList<Pedido> pedidos = restaurante1.getPedidos();
    	assertFalse(pedidos.isEmpty(),"El pedido no se almaceno en el historial");
    }
    
    @Test
    void testCerrarYGuardarPedidoException() throws Exception {
    	assertThrows(NoHayPedidoEnCursoException.class, () -> {
            restaurante1.cerrarYGuardarPedido();
        });
    }
    
    @Test
    void testGetPedidoEnCurso() throws Exception {
    	restaurante1.iniciarPedido("Pepito Perez", "Calle 100 #1-10");
    	assertEquals(0, restaurante1.getPedidoEnCurso().getIdPedido(), "El pedido en curso no es el esperado");
    }
    
    @Test
    void testGetPedidos() throws Exception {
    	restaurante1.iniciarPedido("Pepito Perez", "Calle 100 #1-10");
    	restaurante1.cerrarYGuardarPedido();
    	ArrayList<Pedido> pedidos = restaurante1.getPedidos();
    	assertFalse(pedidos.isEmpty(),"La lista de pedidos esta vacia");
    	assertEquals( 0, pedidos.get(0).getIdPedido(), "El pedido no se almaceno correctamente");
    }
    
    @Test
    void testCargarInformacionRestaurante() throws Exception {
    	File dataIngredientes = new File("./data/ingredientes.txt");
    	File dataMenu = new File("./data/menu.txt");
    	File dataCombos = new File("./data/combos.txt");
    	restaurante1.cargarInformacionRestaurante(dataIngredientes, dataMenu, dataCombos);
    	
    	assertEquals(15, restaurante1.getIngredientes().size());
        assertEquals(22, restaurante1.getMenuBase().size());
        assertEquals(4, restaurante1.getMenuCombos().size());
    }
    
    @Test
    void testCargarIngredientesException() throws Exception{
    	File dataIngredientes = crearArchivoTemporal("ingredientes.txt", "Tomate;1000\nTomate;800");
    	File dataMenu = new File("./data/menu.txt");
    	File dataCombos = new File("./data/combos.txt");
    	restaurante1.cargarInformacionRestaurante(dataIngredientes, dataMenu, dataCombos);
    	
    	
    }
}
