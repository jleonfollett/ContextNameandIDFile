package john;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Writer(new Reader().getFileContents());
	}

}