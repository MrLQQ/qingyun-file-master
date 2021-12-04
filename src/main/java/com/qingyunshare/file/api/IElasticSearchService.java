package com.qingyunshare.file.api;

import com.qingyunshare.file.config.es.FileSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IElasticSearchService extends ElasticsearchRepository<FileSearch,Long> {

}