package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Crea el campo para el nombre con una etiqueta al frente
        // TODO completar
    	setLayout(new BorderLayout());
    	
    	JPanel panelDetalles = new JPanel(new GridLayout(3, 2, 5, 5));
        panelDetalles.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel labelNombre = new JLabel("Nombre");
        txtNombre = new JTextField();
        panelDetalles.add(labelNombre);
        panelDetalles.add(txtNombre);
        
        // Crea el selector para la calificación con una etiqueta al frente
        // TODO completar
        JLabel labelCalificacion = new JLabel("Calificación");
        cbbCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        cbbCalificacion.setSelectedIndex(2); 
        panelDetalles.add(labelCalificacion);
        panelDetalles.add(cbbCalificacion);
        
        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        // TODO completar
        JLabel labelVisitado = new JLabel("Visitado");
        cbbVisitado = new JComboBox<>(new String[]{"Sí", "No"});
        cbbVisitado.setSelectedIndex(1);
        panelDetalles.add(labelVisitado);
        panelDetalles.add(cbbVisitado);
        
     // Agregar todos los elementos al panel
        // TODO completar
        
        add(panelDetalles, BorderLayout.CENTER);
        
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado()
    {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }


    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        // TODO completar
        return txtNombre.getText().trim();
    }
}
