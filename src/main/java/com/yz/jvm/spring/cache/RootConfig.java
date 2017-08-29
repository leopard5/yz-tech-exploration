package com.yz.jvm.spring.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching//开启声明式缓存支持
public class RootConfig {
    /**
     * 注册实现CacheManager的bean
     * EhCache的CacheManager要被注入到Spring的EhCacheCacheManager之中
     * @param cacheManager 由下面的EhCacheManagerFactoryBean提供
     * @return
     */

}
