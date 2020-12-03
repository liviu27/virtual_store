package store.repo;

import store.model.Client;


import java.util.Map;

public enum ClientRepository {

    CLIENT_REPOSITORY;

    private Map<String, Client> customersByName;

    public void addNewClient(Client client) {
        customersByName.put(client.getName(), client);
    }

    public Client getClientByName(String name) {
        return customersByName.get(name);
    }

    public void deleteClient(String name) {
        customersByName.remove(name);
    }
}
