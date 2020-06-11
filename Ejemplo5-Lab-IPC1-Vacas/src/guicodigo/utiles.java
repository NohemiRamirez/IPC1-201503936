/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicodigo;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author elmer
 */
public class utiles {
    
    public static JButton CrearBoton(String texto, int ancho, int alto){
         JButton btn = new JButton(texto);
        btn.setPreferredSize(new Dimension(ancho, alto));
        return btn;
    }
}
