/*******************************************************************************
 * Copyright 2016 Intuit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.intuit.wasabi.feedback;

import com.google.inject.AbstractModule;
import com.intuit.wasabi.feedback.impl.FeedbackImpl;
import com.intuit.wasabi.repository.cassandra.CassandraRepositoryModule;
import org.slf4j.Logger;

import static com.google.inject.Scopes.SINGLETON;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Implementation of Google guice's Module to configure and bind {@link Feedback} API objects.
 */
public class FeedbackModule extends AbstractModule {

    private static final Logger LOGGER = getLogger(FeedbackModule.class);

    @Override
    protected void configure() {
        LOGGER.debug("installing module: {}", FeedbackModule.class.getSimpleName());

        install(new CassandraRepositoryModule());

        bind(Feedback.class).to(FeedbackImpl.class).in(SINGLETON);

        LOGGER.debug("installed module: {}", FeedbackModule.class.getSimpleName());
    }
}
