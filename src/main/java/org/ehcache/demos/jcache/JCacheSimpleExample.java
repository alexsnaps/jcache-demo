package org.ehcache.demos.jcache;

import org.ehcache.demos.domain.Person;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;

/**
 * @author Alex Snaps
 */
public class JCacheSimpleExample implements AutoCloseable {

    private final CacheManager cacheManager;
    private final Cache<String, Person> testCache;

    public JCacheSimpleExample() {

        cacheManager = Caching.getCachingProvider()
            .getCacheManager();

        testCache = cacheManager.createCache("test",
            new MutableConfiguration<String, Person>().setTypes(String.class, Person.class)
                .setStoreByValue(false)
        );
    }

    public void simplePutGet() {
        final Person me = new Person("Alex", "Snaps", "Terracotta");
        testCache.put("me", me);
        final Person cachedMe = testCache.get("me");
        System.out.println(cachedMe == me);
        System.out.println(cachedMe);
    }

    @Override
    public void close() throws Exception {
        cacheManager.close();
    }

    public static void main(String[] args) throws Exception {
        try(JCacheSimpleExample example = new JCacheSimpleExample()) {
            example.simplePutGet();
        }
    }
}
