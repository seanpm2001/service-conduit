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
package org.sca4j.fabric.executor;

import java.util.HashMap;
import java.util.Map;

import org.osoa.sca.annotations.EagerInit;

import org.sca4j.spi.command.Command;
import org.sca4j.spi.executor.CommandExecutor;
import org.sca4j.spi.executor.CommandExecutorRegistry;
import org.sca4j.spi.executor.ExecutionException;

/**
 * Default implementation of the CommandExecutorRegistry
 *
 * @version $Rev: 3681 $ $Date: 2008-04-19 19:00:58 +0100 (Sat, 19 Apr 2008) $
 */
@EagerInit
public class CommandExecutorRegistryImpl implements CommandExecutorRegistry {
    private Map<Class<? extends Command>, CommandExecutor<?>> executors =
            new HashMap<Class<? extends Command>, CommandExecutor<?>>();

    public <T extends Command> void register(Class<T> type, CommandExecutor<T> executor) {
        executors.put(type, executor);
    }

    @SuppressWarnings({"unchecked"})
    public <T extends Command> void execute(T command) throws ExecutionException {
        Class<? extends Command> clazz = command.getClass();
        CommandExecutor<T> executor = (CommandExecutor<T>) executors.get(clazz);
        if (executor == null) {
            throw new ExecutorNotFoundException("No registered executor for command: " + clazz.getName(), clazz.getName());
        }
        executor.execute(command);
    }
}
