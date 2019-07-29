package com.example.demo.metrics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDemo {


    private Integer count1 = 0;

    private Integer count2 = 0;

    private Integer count3 = 0;

    @Autowired
    private CharlesMetrics charlesMetrics;



    @Async("One")
    @Scheduled(fixedDelay = 1000)
    public void increment1() {
        count1++;
        charlesMetrics.counter1.increment();
        charlesMetrics.map.put("x", Double.valueOf(count1));//将counter1的值放到Gauge中，反应应用的当前指标，比如主机当前空闲的内存大小(node_memory_MemFree)
        System.out.println("increment1 count:" + count1);
    }

    @Async("Two")
    @Scheduled(fixedDelay = 10000)
    public void increment2() {
        count2++;
        charlesMetrics.counter2.increment();
        System.out.println("task2 count:" + count2);
        System.out.println("increment2 count:" + count2);
    }

    @Async("Three")
    @Scheduled(fixedDelay = 20000)
    public void increment3() {
        count3++;
        charlesMetrics.counter3.increment();
        System.out.println("task2 count:" + count2);
        System.out.println("increment3 count:" + count3);
    }

}
