package com.dev.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	@Query(value = "select * from user1 u where u.email =:email", nativeQuery = true)
	User findByEmail(String email);

}