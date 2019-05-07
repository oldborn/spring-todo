package io.github.oldborn.pet.springtodo.util;

import io.github.oldborn.pet.springtodo.exception.InternalServerException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening A.D.I.D.A.S. - Korn @Link https://open.spotify.com/track/0xgsyoVvRFSYvV5cdtYhX1
 * Modified while listening @SpotRepeat {}
 */
public class Sha256Digest {

    public static String digest(String str){
        String digested = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digested = new String(digest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new InternalServerException("Algorithm could not be found");
        }
        return digested;
    }
}
