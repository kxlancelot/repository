import java.security.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import sun.security.x509.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class Test2 {
    public static void main(String[] args) throws Exception{
        CertificateFactory cf=CertificateFactory.getInstance("X.509");
        FileInputStream in=new FileInputStream("src/tomcat.crt");
        X509Certificate c=(X509Certificate)cf.generateCertificate(in);

        /*String s=c.toString();
        String pass="123456";
        FileInputStream in=new FileInputStream(".keystore");
        KeyStore ks=KeyStore.getInstance("JKS");
        ks.load(in,pass.toCharArray());
        java.security.cert.Certificate c=ks.getCertificate(alias);//alias为条目的别名*/

        System.out.println("输出证书信息:/n"+c.toString());
        System.out.println("版本号:"+c.getVersion());
        System.out.println("序列号:"+c.getSerialNumber().toString(16));
        System.out.println("主体名："+c.getSubjectDN());
        System.out.println("签发者："+c.getIssuerDN());
        System.out.println("有效期："+c.getNotBefore());
        System.out.println("签名算法："+c.getSigAlgName());
        byte [] sig=c.getSignature();//签名值
        PublicKey pk=c.getPublicKey();
        byte [] pkenc=pk.getEncoded();
        System.out.println("公钥");
        for(int i=0;i<pkenc.length;i++)System.out.print(pkenc[i]+",");

    }
}
