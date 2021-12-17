package com.technopreneur.repository;

import com.technopreneur.repository.dto.RepoResponse;

import java.util.Optional;

public interface GitHubRepository {

    Optional<RepoResponse> search();
}
