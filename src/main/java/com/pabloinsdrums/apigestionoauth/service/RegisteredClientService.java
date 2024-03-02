package com.pabloinsdrums.apigestionoauth.service;

import com.pabloinsdrums.apigestionoauth.mapper.ClientAppMapper;
import com.pabloinsdrums.apigestionoauth.model.entity.security.ClientApp;
import com.pabloinsdrums.apigestionoauth.repository.ClientAppRepository;
import com.pabloinsdrums.apigestionoauth.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisteredClientService implements RegisteredClientRepository {

    @Autowired
    private ClientAppRepository clientAppRepository;

    @Override
    public void save(RegisteredClient registeredClient) {}

    @Override
    public RegisteredClient findById(String id) {
        ClientApp clientApp = clientAppRepository.findByClientId(id)
                .orElseThrow(() -> new ObjectNotFoundException("Client not found"));
        return ClientAppMapper.toRegisteredClient(clientApp);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return this.findById(clientId);
    }
}
