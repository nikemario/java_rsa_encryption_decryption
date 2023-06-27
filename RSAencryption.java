import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;

public class RSAencryption {
	
	public static void main(String[] args) {
		
		try {
			//message
			File f = new File("message.txt");
			//key that is being used for encryption, e is pub, d is priv
			File ff = new File("e.txt");
			//n for mod exp.
			File fff = new File("n.txt");
			
			Scanner sc = new Scanner(ff);
			Scanner sc1 = new Scanner(fff);
			
			byte[] z = Files.readAllBytes(f.toPath());
			
			BigInteger b = new BigInteger(z);
			BigInteger e = new BigInteger(sc.next());
			BigInteger n = new BigInteger(sc1.next());
			
			//mod exp.
			BigInteger jdj = b.modPow(e, n);
			
			z = jdj.toByteArray();
			
			//en with key
			File en = new File("encryptedWithPublic.txt");
			Files.write(en.toPath(), z);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
}