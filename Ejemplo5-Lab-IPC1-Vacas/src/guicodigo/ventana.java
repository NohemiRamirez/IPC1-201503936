/*35
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicodigo;

import gui.repuesto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author elmer
 */
public class ventana extends JFrame {

    public ventana() throws HeadlessException {
        this.setSize(250, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearObjetosInternos();
    }
    producto[] inventario = new producto[50];

    public void crearObjetosInternos() {
        JPanel pnlPrincipal = new JPanel(new FlowLayout());
        pnlPrincipal.setBackground(Color.BLACK);

        //------------- Botones ----------------------
        JButton btnCargarDatos = utiles.CrearBoton("Cargar", 200, 35);
        JButton btnVerInventario = utiles.CrearBoton("Ver Inventario", 200, 35);
        JButton btnDetalle = utiles.CrearBoton("Ver detalle producto", 200, 35);
        //------------ Combo box ---------------------------
        JComboBox cmbDatos = new JComboBox();
        //-------------- TXT Carga -----------------
        JTextArea txtCarga = new JTextArea("");
        txtCarga.setPreferredSize(new Dimension(200, 50));
        txtCarga.setLocation(0, 0);
        pnlPrincipal.add(txtCarga);
        //---------------------------------------------
        //-------------- Buton cargar Datos -----------------

        btnCargarDatos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, txtCarga.getText());
                String info = txtCarga.getText();
                String[] datos = info.split("\n");
                for (String dato : datos) {
                    System.out.println(dato);
                    String[] infoActividad = dato.split(",");
                    switch (infoActividad[0]) {
                        case "PRODUCTO":
                            System.out.println("agregarlo al arreglo de repuestos");
                            agregarProducto(new producto(infoActividad[1], infoActividad[2]));
                            break;
                    }
                }
            }
        });
        //---------------------------------------------
        //-------------- Buton VER INVENTARIO -----------------

        //---------------------------------------------
        //-------------- Combo Box Datos -----------------
        btnVerInventario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirProducto();
                ActualizarComboBox(cmbDatos);
            }
        });
        btnDetalle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                consultarPrecio(cmbDatos);
            }
        });
        cmbDatos.setPreferredSize(new Dimension(200, 35));
        cmbDatos.setLocation(0, 0);
        //----------------------------------------------
        pnlPrincipal.add(btnCargarDatos);
        pnlPrincipal.add(btnVerInventario);
        pnlPrincipal.add(cmbDatos);
        pnlPrincipal.add(btnDetalle);

        this.add(pnlPrincipal);
    }

    public void agregarProducto(producto obj) {
        for (int i = 0; i < 50; i++) {
            if (inventario[i] == null) {
                inventario[i] = obj;
                return;
            }
        }
    }

    public void imprimirProducto() {
        System.out.println("-------------------------");
        for (int i = 0; i < 50; i++) {
            if (inventario[i] != null) {
                inventario[i].imprimir();
            }
        }
        System.out.println("--------------------------");
    }

    public void ActualizarComboBox(JComboBox combo) {
        combo.removeAllItems();
        for (int i = 0; i < 50; i++) {
            if (inventario[i] != null) {
                combo.addItem(inventario[i]);
            }
        }
    }

    public void consultarPrecio(JComboBox combo) {
        producto auxiliar = (producto)combo.getSelectedItem();
        JOptionPane.showMessageDialog(null, "El producto vale " + auxiliar.getValor()+", "+auxiliar.getNombre());

    }



}
