package test.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class Cypher {
    @Test
    public void checkInput_checksIfInputIsString() throws Exception {
        Encrypt value = new Encrypt("z", 25);
        assertEquals(true, value.isString());
    }

    @Test
    public void checkInput_checksIfKeyIsBetween1to25() throws Exception {
        Encrypt value = new Encrypt("z", 25);
        assertEquals(true, value.isInRange());
    }

    @Test
    public void Encrypt_EncryptsSingleLowerCaseCharacters() {
        Encrypt newEncryption = new Encrypt("z", 1);
        assertEquals("a", newEncryption.forward());
    }

    @Test
    public void Encrypt_EncryptsWordsLowerCaseCharacters() {
        Encrypt newEncryption = new Encrypt("abc", 1);
        assertEquals("bcd", newEncryption.forward());
    }

    @Test
    public void Encrypt_EncryptsUpperCaseWords() {
        Encrypt newEncryption = new Encrypt("ABC", 1);
        assertEquals("BCD", newEncryption.forward());
    }

    @Test
    public void decryptsSmallCaseSingleCharacters() {
        Decrypt newDecryption = new Decrypt("z", 1);
        assertEquals("y", newDecryption.backward());
    }

    @Test
    public void decryptsSmallCaseMultipleCharacterWords() {
        Decrypt newDecryption = new Decrypt("bcd", 1);
        assertEquals("abc", newDecryption.backward());
    }

    @Test
    public void decryptsUpperCaseMultipleCharacterWords() {
        Decrypt newDecryption = new Decrypt("BCD", 1);
        assertEquals("ABC", newDecryption.backward());
    }
}
