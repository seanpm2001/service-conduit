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
 * Original Codehaus Header
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
 * Original Apache Header
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
package org.sca4j.fabric.services.event;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.sca4j.spi.services.event.EventService;
import org.sca4j.spi.services.event.SCA4JEvent;
import org.sca4j.spi.services.event.SCA4JEventListener;

/**
 * @version $Rev: 148 $ $Date: 2007-06-02 05:10:48 +0100 (Sat, 02 Jun 2007) $
 */
public class EventServiceImplTestCase extends TestCase {
    private EventService service;
    private SCA4JEventListener listener;

    public void testSubscribeUnsubscribe() throws Exception {
        service.subscribe(MockEvent.class, listener);
        service.publish(new MockEvent());
        service.unsubscribe(MockEvent.class, listener);
        service.publish(new MockEvent());
        EasyMock.verify(listener);
    }


    @SuppressWarnings({"unchecked"})
    protected void setUp() throws Exception {
        super.setUp();
        service = new EventServiceImpl();
        listener = EasyMock.createStrictMock(SCA4JEventListener.class);
        listener.onEvent(EasyMock.isA(MockEvent.class));
        EasyMock.replay(listener);
    }

    private class MockEvent implements SCA4JEvent {

    }
}
