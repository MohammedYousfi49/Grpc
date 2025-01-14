package com.gigamanager.services;

import com.gigamanager.stubs.Bank;
import com.gigamanager.stubs.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase{
    @Override
    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver){
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();


        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount*11.4)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
