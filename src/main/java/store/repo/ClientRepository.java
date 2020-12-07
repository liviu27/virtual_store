package store.repo;

import store.model.Client;
import store.model.Product;


import java.util.*;
import java.util.stream.Collectors;

public enum ClientRepository {

    CLIENT_REPOSITORY;

    private Map<String, Client> customersByName = new HashMap<>();

    public void addNewClient(Client client) {
        customersByName.put(client.getName(), client);
    }

    public Client getClientByName(String name) {
        return customersByName.get(name);
    }

    public List<String> getClientNames() {
        List<String> customerNameAndRegYear = new ArrayList<>();
        Set<String> customerNames = customersByName.keySet();
        for (String name : customerNames) {
            int regYear = customersByName.get(name).getRegistrationYear();
            customerNameAndRegYear.add(name+ " - reg. year = " + regYear);
        }
        return customerNameAndRegYear;
    }

    public List<Client> getAllClientsSortedAlphabetically() {
        return customersByName.values().stream()
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
    }

    public void deleteClient(String name) {
        customersByName.remove(name);
    }


}
