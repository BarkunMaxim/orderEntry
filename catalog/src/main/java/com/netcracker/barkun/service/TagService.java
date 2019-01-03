package com.netcracker.barkun.service;

import com.netcracker.barkun.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Tag save(Tag tag);

    Iterable<Tag> save(List<Tag> tagList);

    Optional<Tag> getTagById(Long id);

    Tag update(Tag tag);

    void remove(Long id);
}
