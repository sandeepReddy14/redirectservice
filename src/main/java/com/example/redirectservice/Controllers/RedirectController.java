package com.example.redirectservice.Controllers;

import com.example.redirectservice.Repositories.UrlRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.Optional;

import static jakarta.servlet.http.HttpServletResponse.*;

@RestController
public class RedirectController {

    @Autowired
    UrlRepository urlRepository;

    @RequestMapping("/tiny/{shortUrl}")
    @PostMapping
    public void method(@PathVariable("shortUrl") String shortUrl, HttpServletResponse httpServletResponse)
    {
        Optional<com.example.tinyurlcrudapi.model.UrlData> _urlData = urlRepository.getUrlDataByShortUrl(shortUrl);
        if(_urlData.isPresent())
        {
            httpServletResponse.setHeader("Location",_urlData.get().getLongUrl());
            httpServletResponse.setStatus(SC_FOUND);
        }
        else {
            httpServletResponse.setStatus(SC_NOT_FOUND);
        }

    }




}
