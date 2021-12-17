package com.technopreneur.strategy;

import com.technopreneur.model.RepoFiltersWeights;
import com.technopreneur.model.RepoSearchResponse;
import com.technopreneur.model.Repository;
import com.technopreneur.repository.dto.RepoItem;
import com.technopreneur.repository.dto.RepoResponse;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class WeightScoreFilterStrategy implements FilterStrategy {

    private static final String JAVA = "Java";

    private final RepositoryDescendingComparator repositoryDescendingComparator;

    public WeightScoreFilterStrategy(final RepositoryDescendingComparator repositoryDescendingComparator) {
        this.repositoryDescendingComparator = repositoryDescendingComparator;
    }

    @Override
    public RepoSearchResponse getFilteredResults(final RepoResponse repoResponse, final RepoFiltersWeights repoFiltersWeights, final int limit) {
        RepoSearchResponse repoSearchResponse = null;
        if (repoResponse != null && repoResponse.getItems() != null) {
            List<RepoItem> items = repoResponse.getItems();
            List<Repository> repoList = new ArrayList<>();
            for (RepoItem repoItem : items) {
                final long forkCountWeight = repoFiltersWeights.getForkCountWeight() * repoItem.getForks();
                final long watcherCountWeight = repoFiltersWeights.getWatchersWeight() * repoItem.getWatchers();
                final long openIssuesWeight = repoFiltersWeights.getOpenIssuesWeight() * repoItem.getOpenIssues();
                final long oddIdWeight = ((repoItem.getId() % 2 != 1) ? repoFiltersWeights.getOddOwnerWeight() : 0L);
                final long isJavaWeight = JAVA.equalsIgnoreCase(repoItem.getLanuage()) ? repoFiltersWeights.getJavaLanguageWeight() : 0L;
                final long isLessTwoYearsWeight = DateTime.parse(repoItem.getUpdatedAt()).isAfter(DateTime.now().minusYears(2)) ? repoFiltersWeights.getRecentlyUpdatedWeight() : 0L;
                final long score = forkCountWeight + watcherCountWeight + openIssuesWeight +
                        oddIdWeight + isJavaWeight + isLessTwoYearsWeight;
                Repository repository = new Repository(repoItem.getId(), repoItem.getName(), repoItem.getUrl(), score);
                repoList.add(repository);
            }
            Collections.sort(repoList, repositoryDescendingComparator);
            repoSearchResponse = new RepoSearchResponse(limit == 0 || repoList.size() < limit ? repoList : repoList.subList(0, limit));
        }
        return repoSearchResponse;
    }
}
