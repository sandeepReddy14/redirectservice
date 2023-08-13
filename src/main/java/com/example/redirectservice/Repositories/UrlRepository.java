package com.example.redirectservice.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.tinyurlcrudapi.model.UrlData;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<UrlData,String> {
    Optional<UrlData> getUrlDataByShortUrl(String shortUrl);
}
