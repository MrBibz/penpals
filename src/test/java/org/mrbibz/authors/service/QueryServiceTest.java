package org.mrbibz.authors.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.authors.model.Query;
import org.mrbibz.authors.repository.QueryRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class QueryServiceTest {

    @Mock
    private QueryRepository queryRepository;

    @InjectMocks
    private QueryService queryService;

    private Query query;

    @BeforeEach
    public void setUp() {
        query = new Query();

        when(queryRepository.save(any(Query.class))).thenReturn(any(Query.class));

        queryService.sendQuery(query);
    }

    @Test
    public void sendQueryTest() {
        verify(queryRepository, times(1)).save(any(Query.class));
    }

    @Test
    public void editQuery() {
        queryService.editQuery(query.getId());

        verify(queryRepository, times(2)).save(any(Query.class));
    }

    @Test
    public void unsendQueryTest() {
        query.setId("queryId");

        queryService.unsendQuery(query.getId());

        verify(queryRepository, times(1)).save(query);
        verify(queryRepository, times(1)).deleteById(query.getId());
    }
}
