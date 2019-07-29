package com.example.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CharlesMetrics implements MeterBinder {

    public Counter counter1;
    public Counter counter2;
    public Counter counter3;

    public Map<String,Double> map;

    CharlesMetrics() {
        map = new HashMap<>();
    }


    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.counter1 = Counter.builder("charles.demo.counter").tags(new String[]{"name","counter1"}).description("This is the first counter").register(meterRegistry);
        this.counter2 = Counter.builder("charles.demo.counter").tags(new String[]{"name","counter2"}).description("This is the second counter").register(meterRegistry);
        this.counter3 = Counter.builder("charles.demo.counter").tags(new String[]{"name","counter3"}).description("This is the third counter").register(meterRegistry);

        Gauge.builder("charles.demo.gauge",map,x->x.get("x")).tags("name","gauge1").description("This is Gauge").register(meterRegistry);
    }
}
