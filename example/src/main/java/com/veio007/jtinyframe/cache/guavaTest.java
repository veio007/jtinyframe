package com.veio007.jtinyframe.cache;


import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class guavaTest {
    private static final LoadingCache<Integer,Integer> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .removalListener(new RemovalListener<Integer,Integer>() {
                @Override
                public void onRemoval(RemovalNotification<Integer, Integer> removalNotification) {
                    System.out.println(removalNotification);
                }
            })
            .build(
            new CacheLoader<Integer,Integer>() {
                @Override
                public Integer load(Integer integer) throws Exception {
                    return null;
                }
            }
    );

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        cache.put(1,2);
        cache.put(2,3);
        while(true) {
            System.out.println(cache.get(1));
            Thread.sleep(1000);
        }
    }
}
