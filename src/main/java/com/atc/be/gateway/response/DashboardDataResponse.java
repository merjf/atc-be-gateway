package com.atc.be.gateway.response;

import com.atc.be.gateway.response.model.Value;
import lombok.Data;

import java.util.List;
@Data
public class DashboardDataResponse {

    public List<Value> generalValues;
    public List<Value> weekAmounts;
    public List<Value> yearIncomeOutcome;
    public List<Value> salaries;
    public List<Value> amazonExpenses;
    public List<Value> outcomePerType;
}
