package com.PatientManagementSearch.PatientSearch.controller;

import com.PatientManagementSearch.PatientSearch.dto.HistoryResponseDto;
import com.PatientManagementSearch.PatientSearch.entity.History;
import com.PatientManagementSearch.PatientSearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
@CrossOrigin("*")
public class ElasticSearchController {

    @Autowired
    private SearchService searchService;


    @GetMapping(value = "/recordsFromHistory/{text}")
    public List<History> getRecordsFromHistory(@PathVariable("text") String text) {
        return searchService.getPatientRecordFromHistory(text);
    }

    @PostMapping(value = "/save")
    public History saveDetails(@RequestBody History history)
    {
        return searchService.save(history);
    }


    @GetMapping(value = "/findAll")
    public List<History> findAll()
    {
        return searchService.findAll();
    }
}
