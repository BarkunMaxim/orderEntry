package com.netcracker.barkun.dao.repository;

import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.entity.Offer;
import com.netcracker.barkun.entity.Price;
import com.netcracker.barkun.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

    List<Offer> findByPrice(Price price);

    List<Offer> findByCategory(Category category);

    List<Offer> findByTagSet(Set<Tag> tags);

}
