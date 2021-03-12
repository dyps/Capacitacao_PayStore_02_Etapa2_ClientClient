package br.com.clientclient.client.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.clientclient.client.Client;

@FunctionalInterface
public interface ListPageClientService {

	Page<Client> findPage(String searchTerm, Pageable pageable);

}