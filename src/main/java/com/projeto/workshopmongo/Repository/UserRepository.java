package com.projeto.workshopmongo.Repository;

import com.projeto.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//capaz de fazer varias operações basicas
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
