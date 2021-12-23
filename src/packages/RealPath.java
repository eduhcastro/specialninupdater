/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;

import java.awt.Frame;
import javax.swing.JFileChooser;

/**
 *
 * @author Matias
 */
public class RealPath {

    public String get(Frame evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(evt) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().toString();
//            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
//            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            return "Null";
        }
    }
}
