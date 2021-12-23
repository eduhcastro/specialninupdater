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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConfigModel;
import frames.logs;

/**
 *
 * @author Matias
 */
public class Config {

    /**
     *
     * @param version
     * @param path
     * @param logsPrivate
     */
    public void Create(int version, String path, logs logsPrivate) {
        ConfigModel model = new ConfigModel();
        try {
            model.Handler(version, path);
            logsPrivate.setLog("Config file created");
        } catch (IOException ex) {
             logsPrivate.setLog("Config file error: "+ex);
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
