package br.com.clientclient.client.service;

import org.springframework.stereotype.Service;

import br.com.clientclient.client.Client;
import br.com.clientclient.client.ClientRepository;
import br.com.clientclient.exceptions.ClientNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateClientServiceImpl implements UpdateClientService {

	private final ClientRepository clientRepository;

	@Override
	public void update(Client newClient, Long id) {
		Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
		client.setName(newClient.getName());
		client.setAge(newClient.getAge());
		client.setTelephone(newClient.getTelephone());
		client.setEmail(newClient.getEmail());
		client.setSex(newClient.getSex());
		clientRepository.save(client);
	}
}
