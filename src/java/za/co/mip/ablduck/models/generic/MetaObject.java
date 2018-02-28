/**
 * Copyright 2017-2018 MIP Holdings
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
package za.co.mip.ablduck.models.generic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaObject {

    @Expose
    @SerializedName("internal")
    public String internal = null;

    @Expose
    @SerializedName("private")
    public Boolean isPrivate = null;

    @Expose
    @SerializedName("protected")
    public Boolean isProtected = null;

    @Expose
    @SerializedName("static")
    public Boolean isStatic = null;

    @Expose
    @SerializedName("abstract")
    public Boolean isAbstract = null;

    @Expose
    @SerializedName("deprecated")
    public DeprecatedObject deprecated = null;
}
