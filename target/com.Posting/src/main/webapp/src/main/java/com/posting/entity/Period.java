package com.posting.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Period {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "frequency", nullable = false)
    private int frequency;
    @Basic
    @Column(name = "time_unit", nullable = false, length = 50)
    private String timeUnit;

    public Period() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return id == period.id && frequency == period.frequency && Objects.equals(timeUnit, period.timeUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, frequency, timeUnit);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", timeUnit='" + timeUnit + '\'' +
                '}';
    }
}
