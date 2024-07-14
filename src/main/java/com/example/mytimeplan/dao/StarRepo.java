package com.example.mytimeplan.dao;

import com.example.mytimeplan.entity.Star;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepo extends CrudRepository<Star,Long> {
}
