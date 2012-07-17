/*
 * Copyright 2010 Hjortur Stefan Olafsson
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
 *
 */
package twigkit.klustr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twigkit.klustr.strategy.RoundRobin;
import twigkit.klustr.strategy.Strategy;

/**
 * A class for managing access to multiple resources using a default {@link Strategy}.
 * 
 */
public class Cluster<T> {

    private static final Logger logger = LoggerFactory.getLogger(Cluster.class);

	private final Strategy<T> strategy;

	public Cluster(final T... resources) {
		this(new RoundRobin<T>(), resources);
	}

	public Cluster(final Strategy<T> strategy, T... resources) {
		this.strategy = strategy;
		try {
			strategy.setResources(resources);
		} catch (ResourcesModificationException e) {
			logger.error("Failed to set Strategy", e);
		}
	}

	public void setResources(final T... resources) throws ResourcesModificationException {
		throw new ResourcesModificationException();
	}

	public synchronized T next() {
		return strategy.next();
	}

	public void reset() {
		strategy.reset();
	}
}
