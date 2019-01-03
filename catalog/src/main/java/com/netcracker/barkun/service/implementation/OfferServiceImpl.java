package com.netcracker.barkun.service.implementation;

import com.netcracker.barkun.dao.repository.CategoryRepository;
import com.netcracker.barkun.dao.repository.OfferRepository;
import com.netcracker.barkun.dao.repository.TagRepository;
import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.entity.Offer;
import com.netcracker.barkun.entity.Price;
import com.netcracker.barkun.entity.Tag;
import com.netcracker.barkun.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, CategoryRepository categoryRepository, TagRepository tagRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }


    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Iterable<Offer> getAllOffer() {
        return offerRepository.findAll();
    }

    @Override
    public Optional<Offer> getOfferById(Long id) {
        return offerRepository.findById(id);
    }

    @Override
    public List<Offer> getOfferListByPrice(Long id) {
        Price price = new Price();
        price.setId(id);
        return offerRepository.findByPrice(price);
    }

    @Override
    public List<Offer> getOfferListByCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return offerRepository.findByCategory(category.get());
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> getOfferByTags(String tags) {
        Set<Tag> tagSet = tagRepository.findTagsByTittle(tags);
        return offerRepository.findByTagSet(tagSet);
    }

    @Override
    public Offer updateCategory(Long id, Category category) {
        Optional<Offer> offer = offerRepository.findById(id);
        offer.get().setCategory(category);
        return offerRepository.save(offer.get());
    }

    @Override
    public Offer addTag(Tag tag, Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        offer.get().addTag(tag);
        return offerRepository.save(offer.get());
    }

    @Override
    public Offer removeTag(Tag tag, Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        offer.get().getTagSet().remove(tag);
        return offerRepository.save(offer.get());
    }

    @Override
    public void removeOffer(Long id) {
        offerRepository.deleteById(id);
    }
}
