package com.learning.hibernaterefresh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learning.hibernaterefresh.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT name from User u WHERE u.id =?1")
	String getUserNameById(Long id);

	@Query("from User u LEFT JOIN FETCH u.posts WHERE u.name =?1 ORDER BY name ASC")
	List<User> findByNameAsc(String name);

	@Query("from User u WHERE u.name =?1")
	List<User> findByName(String name, Sort sort);

	@Query("from User u WHERE u.name =?1")
	List<User> findByName(String name, Pageable pageable);

	@Query("from #{#entityName} u WHERE u.name =?1")
	List<User> findByNameGeneric(String name);
	
	@Query("from User u WHERE UPPER(u.name) LIKE %?#{[0].toUpperCase()}%")
	List<User> findByNameIgnorecase(String name);
	
	@Query("from #{#entityName} u WHERE u.name =:name")
	List<User> findByNameByDiffParam(@Param("name") String name1);
	
	@Query("from #{#entityName} u WHERE u.name =:name")
	List<User> findByNameByParam(String name);
}
