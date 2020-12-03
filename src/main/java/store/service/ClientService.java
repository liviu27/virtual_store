package store.service;

import store.exceptions.NoSuchClientException;
import store.model.Client;

import static store.repo.ClientRepository.CLIENT_REPOSITORY;

public enum ClientService {
    CLIENT_SERVICE;

    public void addNewClient(Client client ) {
        CLIENT_REPOSITORY.addNewClient(client);
    }

    public Client getClientByName(String clientName) throws NoSuchClientException {
        Client clientByName = CLIENT_REPOSITORY.getClientByName(clientName);
        if (clientByName == null) {
            throw new NoSuchClientException();
        }
        return clientByName;
    }
}
