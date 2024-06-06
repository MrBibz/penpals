package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Query;
import org.mrbibz.authors.repository.QueryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryService {

    private final QueryRepository queryRepository;

    public Query sendQuery(Query query) {
        Objects.requireNonNull(query, "Query cannot be null");
        return queryRepository.save(query);
    }

    public Optional<Query> unsendQuery(String queryId) {
        Objects.requireNonNull(queryId, "Query ID cannot be null");
        Optional<Query> query = queryRepository.findById(queryId);
        query.ifPresent(queryRepository::delete);
        return query;
    }

    public Optional<Query> editQuery(String queryId, Query updatedQuery) {
        Objects.requireNonNull(queryId, "Query ID cannot be null");
        Objects.requireNonNull(updatedQuery, "Updated query cannot be null");
        Optional<Query> query = queryRepository.findById(queryId);
        if (query.isPresent()) {
            queryRepository.save(updatedQuery);
        }
        return query;
    }
}