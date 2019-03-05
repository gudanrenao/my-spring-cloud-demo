package com.spring.microservice.hystrix.demo.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.spring.microservice.domain.User;
import com.spring.microservice.hystrix.demo.service.HystrixDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/28 1:37 PM
 * @Version 1.0
 **/
@RestController
public class HystrixTestController {

    private static final Random random = new Random();
    private static String cacheKeyPrefix = "cache:";
    private static AtomicLong atomicInteger = new AtomicLong(1);

    private final HystrixDemoService hystrixDemoService;

    public HystrixTestController(HystrixDemoService hystrixDemoService) {
        this.hystrixDemoService = hystrixDemoService;
    }

    /**
     * 测试短路器，fallback方法为{@link #indexFallback}
     *
     * @return
     */
    @GetMapping("/index")
    @HystrixCommand(fallbackMethod = "indexFallback", //服务降级处理逻辑
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
//            },
            ignoreExceptions = {IndexOutOfBoundsException.class}, //这些异常不会触发服务降级
            groupKey = "groupKeyDemo",//组名，默认一个组的命令使用同一个线程池
            commandKey = "commandKeyDemo",
            //建议设置ThreadPoolKey,设置后，同一个threadPoolKey使用一个线程池
            threadPoolKey = "threadPoolKeyDemo"
    )
    public String index(@RequestParam(required = false) String name
    ) throws InterruptedException {
        int nextInt = random.nextInt(200);
        System.out.println("thread sleep " + nextInt + " ms");
//        Thread.sleep(nextInt);
//        if (nextInt >= 100) {
//            if (nextInt > 150) {
//                throw new RuntimeException("你是个坏人");
//            } else {
//                throw new RuntimeException("runtime bad man");
//            }
//        }

        try {
            User user = hystrixDemoService.indexUser(new User(atomicInteger.getAndIncrement(), name));
            hystrixDemoService.indexUser(new User(atomicInteger.get(), name));
            hystrixDemoService.indexUser(new User(atomicInteger.get(), name));
            hystrixDemoService.updateUser(new User(atomicInteger.get(), name));
            hystrixDemoService.indexUser(new User(atomicInteger.get(), name));
            return "this is index page : " + user;
        } catch (UndeclaredThrowableException e) {
            e.printStackTrace();
        }
        return null;

    }


    public String getCacheKeyMethod(User user) {
        return cacheKeyPrefix + user.getId();
    }

    public String getCacheKeyMethod2(String id) {
        return cacheKeyPrefix + id;
    }

    @GetMapping("/index2")
    public String index2(@RequestParam String id) {
        return new IndexFallBack(id).execute();
    }


    private static class IndexFallBack extends com.netflix.hystrix.HystrixCommand<String> {

        private final String id;

        private static HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("commandKeyDemo");

        IndexFallBack(String id) {

//            super(HystrixCommandGroupKey.Factory.asKey("index2FallBack"), 100);
            super(Setter.withGroupKey(
                    //组名，默认一个组的命令使用同一个线程池
                    HystrixCommandGroupKey.Factory.asKey("groupKeyDemo"))
                    //命令名字
                    .andCommandKey(commandKey)
                    //建议设置ThreadPoolKey,设置后，同一个threadPoolKey使用一个线程池
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadPoolKeyDemo")));
            this.id = id;
        }

        @Override
        protected String run() throws Exception {
            int nextInt = random.nextInt(100);
            System.out.println("index2.......thread sleep " + nextInt + " ms");
            Thread.sleep(nextInt);
            return "this is index2 page...............";
        }

        /**
         * 同步执行
         *
         * @return
         */
        @Override
        public String execute() {
            return super.execute();
        }

        /**
         * 异步执行
         */
        @Override
        public Future<String> queue() {
            return super.queue();
        }

        @Override
        public Observable<String> toObservable() {
            return super.toObservable();
        }

        /**
         * 降级处理
         *
         * @return
         */
        @Override
        protected String getFallback() {
            Throwable exception = getExecutionException();
            //可以通过异常类型变化处理逻辑
            return HystrixTestController.indexFallback(id, exception);
        }

        /**
         * 刷新缓存，可以在另一个修改数据的HystrixCommand中调用，使对应的资源从缓存中删除
         *
         * @param id
         */
        public static void flushCache(String id) {
            HystrixRequestCache.getInstance(commandKey, HystrixConcurrencyStrategyDefault.getInstance())
                    .clear(cacheKeyPrefix + id);
        }

        /**
         * 请求缓存
         * Key to be used for request caching.
         * <p>
         * By default this returns null which means "do not cache".
         * <p>
         * To enable caching override this method and return a string key uniquely representing the state of a command instance.
         * <p>
         * If multiple command instances in the same request scope match keys then only the first will be executed and all others returned from cache.
         * 必须是同一个用户请求的上下文中，如果多次请求，key相同的第二个及之后的会直接使用缓存数据，不会实际请求
         * 缓存请求在run()和construct()执行前生效，所以可以有效减少不必要的线程开销
         *
         * @return cacheKey
         */
        @Override
        protected String getCacheKey() {
            return cacheKeyPrefix + id;
        }
    }

    /**
     * 服务降级处理方法，可以在入参中添加Throwable参数，获取触发服务降级的具体异常内容
     *
     * @return
     */
    private static String indexFallback(String name, Throwable throwable) {
        System.out.println("indexFallback Throwable class is : " + throwable);
        System.out.println("indexFallback param name is : " + name);
        return "query fallback error";
    }
}