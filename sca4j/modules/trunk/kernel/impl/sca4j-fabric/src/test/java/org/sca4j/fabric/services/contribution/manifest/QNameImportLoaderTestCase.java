/**
 * SCA4J
 * Copyright (c) 2009 - 2099 Service Symphony Ltd
 *
 * Licensed to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  A copy of the license
 * is included in this distrubtion or you may obtain a copy at
 *
 *    http://www.opensource.org/licenses/apache2.0.php
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * This project contains code licensed from the Apache Software Foundation under
 * the Apache License, Version 2.0 and original code from project contributors.
 *
 *
 * ---- Original Codehaus Header ----
 *
 * Copyright (c) 2007 - 2008 fabric3 project contributors
 *
 * Licensed to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  A copy of the license
 * is included in this distrubtion or you may obtain a copy at
 *
 *    http://www.opensource.org/licenses/apache2.0.php
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * This project contains code licensed from the Apache Software Foundation under
 * the Apache License, Version 2.0 and original code from project contributors.
 *
 * ---- Original Apache Header ----
 *
 * Copyright (c) 2005 - 2006 The Apache Software Foundation
 *
 * Apache Tuscany is an effort undergoing incubation at The Apache Software
 * Foundation (ASF), sponsored by the Apache Web Services PMC. Incubation is
 * required of all newly accepted projects until a further review indicates that
 * the infrastructure, communications, and decision making process have stabilized
 * in a manner consistent with other successful ASF projects. While incubation
 * status is not necessarily a reflection of the completeness or stability of the
 * code, it does indicate that the project has yet to be fully endorsed by the ASF.
 *
 * This product includes software developed by
 * The Apache Software Foundation (http://www.apache.org/).
 */
package org.sca4j.fabric.services.contribution.manifest;

import java.net.URI;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

import junit.framework.TestCase;
import org.easymock.EasyMock;

import org.sca4j.spi.services.contribution.QNameImport;

/**
 * @version $Rev: 5137 $ $Date: 2008-08-02 08:54:51 +0100 (Sat, 02 Aug 2008) $
 */
public class QNameImportLoaderTestCase extends TestCase {
    private static final QName QNAME = new QName("namespace");
    private static final URI LOCATION = URI.create("location");
    private QNameImportLoader loader = new QNameImportLoader();
    private XMLStreamReader reader;

    public void testRead() throws Exception {
        QNameImport qimport = loader.load(reader, null);
        assertEquals(QNAME, qimport.getNamespace());
        assertEquals(LOCATION, qimport.getLocation());
    }


    protected void setUp() throws Exception {
        super.setUp();
        reader = EasyMock.createMock(XMLStreamReader.class);
        EasyMock.expect(reader.getAttributeCount()).andReturn(0);
        EasyMock.expect(reader.getAttributeValue(null, "namespace")).andReturn("namespace");
        EasyMock.expect(reader.getAttributeValue(null, "location")).andReturn("location");
        EasyMock.replay(reader);
    }
}
