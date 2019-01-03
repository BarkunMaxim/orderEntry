package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.entity.Offer;
import com.netcracker.barkun.entity.Tag;
import com.netcracker.barkun.service.OfferService;
import com.netcracker.barkun.web.controller.dto.OfferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping
    public Optional<OfferDto> get(@PathVariable("id") Long id) {
        Optional<Offer> offerById = offerService.getOfferById(id);
        Optional<OfferDto> optionalOfferDto = Optional.of(OfferDto.convertFromOffer(offerById.get()));
        return optionalOfferDto;
    }

    @GetMapping
    public Iterable<OfferDto> getAll() {
        List<Offer> allOffer = (List<Offer>) offerService.getAllOffer();
        return OfferDto.convertFromOffer(allOffer);
    }

    @PostMapping
    public OfferDto save(@RequestBody Offer offer) {
        return OfferDto.convertFromOffer(offerService.saveOffer(offer));
    }

    @PutMapping
    public OfferDto update(@RequestBody Offer newOffer) {
        return OfferDto.convertFromOffer(offerService.updateOffer(newOffer));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        offerService.removeOffer(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/price/{priceID}")
    @GetMapping
    public List<OfferDto> getByPrice(@PathVariable("priceID") Long id) {
        List<Offer> offerListByPrice = offerService.getOfferListByPrice(id);
        return OfferDto.convertFromOffer(offerListByPrice);
    }

    @GetMapping(path = "/search")
    public List<OfferDto> getByCategory(@RequestParam Long id) {
        List<Offer> offerListByCategory = offerService.getOfferListByCategory(id);
        return OfferDto.convertFromOffer(offerListByCategory);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/tags")
    @GetMapping
    public List<OfferDto> getByTag(@RequestParam String tag) {
        List<Offer> offerByTags = offerService.getOfferByTags(tag);
        return OfferDto.convertFromOffer(offerByTags);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/categories")
    @PutMapping
    public OfferDto changeCategory(@RequestBody Category category, @RequestParam Long id) {
        return OfferDto.convertFromOffer(offerService.updateCategory(id, category));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/tags")
    @PutMapping
    public OfferDto addTag(@RequestBody Tag tag, @RequestParam Long id) {
        return OfferDto.convertFromOffer(offerService.addTag(tag, id));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/tags")
    @DeleteMapping
    public OfferDto deleteTag(@RequestBody Tag tag, @RequestParam Long id) {
        return OfferDto.convertFromOffer(offerService.removeTag(tag, id));
    }

}
