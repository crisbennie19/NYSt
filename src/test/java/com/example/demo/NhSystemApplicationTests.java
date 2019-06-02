package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhSystemApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Before
	public void initDb() {
		{
			User newUser = new User("akowechristianUser@gmail.com", "Akowe", "benedict21");
			userService.createUser(newUser);
		}
		{
			User newAdmin = new User("akowechristianAdmin@gmail.com", "Admin", "Admin");
			userService.createUser(newAdmin);
		}
		Task newTask = new Task("23/05/2019", "10:20", "13:30", "You need to work today");
		User user = userService.findOneUser("akowechristianUser@gmail.com");
		taskService.AddTask(newTask, user);
	}

	@Test
	public void testUser() {

		User user = userService.findOneUser("akowechristianUser@gmail.com");
		System.out.println("======== printing user" + user + "=====");
		assertNotNull(user);

		User admin = userService.findOneUser("akowechristianAdmin@gmail.com");
		assertEquals(admin.getEmail(), "akowechristianAdmin@gmail.com");

	}

	@Test
	public void testTask() {

		User user = userService.findOneUser("akowechristianUser@gmail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);

	}

}
