package com.home.store.security;

import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSADecrypter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;

@Service
public class TokenService {
    @Value("${security.key.private}")
    private String privateKeyPath;

    public String getSubject(String tokenJWE){
        try {
            RSAPrivateKey privateKey = readRSAPrivateKeyFromPEMFile();
            JWEObject jweObject = JWEObject.parse(tokenJWE);
            JWEDecrypter decrypter = new RSADecrypter(privateKey);
            jweObject.decrypt(decrypter);
            return jweObject.getPayload().toJSONObject().get("authenticationToken").toString();
        }catch (Exception e){
            throw new RuntimeException("Token JWT expirado ou invalido");
        }
    }

    private RSAPrivateKey readRSAPrivateKeyFromPEMFile() throws Exception {
        try{
            PEMParser pemParser = new PEMParser(new FileReader(privateKeyPath));
            PEMKeyPair pemKeyPair = (PEMKeyPair) pemParser.readObject();
            KeyPair keyPair = new JcaPEMKeyConverter().getKeyPair(pemKeyPair);
            return (RSAPrivateKey) keyPair.getPrivate();
        } catch (Exception e){
            throw new RuntimeException("Erro ao obter a chave privada");
        }
    }
}
