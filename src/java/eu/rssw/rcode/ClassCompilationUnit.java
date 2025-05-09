/**
 * Copyright 2011-2025 Riverside Software
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
package eu.rssw.rcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "unit", namespace = "")
public class ClassCompilationUnit {
    @XmlAttribute
    public String packageName;
    @XmlAttribute
    public String className;

    @XmlAttribute
    public String inherits;
    @XmlElement
    public List<String> interfaces = new ArrayList<>();

    @XmlAttribute
    public boolean isAbstract;
    @XmlAttribute
    public boolean isFinal;
    @XmlAttribute
    public boolean isInterface;
    @XmlAttribute
    public boolean isEnum;
    @XmlAttribute
    public boolean isSerializable;
    @XmlAttribute
    public boolean useWidgetPool;

    @XmlElement(name = "classComment")
    public List<String> classComment = new ArrayList<>();

    @XmlElement(name = "constructor")
    public List<Constructor> constructors = new ArrayList<>();
    @XmlElement(name = "destructor")
    public List<Destructor> destructors = new ArrayList<>();
    @XmlElement(name = "method")
    public List<Method> methods = new ArrayList<>();
    @XmlElement(name = "property")
    public List<Property> properties = new ArrayList<>();
    @XmlElement(name = "event")
    public List<Event> events = new ArrayList<>();
    @XmlElement(name = "using")
    public List<Using> usings = new ArrayList<>();
    @XmlElement(name = "member")
    public List<EnumMember> enumMembers = new ArrayList<>();

    @XmlElement(name = "temp-table")
    public List<TempTable> tts = new ArrayList<>();
    @XmlElement(name = "dataset")
    public List<Dataset> dss = new ArrayList<>();

    public void classToXML(File out) throws JAXBException, IOException {
        try (FileOutputStream fos = new FileOutputStream(out)) {
            JAXBContext context = JAXBContext.newInstance(AccessModifier.class,
                    ClassCompilationUnit.class, Constructor.class, Dataset.class, EnumMember.class,
                    Event.class, Function.class, GetSetModifier.class, Method.class,
                    Parameter.class, ParameterMode.class, Procedure.class,
                    ProcedureCompilationUnit.class, Property.class, TableField.class,
                    TableIndex.class, TempTable.class, Using.class, UsingType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, fos);
        }
    }

}
