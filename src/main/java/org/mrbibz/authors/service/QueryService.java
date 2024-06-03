package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Query;
import org.mrbibz.authors.repository.QueryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class QueryService {

    private final QueryRepository queryRepository;

    public Query sendQuery(Query query) {
        Objects.requireNonNull(query);
        return queryRepository.save(query);
    }

    public Query unsendQuery(String queryId) {
        Objects.requireNonNull(queryId);
        Query query = queryRepository.findById(queryId).orElse(null);
        queryRepository.deleteById(queryId);
        return query;
    }
}
