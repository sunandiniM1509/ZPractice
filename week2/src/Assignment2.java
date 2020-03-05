class CaesarCipher
{
    String encrypt(String input ,int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String lowalphabet ="abcdefghijklmnopqrstuvwxyz";
        String upalphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String shiftedlowAlphabet = lowalphabet.substring(key)+lowalphabet.substring(0,key);
        String shiftedupAlphabet = upalphabet.substring(key)+upalphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++)
        {
            char currChar = encrypted.charAt(i);
            if (Character.isUpperCase(input.charAt(i)))
            {
                int idx = upalphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedupAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            if (Character.isLowerCase(input.charAt(i)))
            {
                int idx = lowalphabet.indexOf(currChar);
                if (idx != -1) {
                    char newChar = shiftedlowAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
}
class CaesarBreaker {
    public int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1)
                counts[dex]++;
        }
        return counts;
    }

    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex])
                maxDex = k;
        }
        return maxDex;
    }
public String decrypt(String encrypted)
{
CaesarCipher cc = new CaesarCipher();
int[] freqs = countLetters(encrypted);
int maxDex =maxIndex(freqs);
int dkey = maxDex - 4;
if(maxDex<4)
{
    dkey=26-(4-maxDex);
}
return cc.encrypt(encrypted,26-dkey);
}
void testDecrypt()
{
    CaesarCipher cc = new CaesarCipher();
    //Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message,
    // and make sure it works for encrypted messages that were encrypted with one key.
    //
    System.out.println(cc.encrypt("hello",19));
    System.out.println(decrypt("axeeh"));
    //System.out.println(decrypt("ruqkjyvkb"));
    //System.out.println(cc.encrypt("beautiful",16));
}
}
public class Assignment2 {
    public static void main(String[] args) {
    CaesarBreaker cb = new CaesarBreaker();
    cb.testDecrypt();
    }
}
