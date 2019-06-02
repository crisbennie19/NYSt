package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.repositories.TaskRepository;

@Service
public class TaskService {
	
 @Autowired
 private TaskRepository taskRepository;
 
 public void AddTask(Task task, User user) {
	 
	 task.setUser(user);
	 taskRepository.save(task);
	 
 }
 public List<Task> findUserTask(User user){
	 
	return taskRepository.findByUser(user);
 }
}
