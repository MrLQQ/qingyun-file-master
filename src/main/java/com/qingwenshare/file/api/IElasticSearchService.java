package com.qingwenshare.file.api;

import com.qingwenshare.file.config.es.FileSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IElasticSearchService extends ElasticsearchRepository<FileSearch,Long> {

}