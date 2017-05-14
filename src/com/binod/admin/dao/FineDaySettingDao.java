package com.bhim.admin.dao;

import com.bhim.admin.entity.FinePerDaySetting;

public interface FineDaySettingDao {
public void addFinePerDay(FinePerDaySetting setting);
public FinePerDaySetting getAlldays();
}
