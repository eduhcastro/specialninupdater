/*
 * Copyright 2021 Matias.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package packages;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Matias
 */
public class Cmd {

//    public static void Copy(String origin, String destin) throws Exception {
//        ProcessBuilder builder = new ProcessBuilder(
//                "cmd.exe", "/c", "Xcopy "+origin+" "+destin+" /E /H /C /I\n");
//        builder.redirectErrorStream(true);
//        Process p = builder.start();
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        while (true) {
//            line = r.readLine();
//            if (line == null) {
//                break;
//            }
//            System.out.println(line);
//        }
//        // md e:\example\asd\x
//    }
    public static void ReneameFolderUpdater(String destin) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd /D "+destin+" && for /r %x in (*.*) do ren \"%x\" *.g");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            //System.out.println(line);
        }
    }

    public static void CopyUpdaterFiles(String origin, String destin, String newpath, String file) throws Exception {
//        Console.log("CMD ORIGIN:" + origin);
//        Console.log("CMD DESTIN:" + destin);
//        Console.log("CMD FILE:" + file);
        //xcopy G:\Biblioteca10\Documentos\Expression\libDragonb.f G:\Biblioteca10\Documentos\Expression\puta\asdasd.g*
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "xcopy " + origin + " " + destin + "" + newpath + "" + file + ".g*");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            //System.out.println(line);
        }
        // md e:\example\asd\x
    }

}
