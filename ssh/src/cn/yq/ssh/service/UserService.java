package cn.yq.ssh.service;

import java.util.List;

import cn.yq.ssh.domain.User;

public interface UserService {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User get(Integer id);
	List<User> list();
}