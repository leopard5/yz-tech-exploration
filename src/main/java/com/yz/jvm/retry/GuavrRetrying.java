package com.yz.jvm.retry;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavrRetrying {

    public static void main(String[] args) {
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // do something useful here
                System.out.println("call...");
                throw new RuntimeException();
            }
        };

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        System.out.println("第{ " + attempt.getAttemptNumber() + "}次调用失败");
                    }
                })
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
