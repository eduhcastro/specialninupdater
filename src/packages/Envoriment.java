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

import java.io.File;
import javax.swing.JOptionPane;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;

/**
 *
 * @author Matias
 */
public class Envoriment {

    private static final String[] Keys = {"MEUGATONAOTEMNOME", "voceconseguiudescriptografar"};

    public static Object teste(String path) throws Exception {
        File f = new File(path + "/settings.ini");
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null, "File settings not found!");
            System.exit(0);
        }
        Ini ini = new Ini(new File(path + "/settings.ini"));
        java.util.prefs.Preferences prefs = new IniPreferences(ini);
        if (prefs.node("Start").get("keyacess", null) == null) {
            JOptionPane.showMessageDialog(null, "Invalid method login!");
            System.exit(0);
        }
        int start = 0;
        for (String key : Keys) {
            start++;
            if (key == null ? prefs.node("Start").get("keyacess", null) == null : key.equals(prefs.node("Start").get("keyacess", null))) {
                return prefs;
            }
            if (Keys.length == start) {
                JOptionPane.showMessageDialog(null, "Invalid Key");
                System.exit(0);
            }
        }
        return prefs;
    }

    public Envoriment() {
        try {
            String dir = System.getProperty("user.dir");
            teste(dir);

        } catch (Exception err) {
            Console.log("Err" + err);
        }
    }

}
