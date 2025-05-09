/**
 * Copyright 2005-2025 Riverside Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.phenix.pct;

import java.util.ResourceBundle;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Echo;

public class Version extends Task {
    protected static final String BUNDLE_NAME = "com.phenix.pct.PCT"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private String property = null;

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public void execute() {
        String str = RESOURCE_BUNDLE.getString("PCTVersion");
        if (property != null) {
            getProject().setNewProperty(property, str);
        } else {
            Echo echo = new Echo();
            echo.bindToOwner(this);
            echo.setMessage("PCT Version : " + str);
            echo.execute();
        }
    }

    public static String getPCTVersion() {
    	return RESOURCE_BUNDLE.getString("PCTVersion");
    }
}
