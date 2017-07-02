import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class main {
	final static String defualtFolder = "C:/Notes/";
	final static File defualtFolderNotUsed = new File("C:/Notes");
	public static void editingFile(String targetFile) throws IOException{
		Scanner x = new Scanner(System.in);
		String sCurrentLine;
		String tempFile = defualtFolder + targetFile + ".txt";
		File userFileFolder = new File(tempFile);
		if (!userFileFolder.exists()) {
			userFileFolder.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(userFileFolder));
		BufferedReader br = new BufferedReader(new FileReader(userFileFolder));
		System.out.println("Type, 'stop' for stop on a new line.");
		System.out.println("WARNING: This will overwrite your file.");
		String tempString = "";
		for (int i = 0; i < 2; i++) {
			tempString = x.nextLine();
			if ( tempString.length() == 4 &&
					(tempString.toLowerCase()).equals("stop") ) {
				break;
			} else {
				bw.write(tempString);
			}
		} bw.close();
		
	}
	public static void openAndRead(String targetFile) throws IOException{
		String sCurrentLine;
		String tempFile = defualtFolder + targetFile + ".txt";
		File userFileFolder = new File(tempFile);
		BufferedReader br = new BufferedReader(new FileReader(userFileFolder));
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
	}
	public static void main(String args[]) {
		
		if (!defualtFolderNotUsed.exists()) {
			defualtFolderNotUsed.mkdir();
		}
		CharSequence editSequence = "edit";
		Scanner x = new Scanner(System.in);
		System.out.println("Open or Edit?");
		String temp = x.nextLine();		
		System.out.println("Please Enter Name of Text File");
		String userFile = x.nextLine();
		
		if ((temp.toLowerCase()).contains(editSequence)) {
			try {
				editingFile(userFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Please enter a valid directory.");
			}
		} else if (!(temp.toLowerCase()).contains(editSequence)){
			try {
				openAndRead(userFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Please enter a valid directory.");
			}
		}
		
	}
}
