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
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.sca4j.binding.jms.common;

/**
 * ModelObject represents binding.jms\headers and
 * binding.jms\operationProperties\headers.
 */
public class HeadersDefinition extends PropertyAwareObject {
    private static final long serialVersionUID = 831415808031924363L;
    private String jMSType;
    private String jMSCorrelationId;
    private Integer jMSDeliveryMode;
    private Long jMSTimeToLive;
    private Integer jMSPriority;

    public String getJMSType() {
        return jMSType;
    }

    public void setJMSType(String type) {
        jMSType = type;
    }

    public String getJMSCorrelationId() {
        return jMSCorrelationId;
    }

    public void setJMSCorrelationId(String correlationId) {
        jMSCorrelationId = correlationId;
    }

    public Integer getJMSDeliveryMode() {
        return jMSDeliveryMode;
    }

    public void setJMSDeliveryMode(Integer deliveryMode) {
        jMSDeliveryMode = deliveryMode;
    }

    public Long getJMSTimeToLive() {
        return jMSTimeToLive;
    }

    public void setJMSTimeToLive(Long timeToLive) {
        jMSTimeToLive = timeToLive;
    }

    public Integer getJMSPriority() {
        return jMSPriority;
    }

    public void setJMSPriority(Integer priority) {
        jMSPriority = priority;
    }

    /**
     * 
     * Clone a new HeadersDefinition.
     */
    public HeadersDefinition cloneHeadersDefinition() {
        HeadersDefinition clone = new HeadersDefinition();
        clone.setJMSCorrelationId(this.jMSCorrelationId);
        clone.setJMSDeliveryMode(this.jMSDeliveryMode);
        clone.setJMSPriority(this.jMSPriority);
        clone.setJMSTimeToLive(this.jMSTimeToLive);
        clone.setJMSType(this.jMSType);
        clone.setProperties(this.getProperties());
        return clone;
    }

    /**
     * Return a new HeadersDefinition which value is <code>this</code> is
     * shadowed by <code>from</code>
     */
    public HeadersDefinition shadowHeadersDefinition(HeadersDefinition from) {
        HeadersDefinition result = this.cloneHeadersDefinition();
        if (from.jMSCorrelationId != null) {
            result.setJMSCorrelationId(from.jMSCorrelationId);
        }
        if (from.jMSType != null) {
            result.setJMSType(from.jMSType);
        }
        if (from.jMSDeliveryMode != null) {
            result.setJMSDeliveryMode(from.jMSDeliveryMode);
        }
        if (from.jMSPriority != null) {
            result.setJMSPriority(from.jMSPriority);
        }
        if (from.jMSTimeToLive != null) {
            result.setJMSTimeToLive(from.jMSTimeToLive);
        }
        result.setProperties(from.getProperties());
        return result;
    }
}
