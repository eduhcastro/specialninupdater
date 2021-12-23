/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packages;

import java.nio.file.Files;
import java.nio.file.Path;
//import javax.swing.JOptionPane;
import java.io.File;
///import java.util.ArrayList;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
////import java.awt.Frame;

import java.io.IOException;
import java.nio.file.Paths;
//import java.nio.file.attribute.BasicFileAttributeView;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.nio.file.attribute.FileTime;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import packages.Lua;

/**
 *
 * @author Matias
 */
public class SourcePackage {

    private static final List<Object> Lua = new ArrayList<>();

    private static String getFilePath(String path, String origin) {
        path = path.replace(origin, "");
        path = path.replace(":/", "SEPARADOR");
        return path;
    }

    private static String convertToOK(String origin) {
        return origin.replace("\\", "SEPERATOR");
    }

    public static Object[] getCreationDetails(String file) {
        File f = new File(file);
        if (f.exists()) {
            Object[] resultado = {f.getName(), f.getAbsolutePath(), f.length()};
            return resultado;
        } else {
            Object[] resultado = {};
            return resultado;
        }
    }

    public static void addMember(String x) {
        Lua.add(x);
    }

    public static List<Object> Execute(String origin, String destin, String version) throws IOException, Exception {
        //Cmd.execute();
        Console.log("Entrei aqui");
        Path path = Paths.get(origin);
        List<Path> paths = listFiles(path);
        int start = 0;
        List<Object> Retorno = new ArrayList<>();

        for (Path achive : paths) {

            start++;

            /**
             * Getting File Details
             */
            Object[] Details = getCreationDetails(achive.toString());

            /**
             * Files Details
             */
            String sizeF = Details[2].toString();
            //String nameF = Details[0].toString();
            //String pathF = Details[1].toString();

            String patchado = achive.toString();
            String replacado = getFilePath(patchado, origin); // Remove o G:\Biblioteca10\Documentos\FirstSource //Console.log(replacado);
            String convetido = convertToOK(replacado);
            String[] Splitado = convetido.split("SEPERATOR");

            for (String elemeto : Splitado) {
                String random = StringUtils.generateRandomString(); // nome randomico
                if (elemeto.contains(".")) {
                    String oldfile = Splitado[Splitado.length - 1]; // arquivo
                    String[] separacao = replacado.split(oldfile); // separando o path - arquivo.arquivo

                    addMember("['" + replacado.substring(1) + "']={file='" + random + "',size=" + sizeF + ",ver="+version+"},");
                    Cmd.CopyUpdaterFiles(patchado, destin, separacao[0], random); // criando pastas, copiando arquivos

                    //Console.log("File: " + elemeto);
                    //Console.log("File Old: " + oldfile);
                    //Console.log("Separacao: " + separacao[0]);
                }
            }

            //Console.log("Nome gerado:" + random);
            //Console.log("Arquivo original:" + achive);
            //Console.log(replacado.split("SEPARADOR")[replacado.split("SEPARADOR").length - 1]);
            //Console.log("Filtrado" + filtrado);
            //Console.log("Patchado " + patchado);
            //Console.log("Path " + pathh);
            //Console.log(explodido);
            //Console.log("Nome gerado:" + random);
            if (paths.size() == start) {
                Retorno = Lua;
                Cmd.ReneameFolderUpdater(destin);
            }

        }
        return Retorno;
        //List<String> explodido = paths.split(pathh);
        //Console.log(paths);
    }

    // list all files from this path
    public static List<Path> listFiles(Path path) throws IOException {

        List<Path> result;
        try ( Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }

//    /*
//     * Checking existing folder path
//     */
//    private static boolean checkFolderExisting(Path path) {
//        System.out.println(Files.exists(path));
//        System.out.println(path);
//        if (!Files.exists(path)) {
//            return false;
//        }
//        return true;
//    }
//
//
//    private static void getAllFromPath(String path) {
//
//        File directoryPath = new File(path);
//
//        File filesList[] = directoryPath.listFiles();
//        ArrayList files = null;
//        String json = "{\"results\":[{\"lat\":\"value\",\"lon\":\"value\" }, { \"lat\":\"value\", \"lon\":\"value\"}]}";
//
//        for (File file : filesList) {
//            if (file.isFile()) {
//                System.out.println("File name: " + file.getName());
//                System.out.println("File path: " + file.getAbsolutePath());
//                System.out.println("Size :" + file.getTotalSpace());
//
//               
//            } else if (file.isDirectory()) {
//
//                getAllFromPath(file.getAbsolutePath());
//                File tempDirectory = new File(file.getAbsolutePath());
//                File tempfilesList[] = directoryPath.listFiles();
//                for(File filetwo: tempfilesList){
//                     if(file.isFile()) {
//                           System.out.println("File name: "+file.getName());
//                           System.out.println("File path: "+file.getAbsolutePath());
//                           System.out.println("Size :"+file.getTotalSpace());
//                     }
//                }
//
//            }
//
//            System.out.println(" ");
//        }
//    }
//
//    public static boolean Convert(String version, Path source, Frame... logframe) {
//
//        boolean result;
//        Log = false;
//
//        try {
//
//            if (logframe != null) {
//                Log = true;
//            }
//
//            if (!checkFolderExisting(source)) {
//
//                result = false;
//                JOptionPane.showMessageDialog(null, "Invalid Path Source");
//                throw new Exception("Invalid Path Source");
//
//            }
//
//            getAllFromPath(source.toString());
//
//            return true;
//
//        } catch (Exception e) {
//            result = false;
//            System.out.println(e);
//        }
//        return result;
//    }
}
