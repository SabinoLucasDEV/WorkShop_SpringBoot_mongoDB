package com.sabino.WorkShop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sabino.WorkShop.Domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String > {

}
