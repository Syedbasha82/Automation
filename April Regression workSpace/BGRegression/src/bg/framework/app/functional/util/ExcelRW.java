package bg.framework.app.functional.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import bg.framework.app.functional.entities.UserProfile;

public class ExcelRW {
	
	public  void writeToXLFile(String filePath,String value){
		File file=new File(filePath);
		
		String content="InitialStatus\tJI\tContract_Acc\tContract_No\tMPAN_value_out\tPremise_value_out\tConnection_Obj._value_out\tDevice_data_out\tManufSerialNo._value_out\tSO_Message_out\tSO_Number_out\tContract_number_value_out\tContract_number_2_value_out\n";
		try {
			FileWriter fw=new FileWriter(file);
			
			fw.write(content+value);
			System.out.println("File Written Successfully!!");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void writeToXLFile(String filePath,UserProfile profile){
		File file=new File(filePath);
		
		String content="InitialStatus\tJI\tContract_Acc\tContract_No\tMPAN_value_out\tPremise_value_out\tConnection_Obj._value_out\tDevice_data_out\tManufSerialNo._value_out\tSO_Message_out\tSO_Number_out\tContract_number_value_out\tContract_number_2_value_out\n";
		String value=profile.getInitialSoStatus()+"\t";
		if(profile.getElecAccount().isEmpty()&&profile.getGasAccount().isEmpty())
		{
			value+="Yes\t'"+profile.getAccNumber()+"\t\n\t\t"+profile.getAccNumber();
		}
		else{
			value+="No\t'";
			if(!profile.getElecAccount().isEmpty()&&profile.getGasAccount().isEmpty()){
				value+=profile.getElecAccount()+"\t\n";
			}else if(profile.getElecAccount().isEmpty()&&!profile.getGasAccount().isEmpty()){
				value+=profile.getGasAccount()+"\t\n";
			}else{
				value+=profile.getGasAccount()+"\t\n"+"\t\t'"+profile.getElecAccount();
			}
		}
		
		try {
			FileWriter fw=new FileWriter(file);
			
			fw.write(content+value);
			System.out.println("File Written Successfully!!");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
