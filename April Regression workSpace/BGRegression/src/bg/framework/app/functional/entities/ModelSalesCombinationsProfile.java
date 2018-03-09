package bg.framework.app.functional.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ModelSalesCombinations")
public class ModelSalesCombinationsProfile {

	private String Product1;
	private String Product2;
	private String Product3;
	private String Product4;
	private String Product5;
	
	public String getProduct(int i){
		String temp="";
		switch(i)
		{
			case 1:
				temp = Product1;
				break;
			case 2:
				temp = Product2;
				break;
			case 3:
				temp = Product3;
				break;
			case 4:
				temp = Product4;
				break;
			case 5:
				temp = Product5;
				break;
			case 6:
				temp = "";
				break;
		}
		return temp;
	}


}
