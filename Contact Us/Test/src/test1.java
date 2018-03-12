import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Driver;


public class test1 {
    
	
	public void test2(String arguments[]) throws IOException, URISyntaxException{
		 Desktop.getDesktop().browse(new URI("http://10.224.70.17/content/britishgas/products-and-services/repair-and-cover/product-details.html"));
		 
	}
}
