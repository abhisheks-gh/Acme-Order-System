package com.acmeordersystem.domain;

// import com.acmeordersystem.utils.MyDate;

import java.time.LocalDate;

public interface Rushable {
    public abstract boolean isRushable(LocalDate orderDate, double amount);
}
