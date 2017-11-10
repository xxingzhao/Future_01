package org.xiaoxz.rsa;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Enumeration;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/10/24
 * @Modified by :
 **/
public class KeyTool {
    
    public static void main(String[] args) throws Exception {
       // pkcsToJks("D:" + File.separator +"rsa_private_key.pem", "123456", "D:"+File.separator +"jks_store.jks", "123456");
        PrivateKey privateKey = loadPrivateKey("D:" + File.separator +"rsa_private_key_pkcs8.pem");
      //  createKeyStore("123456", "D:" + File.separator +"rsa_pkcs_12.pfx", privateKey, );
    }

    public static void pkcsToJks(String srcFile, String srcPasswd, String destFile, String destPasswd) {
        try{
            KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(srcFile);
            char[] srcPwd = null, destPwd = null;
            if ((srcPasswd == null) || srcPasswd.trim().equals("")) {
                srcPwd = null;
            } else {
                srcPwd = srcPasswd.toCharArray();
            }
            if ((destPasswd == null) || destPasswd.trim().equals("")) {
                destPwd = null;
            } else {
                destPwd = destPasswd.toCharArray();
            }
            inputKeyStore.load(fis, srcPwd);
            fis.close();
            KeyStore outputKeyStore = KeyStore.getInstance("JKS");
            outputKeyStore.load(null, destPwd);
            Enumeration enums = inputKeyStore.aliases();
            while (enums.hasMoreElements()) {
                String keyAlias = (String) enums.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
                if (inputKeyStore.isKeyEntry(keyAlias)) {
                    Key key = inputKeyStore.getKey(keyAlias, srcPwd);
                    Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
                    outputKeyStore.setKeyEntry(keyAlias, key, destPwd, certChain);
                }
            }
            FileOutputStream out = new FileOutputStream(destFile);
            outputKeyStore.store(out, destPwd);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey loadPrivateKey(String keyFile)
            throws Exception {
        File f = new File(keyFile);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static void createKeyStore(String keyStorePwd, String keyStoreFile,
                               PrivateKey privateKey, X509Certificate certificate)
            throws Exception {
        char[] pwd = keyStorePwd.toCharArray();
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(null, pwd);
        KeyStore.ProtectionParameter protParam =
                new KeyStore.PasswordProtection(pwd);
        Certificate[] certChain =
                new Certificate[]{ certificate };
        KeyStore.PrivateKeyEntry pkEntry =
                new KeyStore.PrivateKeyEntry(privateKey, certChain);
        ks.setEntry("keypair", pkEntry, protParam);
        FileOutputStream fos = new FileOutputStream(keyStoreFile);
        ks.store(fos, pwd);
        fos.close();
    }

}
