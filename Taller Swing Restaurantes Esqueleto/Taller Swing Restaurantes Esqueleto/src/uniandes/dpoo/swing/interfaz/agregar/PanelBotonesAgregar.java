package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "nuevo";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "ver";

    private JButton butNuevo;
    private JButton butCerrar;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar( VentanaAgregarRestaurante ventanaPrincipal )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout( new FlowLayout( ) );

        // Agrega el botón para crear el restaurante
        // TODO completar
        
        butNuevo = new JButton("Crear restaurante");
        butNuevo.setActionCommand(CREAR);
        butNuevo.addActionListener(this);
        
        butNuevo.setBackground(Color.WHITE);
        butNuevo.setForeground(Color.BLACK);
        butNuevo.setFocusPainted(false);
        butNuevo.setOpaque(true);
        add(butNuevo);

        // Agrga el boton para cerrar la ventana
        // TODO completar
        
        butCerrar = new JButton("Cerrar");
        butCerrar.setActionCommand(CERRAR);
        butCerrar.addActionListener(this);
        
        butCerrar.setBackground(Color.WHITE);
        butCerrar.setForeground(Color.BLACK);
        butCerrar.setFocusPainted(false);
        butCerrar.setOpaque(true);
        add(butCerrar);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CREAR ) )
        {
            ventanaPrincipal.agregarRestaurante( );
        }
        else if( comando.equals( CERRAR ) )
        {
            ventanaPrincipal.cerrarVentana( );
        }
    }
}
