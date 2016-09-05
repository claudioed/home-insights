package com.claudioliveira.domain;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by claudio on 02/09/16.
 */
public class Temperature implements Comparable<Temperature>{

    @Getter
    private final String uuid;

    @Getter
    private final LocalDateTime measureAt;

    @Getter
    private final Double value;

    public Temperature(String uuid, LocalDateTime measureAt, Double value) {
        this.uuid = uuid;
        this.measureAt = measureAt;
        this.value = value;
    }

    @Override
    public int compareTo(Temperature o) {
        return this.measureAt.compareTo(o.measureAt);
    }

}
