package com.binod.admin.dao;

import java.util.List;

import com.binod.admin.entity.Notification;

public interface NotificationDao {
public List<Notification> getAllNotification();
public void deleteNotification(int id);
}
