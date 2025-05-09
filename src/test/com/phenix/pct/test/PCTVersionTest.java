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
package com.phenix.pct.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

/**
 * PCTVersion tests
 */
public class PCTVersionTest extends BuildFileTestNg {
    private static final String PCT_REGEXP = "pct-\\d\\d\\d-.*-.*";

    @Test(groups = {"v11"})
    public void test1() {
        configureProject("PCTVersion/test1/build.xml");

        List<String> rexp = new ArrayList<>();
        rexp.add("PCT Version : " + PCT_REGEXP);
        expectLogRegexp("test", rexp, true);
    }

    @Test(groups = {"v11"})
    public void test2() {
        configureProject("PCTVersion/test2/build.xml");
        List<String> rexp = new ArrayList<>();
        rexp.add("Current PCT version: " + PCT_REGEXP);
        expectLogRegexp("test", rexp, true);
        assertPropertyMatches("pct.version", PCT_REGEXP);
    }

}