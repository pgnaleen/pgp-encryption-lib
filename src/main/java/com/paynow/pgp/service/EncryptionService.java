package com.paynow.pgp.service;

import org.bouncycastle.openpgp.PGPException;

import java.io.IOException;
import java.security.NoSuchProviderException;

public interface EncryptionService {

    String encrypt(String requestDto) throws PGPException, IOException, NoSuchProviderException;

    void encryptFile(String requestDto) throws PGPException, IOException, NoSuchProviderException;

    String decrypt(String requestDto) throws PGPException, IOException, NoSuchProviderException;

    void decryptFile() throws PGPException, IOException, NoSuchProviderException;
}
