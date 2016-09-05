package com.claudioliveira.domain;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by claudio on 02/09/16.
 */
public class Humidity implements Comparable<Humidity>{

    @Getter
    private String uuid;

    @Getter
    private LocalDateTime measureAt;

    @Getter
    private Double value;

    public Humidity(String uuid, LocalDateTime measureAt, Double value) {
        this.uuid = uuid;
        this.measureAt = measureAt;
        this.value = value;
    }

    @Override
    public int compareTo(Humidity o) {
        return this.measureAt.compareTo(o.measureAt);
    }

}
