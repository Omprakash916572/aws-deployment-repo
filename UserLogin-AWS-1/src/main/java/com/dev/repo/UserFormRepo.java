package com.dev.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.entity.UserFormData;

@Repository
public interface UserFormRepo extends CrudRepository<UserFormData, Integer> {

}