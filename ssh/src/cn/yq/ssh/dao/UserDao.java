package cn.yq.ssh.dao;

import java.util.List;

import cn.yq.ssh.domain.User;

public interface UserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User get(Integer id);
	List<User> list();
}