import java.security.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import sun.security.x509.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import sun.misc.BASE64Encoder;
public class Test {
    public static void main(String[] args) throws Exception{
        File file = new File("src/tomcat.crt");
        InputStream inStream = new FileInputStream(file);
        //创建X509工厂类
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        //创建证书对象
        X509Certificate oCert = (X509Certificate)cf.generateCertificate(inStream);
        inStream.close();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        String info = null;
        //获得证书版本
        info = String.valueOf(oCert.getVersion());
        System.out.println("证书版本:"+info);
        //获得证书序列号
        info = oCert.getSerialNumber().toString(16);
        System.out.println("证书序列号:"+info);
        //获得证书有效期
        Date beforedate = oCert.getNotBefore();
        info = dateformat.format(beforedate);
        System.out.println("证书生效日期:"+info);
        Date afterdate = oCert.getNotAfter();
        info = dateformat.format(afterdate);
        System.out.println("证书失效日期:"+info);
        //获得证书主体信息
        info = oCert.getSubjectDN().getName();
        System.out.println("证书拥有者:"+info);
        //获得证书颁发者信息
        info = oCert.getIssuerDN().getName();
        System.out.println("证书颁发者:"+info);
        //获得证书签名算法名称
        info = oCert.getSigAlgName();
        System.out.println("证书签名算法:"+info);


        byte[] byt = oCert.getExtensionValue("1.2.86.11.7.9");
        String strExt = new String(byt);
        System.out.println("证书扩展域:" + strExt);
        byt = oCert.getExtensionValue("1.2.86.11.7.1.8");
        String strExt2 = new String(byt);
        System.out.println("证书扩展域2:" + strExt2);
    }

}
