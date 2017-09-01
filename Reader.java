package john;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	Scanner scanner = new Scanner(System.in);
	private FileReader fr;
	private BufferedReader br;
	private ArrayList<String> fileContents = new ArrayList<String>();
	Reader() throws IOException{
		System.out.println("Enter file to be scanned");
		final String file = scanner.nextLine();
		System.out.println("Enter context");
		String context = scanner.nextLine();
		if(context.startsWith("saas")){
			context = context.substring(4,context.length());
		}
		System.out.println("Enter id");
		final String id = scanner.nextLine();
		OpenReader(file);
		ReadLinesToList(br, context, id);
	}
	
	private void OpenReader(String file) throws FileNotFoundException{
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}
	public ArrayList<String> getFileContents(){
		return fileContents;
	}
	
	private void ReadLinesToList(BufferedReader br, String context, String id) throws IOException{
		String line;
		while((line = br.readLine()) != null){
			if(line.contains("Context:saas" +  context) && line.contains("siteID:" + id)){
			fileContents.add(line);
			}
		}
	}
	
}
