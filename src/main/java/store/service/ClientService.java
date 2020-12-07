package store.service;

import store.exceptions.NoSuchClientException;
import store.model.Client;
import store.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public List<String> getRegisteredClients() {
        return CLIENT_REPOSITORY.getClientNames();
    }

    public List<Client> getAllClientsWithBasket() {
        return CLIENT_REPOSITORY.getAllClientsSortedAlphabetically();
    }

    public void setBasket(String clientName, Product product) {
        CLIENT_REPOSITORY.getClientByName(clientName).getBasket().addToBasket(product);
    }
}
