package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.entity.Tag;
import com.netcracker.barkun.service.TagService;
import com.netcracker.barkun.web.controller.dto.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping
    public Optional<TagDto> get(@PathVariable("id") Long id) {
        Optional<Tag> orderById = tagService.getTagById(id);
        Optional<TagDto> optionalOrderDto = Optional.of(TagDto.convertFromTag(orderById.get()));
        return optionalOrderDto;
    }

    @PostMapping
    public TagDto save(@RequestBody TagDto tagDto) {
        Tag tag = tagService.save(Tag.convertFromTagDto(tagDto));
        return TagDto.convertFromTag(tag);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    @PostMapping
    public Iterable<TagDto> saveTags(@RequestBody List<TagDto> tagDtoList) {
        List<Tag> tags = (List<Tag>)tagService.save(Tag.convertFromTagDto(tagDtoList));
        Iterable<TagDto> resultList = tags.stream()
                .map(tag -> TagDto.convertFromTag(tag))
                .collect(Collectors.toCollection(ArrayList::new));
        return resultList;
    }

    @PutMapping
    public TagDto update(@RequestBody Tag newTag) {
        Tag tag = tagService.update(newTag);
        return TagDto.convertFromTag(tag);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        tagService.remove(id);
    }
}
