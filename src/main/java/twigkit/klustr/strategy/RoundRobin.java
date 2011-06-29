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
package twigkit.klustr.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twigkit.klustr.ResourcesModificationException;

/**
 * Select resource from cluster by round-robin.
 * 
 */
public class RoundRobin<T> implements Strategy<T> {

	private static final Logger logger = LoggerFactory.getLogger(RoundRobin.class);

	private T[] resources;
	private int resourceToUse;

	public void setResources(T... resources) throws ResourcesModificationException {
		this.resources = resources;
	}

	public T next() {
		if (resourceToUse >= resources.length) {
			resourceToUse = 0;
		}

		T resource = resources[resourceToUse++];

		if (logger.isDebugEnabled()) {
			logger.debug("Using resource " + resource.getClass().getName() + "[" + resourceToUse + "]");
		}

		return resource;
	}

	public void reset() {
		resourceToUse = 0;
	}
}
