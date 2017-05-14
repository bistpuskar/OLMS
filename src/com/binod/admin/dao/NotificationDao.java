package com.bhim.admin.dao;

import java.util.List;

import com.bhim.admin.entity.Notification;

public interface NotificationDao {
public List<Notification> getAllNotification();
public void deleteNotification(int id);
}
