package com.ozkaraca.ticketproject.repository.es;

import com.ozkaraca.ticketproject.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
