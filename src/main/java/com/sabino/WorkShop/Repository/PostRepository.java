package com.sabino.WorkShop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sabino.WorkShop.Domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String > {

}
