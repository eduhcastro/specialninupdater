/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import packages.Console;

/**
 *
 * @author Matias
 */
public class LuaModel {

    private final static String[] Start = {"return{", "return {"};
    private final static String[] Finish = {"}"};

    public static Boolean checkStart(String lua) {
        Boolean Result = false;
        //Console.log("Lua1 " + lua);
        for (String element : Start) {
            //Console.log("Element1 " + element);
            int intIndex = lua.indexOf(element);
            Result = intIndex >= 0;
            //logs.setLog("Elemento 1 encontrado");
            //Console.log("Elemento 1 encontrado");
        }
        return Result;
    }

    public static Boolean checkFinish(String lua) {
        Boolean Result = false;
        //Console.log("Lua2 " + lua);
        for (String element : Finish) {
            //Console.log("Element2 " + element);
            Result = lua == null ? element == null : lua.equals(element);
            //Console.log("Elemento 2 encontrado");
        }
        return Result;
    }

}
