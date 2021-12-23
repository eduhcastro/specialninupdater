/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;

import frames.logs;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Frame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import javax.swing.JOptionPane;
import models.LuaModel;

/**
 *
 * @author Matias
 */
public class Lua {

    private Boolean Start = false;
    private Boolean Finish = false;

    public StringBuilder selectFile(Frame event) throws FileNotFoundException {
        Start = false;
        Finish = false;
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("luac", "luac"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("lua", "lua"));

        int response = chooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(chooser.getSelectedFile().getAbsolutePath());

            Scanner myReader = new Scanner(file);
            Console.log(myReader);

            while (myReader.hasNextLine()) {
                //Console.log(Start);
                String data = myReader.nextLine();
                if (!Start) {
                    Boolean Check = LuaModel.checkStart(data);
                    //Console.log("Check:" + Check);
                    if (Check) {
                        //Console.log("OKK");
                        Start = true;
                    }

                }

                if (!Finish) {
                    Boolean Check = LuaModel.checkFinish(data);

                    if (Check) {
                        //Console.log("OKK2");
                        Finish = true;
                    }

                }

                if (Start && Finish) {
                    JOptionPane.showMessageDialog(null, "Lua(c) file loaded!");
                    break;
                }

                if (data.equals("")) {

                    JOptionPane.showMessageDialog(null, "Invalid Lua file!");
                    break;
                }

                //System.out.println(data);
            }
            myReader.close();
            StringBuilder fileBuilder = new StringBuilder(file.toString());
            return fileBuilder;
        } else {
            StringBuilder texto = new StringBuilder("Null");
            return texto;
        }
    }

    private static Boolean createFile(String path) throws IOException {
        File f = new File(path + "/inc_ver.lua");
        if (!f.exists()) {
            File myObj = new File(path + "/inc_ver.lua");
            return myObj.createNewFile();
        }
        return true;
    }

    public void createLuaAlone(String export, List<Object> files) throws IOException {
        if (createFile(export)) {
            try ( FileWriter myWriter = new FileWriter(export + "/inc_ver.lua")) {

                //int Count = files.size();
                int Count = 0;
                for (Object row : files) {
                    Count++;
                    if (Count == 1) {
                        myWriter.write("return {" + System.lineSeparator());
                    }
                    //myWriter.write();
                    myWriter.write(row.toString() + System.lineSeparator());
                    if (files.size() == Count) {
                        myWriter.write("}");
                    }
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Error to create Lua FILE!");
        }
    }

}
