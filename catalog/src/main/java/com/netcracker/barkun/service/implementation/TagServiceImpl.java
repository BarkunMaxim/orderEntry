package com.netcracker.barkun.service.implementation;

import com.netcracker.barkun.dao.repository.TagRepository;
import com.netcracker.barkun.entity.Tag;
import com.netcracker.barkun.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Iterable<Tag> save(List<Tag> tagList) {
        return tagRepository.saveAll(tagList);
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag update(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void remove(Long id) {
        tagRepository.deleteById(id);
    }
}
