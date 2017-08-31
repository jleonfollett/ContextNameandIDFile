package john;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	private final String file = "C:\\ContextID\\log.txt";
	private FileReader fr;
	private BufferedReader br;
	private ArrayList<String> fileContents = new ArrayList<String>();
	Reader() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter context");
		final String context = scanner.nextLine();
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
			if(line.contains("Context:" + context) && line.contains("SiteID: " + id)){
			fileContents.add(line);
			}
		}
	}
	
}
