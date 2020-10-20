package com.sp.ticketservice.repo.elasticsearch;

import com.sp.ticketservice.model.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}
