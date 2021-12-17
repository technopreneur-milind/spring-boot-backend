package com.technopreneur.strategy;

import com.technopreneur.model.Repository;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class RepositoryDescendingComparator implements Comparator<Repository> {

    @Override
    public int compare(final Repository repository1, final Repository repository2) {
        long diff = repository2.getScore() - repository1.getScore();
        return Math.toIntExact(diff == 0 ? repository1.getId() - repository2.getId() : diff); //priority to oldest if score are equal
    }
}
