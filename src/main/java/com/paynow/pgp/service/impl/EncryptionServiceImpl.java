package com.paynow.pgp.service.impl;

import com.paynow.pgp.service.Cipher;
import com.paynow.pgp.service.EncryptionService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.security.NoSuchProviderException;
import java.security.Security;

public class EncryptionServiceImpl implements EncryptionService {

    @Value("${dbs.key.pub}")
    private String publicKey;

    @Value("${sl.key.pri}")
    private String privateKey;

    @Value("${dbs.key.pwd}")
    private String passPhase;


    private final Cipher cipher;

    public EncryptionServiceImpl(Cipher cipher) {
        this.cipher = cipher;
    }

    @Override
    public void encryptFile(String requestDto) throws PGPException, IOException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        PGPFileEncryptionServiceImpl.encryptFile("output_encrypted_file.asc",
                "src/main/resources/Capture.PNG",
                "src/main/resources/0xD89B5951-pub.asc", true, false);

        // File path is passed as parameter
        File file = new File(
                "output_encrypted_file.asc");
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String final1="";
        String st;
        while ((st = br.readLine()) != null)
            final1 += st;

    }

    @Override
    public void decryptFile() throws IOException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());

//        InputStream targetStream = new ByteArrayInputStream(encryptionInfo.getEncryptedFile().getBytes());

        PGPFileEncryptionServiceImpl.decryptFile("output_encrypted_file.asc",
                "src/main/resources/0xD89B5951-sec.asc",
                passPhase.toCharArray(),
                new File("no_need_name_as_encrypted_file_has_name").getName());
    }

    @Override
    public String encrypt(String requestDto) throws PGPException, IOException, NoSuchProviderException {
        return cipher.encryptData(requestDto);
    }

    @Override
    public String decrypt(String requestDto) throws PGPException, IOException, NoSuchProviderException {
        return cipher.decryptData(requestDto);
    }
}
