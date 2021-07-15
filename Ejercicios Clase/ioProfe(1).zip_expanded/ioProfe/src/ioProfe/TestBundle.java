package ioProfe;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		
		
		System.out.println("CLAVES-VALOR:");
		//List<String> keys = Collections.list(bundle.getKeys());
		for(String key:bundle.keySet()) {
			System.out.print("Clave:"+key);
			System.out.print("  ");
			System.out.println("Valor:"+bundle.getString(key));			
		}
		
		System.out.println("-------------------------------------------");
		ResourceBundle bundleUS = ResourceBundle.getBundle("messages",Locale.US);
		
		System.out.println("CLAVES-VALOR:");
		//List<String> keys = Collections.list(bundle.getKeys());
		for(String key:bundleUS.keySet()) {
			System.out.print("Clave:"+key);
			System.out.print("  ");
			System.out.println("Valor:"+bundleUS.getString(key));			
		}
		
		
		
	}

}
