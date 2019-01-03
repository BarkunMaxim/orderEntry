package com.netcracker.barkun.dao.repository;

import com.netcracker.barkun.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    Set<Tag> findTagsByTittle(String tags);
}
