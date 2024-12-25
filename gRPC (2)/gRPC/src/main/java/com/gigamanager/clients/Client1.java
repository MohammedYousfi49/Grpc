package com.gigamanager.clients;

import com.gigamanager.stubs.Bank;
import com.gigamanager.stubs.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client1 {
    public static void main(String[] args) {
        // Création d'un canal géré pour la communication gRPC
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5555)
                .usePlaintext() // Assure une connexion en texte clair (non chiffrée)
                .build();

        // Création d'un stub pour interagir avec le serveur gRPC
        BankServiceGrpc.BankServiceBlockingStub blockingStub =
                BankServiceGrpc.newBlockingStub(managedChannel);

        // Création d'une requête de conversion de devise
        Bank.ConvertCurrencyRequest request = Banknk.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD") // Devise source : Dirham marocain
                .setCurrencyTo("USD") // Devise cible : Dollar américain
                .setAmount(7600) // Montant à convertir
                .build();

        // Envoi de la requête et réception de la réponse
        Bank.ConvertCurrencyResponse currencyResponse = blockingStub.convert(request);

        // Affichage de la réponse dans la console
        System.out.println(currencyResponse);
    }
}
