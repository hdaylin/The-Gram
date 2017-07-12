package com.example.demo.Repositories;

import com.example.demo.Models.Comments;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by daylinhenry on 7/11/17.
 */
public interface CommentRepository extends CrudRepository<Comments, Integer> {
}
