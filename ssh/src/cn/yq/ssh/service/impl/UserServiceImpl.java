package cn.yq.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yq.ssh.dao.UserDao;
import cn.yq.ssh.domain.User;
import cn.yq.ssh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	//@Autowired //spring
	@Resource
	private UserDao dao;

	@Override
	public void save(User user) {
		dao.save(user);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public User get(Integer id) {
		
		return dao.get(id);
	}

	@Override
	public List<User> list() {
		return dao.list();
	}

}
