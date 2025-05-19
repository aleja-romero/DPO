package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {

	private Pedido pedido1;
	
	 @BeforeEach
	    void setUp( ) throws Exception
	    {
		 pedido1 = new Pedido( "Pepito Perez", "Calle 100 #1-10");
		 
		 ProductoMenu item1 = new ProductoMenu( "Hamburguesa sencilla", 25000 );
		 ProductoMenu item2 = new ProductoMenu( "Papas medianas", 8000);
		 ProductoMenu item3 = new ProductoMenu( "Gaseosa mediana", 6500);
		 ProductoMenu producto1 = new ProductoMenu( "Salchipapa", 15000);
		 
		 Ingrediente ingrediente1 = new Ingrediente( "tomate", 1000 );
		 Ingrediente ingrediente2 = new Ingrediente( "cebolla", 1200 );
		 Ingrediente ingrediente3 = new Ingrediente( "lechuga", 800 );
		 	
		 ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
		 ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
		 	
		 agregados.add(ingrediente1);
		 agregados.add(ingrediente2);
		 eliminados.add(ingrediente3);
		 	
		 ProductoMenu productoBase = new ProductoMenu( "Hamburguesa", 25000 );
	     ProductoAjustado producto2 = new ProductoAjustado(productoBase, agregados, eliminados);
	     
		 ArrayList<ProductoMenu> items = new ArrayList<>();
		 items.addAll(Arrays.asList(item1, item2, item3));
		 
		 Combo combo1 = new Combo( "especial", 0.07, items);
		 
		 ArrayList<Producto> productos = new ArrayList<>();
		 productos.addAll(Arrays.asList(producto1, combo1));
		 
		 pedido1.agregarProducto(producto1);
	     pedido1.agregarProducto(combo1);
	     pedido1.agregarProducto(producto2);
	    	
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    	resetNumeroPedidos();
	    }
	    
	    private void resetNumeroPedidos() throws Exception {
	    	Field field = Pedido.class.getDeclaredField("numeroPedidos");
	    	field.setAccessible(true);
	        field.setInt(null, 0);
	    }
	    
	    @Test
	    void testGetIdPedido( )
	    {
	    	assertEquals( 0, pedido1.getIdPedido( ), "El Id del pedido no es el esperado");
	    }
	    
	    @Test
	    void testGetNombreCliente()
	    {
	    	assertEquals( "Pepito Perez", pedido1.getNombreCliente(), "El nombre del cliente no es el esperado");
	    }
	    
	    @Test
	    void testGetPrecioTotalPedido( )
	    {
	    	
	    	assertEquals( 93932, pedido1.getPrecioTotalPedido(), "El precio total del pedido no es el esperado");
	    }
	    
	    @Test
	    void testGetPrecioNetoPedido( )
	    {
	    	
	    	assertEquals( 78935, pedido1.getPrecioNetoPedido(), "El precio total del pedido no es el esperado");
	    }
	    
	    @Test
	    void testGetPrecioIVAPedido( )
	    {
	    	
	    	assertEquals( 14997, pedido1.getPrecioIVAPedido(), "El precio total del pedido no es el esperado");
	    }
	    
	    @Test
	    void testGenerarTextofactura()
	    {
	    	assertEquals("Cliente: Pepito Perez\n" +
	    				 "Dirección: Calle 100 #1-10\n" +
	    				 "----------------------------\n" +
	    				 "Salchipapa            15000\n" +
	    				 "Combo especial\n" + 
	    				 " Descuento:            0.07\n" +
	    				 "                        36735\n" +
	    				 "Hamburguesa            25000\n" + 
		    			 "    +tomate            1000\n" + 
		    			 "    +cebolla            1200\n" + 
		    			 "    -lechuga            0\n" + 
		    			 "                        27200\n" +
		    			 "----------------------------\n" +
	    				 "Precio Neto:  78935\n" +
	    				 "IVA:          14997\n" +
	    				 "Precio Total:  93932\n", pedido1.generarTextoFactura(), "El texto generado no es el esperado");
	    }
	    
	    @Test
	    void testGuardarFactura() throws IOException {
	    	
	    	String facturaDePrueba = pedido1.generarTextoFactura();
	    	File archivoTemporal = File.createTempFile("facturaTest", ".txt");
	        archivoTemporal.deleteOnExit();
	        
	        pedido1.guardarFactura(archivoTemporal);
	        
	        String contenido = Files.readString(archivoTemporal.toPath());
	        assertEquals(facturaDePrueba, contenido);
	    }
	    
	    @Test
	    void testGuardarFacturaConArchivoInvalido() {
	        File archivo = new File("/directorioinvalido.txt");
	        assertThrows(FileNotFoundException.class, () -> {
	            pedido1.guardarFactura(archivo);
	        });
	    }
}
