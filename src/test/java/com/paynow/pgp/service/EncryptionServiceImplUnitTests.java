package com.paynow.pgp.service;

import com.paynow.pgp.service.impl.EncryptionServiceImpl;
import org.bouncycastle.openpgp.PGPException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.security.NoSuchProviderException;

@SpringBootTest(classes = EncryptionServiceImplUnitTests.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"default", "test"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EncryptionServiceImplUnitTests {

    @Mock
    Cipher cipher;

    @Test
    public void encryptFile_methodTest() throws PGPException, IOException, NoSuchProviderException {
        EncryptionServiceImpl encryptionService = new EncryptionServiceImpl(cipher);
        String requestDto = "test";

        encryptionService.encryptFile(requestDto);
    }

    @Test
    public void decryptFile_methodTest() throws PGPException, IOException, NoSuchProviderException {
        EncryptionServiceImpl encryptionService = new EncryptionServiceImpl(cipher);
        String requestDto = "test";

        encryptionService.encryptFile(requestDto);
    }
}
