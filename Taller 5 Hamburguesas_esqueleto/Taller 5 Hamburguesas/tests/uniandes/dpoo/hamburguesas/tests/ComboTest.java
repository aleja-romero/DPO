package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {

	private Combo combo1;
	
	 @BeforeEach
	    void setUp( ) throws Exception
	    {
		 	
		 ProductoMenu item1 = new ProductoMenu( "Hamburguesa sencilla", 25000 );
		 ProductoMenu item2 = new ProductoMenu( "Papas medianas", 8000);
		 ProductoMenu item3 = new ProductoMenu( "Gaseosa mediana", 6500);
	     
		 ArrayList<ProductoMenu> items = new ArrayList<>();
		 items.addAll(Arrays.asList(item1, item2, item3));
		 
		 combo1 = new Combo( "especial", 0.07, items);
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }

	    @Test
	    void testGetNombre( )
	    {
	        assertEquals( "especial", combo1.getNombre( ), "El nombre del producto no es el esperado." );
	    }

	    @Test
	    void testGetPrecio( )
	    {
	        assertEquals( 36735, combo1.getPrecio(), "El precio del producto no es el esperado." );
	    }
	    
	    @Test
	    void testGenerarTextoFactura() {
	    	assertEquals("Combo especial\n" + 
	    				 " Descuento:            0.07\n" +
	    				 "                        36735\n", combo1.generarTextoFactura(), "El texto de factura no es el esperado.");
	    }
	    

}
