package com.blogapp.repository;

import com.blogapp.entity.Category;
import com.blogapp.entity.Post;
import com.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByPostTitleContaining(String keyword);
}
