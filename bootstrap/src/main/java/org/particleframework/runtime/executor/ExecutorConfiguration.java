/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.particleframework.runtime.executor;

import javax.validation.constraints.Min;
import java.util.Optional;
import java.util.concurrent.ThreadFactory;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
public interface ExecutorConfiguration {
    /**
     * @return The {@link ExecutorType}
     */
    ExecutorType getType();

    /**
     * @return The parallelism for {@link ExecutorType#WORK_STEALING}
     */
    @Min(1L) Integer getParallelism();

    /**
     * @return The number of threads for {@link ExecutorType#FIXED}
     */
    @Min(1L) Integer getNumberOfThreads();

    /**
     * @return The core pool size for {@link ExecutorType#SCHEDULED}
     */
    @Min(1L) Integer getCorePoolSize();

    /**
     * @return The class to use as the {@link ThreadFactory}
     */
    Optional<Class<? extends ThreadFactory>> getThreadFactoryClass();
}