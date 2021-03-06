/*
 * Copyright 2018 Onshape, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.memcached.jcache;

import java.util.Map;

import javax.cache.integration.CacheLoader;

public class MemcachedCacheLoader<K, V> implements javax.cache.integration.CacheLoader<K, V> {
    private final CacheLoader<K, V> delegate;

    public MemcachedCacheLoader(CacheLoader<K, V> delegate) {
        this.delegate = delegate;
    }

    @Override
    public V load(K key) {
        return delegate.load(key);
    }

    @Override
    public Map<K, V> loadAll(Iterable<? extends K> keys) {
        return delegate.loadAll(keys);
    }
}
