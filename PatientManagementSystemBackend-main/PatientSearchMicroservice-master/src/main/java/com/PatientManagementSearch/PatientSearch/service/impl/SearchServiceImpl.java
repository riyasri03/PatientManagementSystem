package com.PatientManagementSearch.PatientSearch.service.impl;


import com.PatientManagementSearch.PatientSearch.dto.HistoryRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.HistoryResponseDto;
import com.PatientManagementSearch.PatientSearch.entity.History;
import com.PatientManagementSearch.PatientSearch.repository.HistoryRepository;
import com.PatientManagementSearch.PatientSearch.searchrepo.SearchRepository;
import com.PatientManagementSearch.PatientSearch.service.SearchService;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public History save(History history) {
        History history1 = historyRepository.save(history);
        return searchRepository.save(history1);
    }

    @Override
    public List<History> findAll() {
        List<History> list = new ArrayList<>();
        Iterable<History> historyIterable = searchRepository.findAll();
        historyIterable.forEach(list::add);
        return list;
    }

    @Override
    public List<History> getPatientRecordFromHistory(String text) {
        text = text.replace(" ", "+");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery(text)
                .lenient(true).field("issue").fuzziness(Fuzziness.fromEdits(2)).field("month").fuzziness(Fuzziness.fromEdits(2))
                .field("patientName").fuzziness(Fuzziness.fromEdits(2)).field("patientId").fuzziness(Fuzziness.fromEdits(2))).
                should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true).field("issue").fuzziness(Fuzziness.fromEdits(2)).field("month").fuzziness(Fuzziness.fromEdits(2))
                        .field("patientName").fuzziness(Fuzziness.fromEdits(2)).field("patientId").fuzziness(Fuzziness.fromEdits(2)));

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        List<History> historyList = elasticsearchRestTemplate.queryForList(nativeSearchQuery, History.class,
                IndexCoordinates.of("test3"));
        return historyList;
    }
}
