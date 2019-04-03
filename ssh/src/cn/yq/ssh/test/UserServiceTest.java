package cn.yq.ssh.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yq.ssh.domain.User;
import cn.yq.ssh.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {
	
	@Resource
	private UserService service;

	@Test
	public void testSave() {
		User user = new User(null, "zhangwuji", "zhangwuji", "zhangwuji@qq.com");
		service.save(user);
	}

	@Test
	public void testDelete() {
		service.delete(1);
	}

	@Test
	public void testUpdate() {
		User user = new User(2, "zhaomin", "zhaomin", "zhaomin@qq.com");
		service.update(user);
	}

	@Test
	public void testGet() {
		User user = service.get(1);
		System.out.println(user);
	}
	@Test
	public void testList() {
		List<User> list = service.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
