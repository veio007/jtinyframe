package com.veio007.jtinyframe.base;

import org.softee.management.annotation.Description;
import org.softee.management.annotation.MBean;
import org.softee.management.annotation.ManagedAttribute;
import org.softee.management.exception.ManagementException;
import org.softee.management.helper.MBeanRegistration;

import javax.management.ObjectName;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 带jmx监控的线程池
 *
 * @author ww
 * @version [版本号, 2017/6/5]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@MBean
@Description("MBeanThreadPoolExecutor")
public class MBeanThreadPoolExecutor extends ThreadPoolExecutor {

    private AtomicLong taskCount = new AtomicLong();
    private AtomicLong completedCount = new AtomicLong();
    private AtomicInteger queueSize = new AtomicInteger();
    private CustomRejectedExecutionHandler rejectHandler = null;
    MBeanRegistration registration;

    public MBeanThreadPoolExecutor(String objectName, int corePoolSize) {
        this(objectName, corePoolSize, Integer.MAX_VALUE);
    }

    public MBeanThreadPoolExecutor(String objectName, int corePoolSize, int limit) {
        this(objectName, corePoolSize, corePoolSize, limit, new ThreadFactory() {
            private final AtomicLong count = new AtomicLong();

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, objectName + "-" + count.get());
                t.setDaemon(true);
                return t;
            }
        });
    }

    public MBeanThreadPoolExecutor(String objectName, int corePoolSize, int maximumPoolSize, int limit, ThreadFactory tf) {
        this(objectName, corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(limit),
                tf,
                new DiscardPolicy());
    }

    public MBeanThreadPoolExecutor(String objectName, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new CustomRejectedExecutionHandler(handler));
        rejectHandler = (CustomRejectedExecutionHandler) this.getRejectedExecutionHandler();
        try {
            registration = new MBeanRegistration(this, new ObjectName("ThreadPoolExecutor:name=" + objectName));
            registration.register();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        super.shutdown();
        try {
            if (registration != null) {
                registration.unregister();
            }
        } catch (ManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(Runnable command) {
        try {
            super.execute(command);
            queueSize.incrementAndGet();
        } finally {
            taskCount.incrementAndGet();
        }
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        queueSize.decrementAndGet();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        completedCount.incrementAndGet();
        if (t != null) {
            // log error
        }
    }

    @ManagedAttribute
    @Description("Returns the approximate number of threads that are actively executing tasks.")
    public int getActiveCount4Jmx() {
        return this.getActiveCount();
    }

    @ManagedAttribute
    @Description("Returns the approximate total number of tasks that have completed execution. Because the states of tasks and threads may change dynamically during computation, the returned value is only an approximation, but one that does not ever decrease across successive calls.")
    public long getCompletedTaskCount4Jmx() {
        return completedCount.get();
    }

    @ManagedAttribute
    @Description("Returns the largest number of threads that have ever simultaneously been in the pool.")
    public int getLargestPoolSize4Jmx() {
        return this.getLargestPoolSize();
    }

    @ManagedAttribute
    @Description("Returns the current number of threads in the pool.")
    public int getPoolSize4Jmx() {
        return this.getPoolSize();
    }

    @ManagedAttribute
    @Description("Returns the approximate total number of tasks that have ever been scheduled for execution. Because the states of tasks and threads may change dynamically during computation, the returned value is only an approximation.")
    public long getTaskCount4Jmx() {
        return taskCount.get();
    }

    @ManagedAttribute
    @Description("Returns the current number of tasks that have ever simultaneously been in the queue.")
    public int getQueueSize4Jmx() {
        //return this.getQueue().size();
        return queueSize.get();
    }

    @ManagedAttribute
    @Description("Returns the reject number of the pool.")
    public long getRejectCount() {
        if (rejectHandler != null) {
            return rejectHandler.getRejectCount();
        } else {
            return 0;
        }
    }

    public static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        private AtomicLong rejectNumber = new AtomicLong();
        public RejectedExecutionHandler handler;

        public CustomRejectedExecutionHandler(RejectedExecutionHandler handler) {
            this.handler = handler;
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            rejectNumber.incrementAndGet();
            handler.rejectedExecution(r, executor);
            ((MBeanThreadPoolExecutor) executor).queueSize.decrementAndGet();
        }

        public long getRejectCount() {
            return rejectNumber.get();
        }
    }
}