package com.netcracker.barkun.service;

import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.entity.Offer;
import com.netcracker.barkun.entity.Price;
import com.netcracker.barkun.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    Offer saveOffer(Offer offer);

    Iterable<Offer> getAllOffer();

    Optional<Offer> getOfferById(Long id);

    List<Offer> getOfferListByPrice(Long id);

    List<Offer> getOfferListByCategory(Long id);

    Offer updateOffer(Offer offer);

    List<Offer> getOfferByTags(String tagsName);

    Offer updateCategory(Long id, Category category);

    Offer addTag(Tag tag, Long id);

    Offer removeTag(Tag tag, Long id);

    void removeOffer(Long id);
}
