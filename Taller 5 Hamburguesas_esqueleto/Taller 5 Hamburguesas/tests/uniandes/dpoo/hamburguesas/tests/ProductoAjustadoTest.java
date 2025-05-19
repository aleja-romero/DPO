package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {

	private ProductoAjustado productoAjustado1;
	
	 @BeforeEach
	    void setUp( ) throws Exception
	    {
		 	Ingrediente ingrediente1 = new Ingrediente( "tomate", 1000 );
		 	Ingrediente ingrediente2 = new Ingrediente( "cebolla", 1200 );
		 	Ingrediente ingrediente3 = new Ingrediente( "lechuga", 800 );
		 	
		 	ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
		 	ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
		 	
		 	agregados.add(ingrediente1);
		 	agregados.add(ingrediente2);
		 	eliminados.add(ingrediente3);
		 	
		 	ProductoMenu productoBase = new ProductoMenu( "Hamburguesa", 25000 );
	        productoAjustado1 = new ProductoAjustado(productoBase, agregados, eliminados);
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }

	    @Test
	    void testGetNombre( )
	    {
	        assertEquals( "Hamburguesa", productoAjustado1.getNombre( ), "El nombre del producto no es el esperado." );
	    }

	    @Test
	    void testGetPrecio( )
	    {
	        assertEquals( 27200, productoAjustado1.getPrecio(), "El precio del producto no es el esperado." );
	    }
	    
	    @Test
	    void testGenerarTextoFactura() {
	    	assertEquals("Hamburguesa            25000\n" + 
	    				"    +tomate            1000\n" + 
	    				"    +cebolla            1200\n" + 
	    				"    -lechuga            0\n" + 
	    				"                        27200\n", productoAjustado1.generarTextoFactura(), "El texto de factura no es el esperado.");
	    }
	    

}
