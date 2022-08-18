package com.acmeordersystem.domain;

import com.acmeordersystem.utils.MyDate;

public interface Rushable {
    public abstract boolean isRushable(MyDate orderDate, double amount);
}
