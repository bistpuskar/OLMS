package com.binod.admin.dao;

import com.binod.admin.entity.FinePerDaySetting;

public interface FineDaySettingDao {
public void addFinePerDay(FinePerDaySetting setting);
public FinePerDaySetting getAlldays();
}
