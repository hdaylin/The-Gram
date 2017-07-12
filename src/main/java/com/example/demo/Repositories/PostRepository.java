package com.example.demo.Repositories;

import com.example.demo.Models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by daylinhenry on 7/11/17.
 */
public interface PostRepository extends CrudRepository<Post, Integer> {

   Post findAllById(Integer id);
}
