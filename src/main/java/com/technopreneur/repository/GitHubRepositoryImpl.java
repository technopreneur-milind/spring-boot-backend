package com.technopreneur.repository;

import com.technopreneur.config.LocalCacheConfig;
import com.technopreneur.repository.dto.RepoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
@CacheConfig(cacheNames = {LocalCacheConfig.GIT_REPO_RESULTS})
public class GitHubRepositoryImpl implements GitHubRepository {

    private static final Logger logger = LoggerFactory.getLogger(GitHubRepositoryImpl.class);
    private static final String SEARCH_URL = "https://api.github.com/search/repositories?q=private:false";

    private final RestTemplate restTemplate;

    public GitHubRepositoryImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable
    public Optional<RepoResponse> search() {
        RepoResponse result = null;
        try {
            ResponseEntity<RepoResponse> responseEntity = restTemplate.getForEntity(SEARCH_URL, RepoResponse.class);
            result = responseEntity.getBody();
        } catch (RestClientException e) {
            logger.error("Error while searching GitHubRepo", e);
        }
        return Optional.ofNullable(result);
    }

}
