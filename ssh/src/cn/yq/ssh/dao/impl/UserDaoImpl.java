package cn.yq.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.yq.ssh.dao.UserDao;
import cn.yq.ssh.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	/*
	 * 问题： SessionFactory对象如何创建?谁创建？
	 *  和Spring集成以后，工厂对象应该交给Spring创建，Hibernate和Spring集成
	 */
	@Resource
	private SessionFactory factory;

	@Override
	public void save(User user) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		
		//new User(id, null, null, null) : 有OID，不被Session管理： 游离状态
		
		session.delete(new User(id, null, null, null));
		
	}

	@Override
	public void update(User user) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public User get(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public List<User> list() {
		Session session = factory.getCurrentSession();
		String hql = "select u from User u";
		List<User> users = session.createQuery(hql, User.class).list();
		return users;
	}

}
