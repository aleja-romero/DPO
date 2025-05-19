package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

	private ProductoMenu productoMenu1;
	
	 @BeforeEach
	    void setUp( ) throws Exception
	    {
	        productoMenu1 = new ProductoMenu( "Hamburguesa", 25000 );
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }

	    @Test
	    void testGetNombre( )
	    {
	        assertEquals( "Hamburguesa", productoMenu1.getNombre( ), "El nombre del producto no es el esperado." );
	    }

	    @Test
	    void testGetPrecio( )
	    {
	        assertEquals( 25000, productoMenu1.getPrecio(), "El precio del producto no es el esperado." );
	    }
	    
	    @Test
	    void testGenerarTextoFactura() {
	    	assertEquals("Hamburguesa            25000\n", productoMenu1.generarTextoFactura(), "El texto de factura no es el esperado.");
	    }
	    
	    
}
