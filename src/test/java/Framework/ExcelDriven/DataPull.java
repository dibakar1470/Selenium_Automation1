package Framework.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class DataPull {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Datadriven arr_data = new  Datadriven();
		ArrayList<String> data = arr_data.getData("Piyush");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		System.out.println("To push to GITHUB");
		System.out.println("To push to GITHUB");
		
	}

}
