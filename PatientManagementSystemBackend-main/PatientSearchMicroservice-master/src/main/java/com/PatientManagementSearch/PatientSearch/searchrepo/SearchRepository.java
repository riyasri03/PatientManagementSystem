package com.PatientManagementSearch.PatientSearch.searchrepo;

import com.PatientManagementSearch.PatientSearch.entity.History;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface SearchRepository extends ElasticsearchRepository<History, Integer> {
}
