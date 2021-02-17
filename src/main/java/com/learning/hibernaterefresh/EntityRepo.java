package com.learning.hibernaterefresh;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.hibernaterefresh.entity.Post;
import com.learning.hibernaterefresh.entity.User;

@Transactional
@Repository
public class EntityRepo {

	@Autowired
	EntityManager entityManager;

	public long savePost() {
		Post entity = new Post();
		entity.setDetails("New Post");
		entityManager.persist(entity);
		return entity.getId();
	}

	public long persistUser() {
		User entity = new User();
		entity.setName("New User");
		entityManager.persist(entity);
		return entity.getId();
	}

	public long saveUser() {
		User entity = new User();
		entity.setName("New User");
		Session session = getSession();
		long a = (Long) session.save(entity);
		return a;
	}

	private Session getSession() {
		Session session = (Session) entityManager.getDelegate();
		return session;
	}

	public long getPostAndUpdate(long id) {
//		Post post = entityManager.find(Post.class, id);
		String details = "New Post updated11";
//		post.setDetails(details);
//		entityManager.merge(post);
		Query createQuery = entityManager.createQuery("Update Post p set p.details = :details where id=:id");
		createQuery.setParameter("details", details).setParameter("id", id).executeUpdate();
		return id;
	}
	
	public long getPostAndUpdateBySession(long id) {
		Session session = getSession();
		Post post = session.get(Post.class, id);
		post.setDetails("New Post updated Again");
		session.update(post);
		return post.getId();
	}
}
