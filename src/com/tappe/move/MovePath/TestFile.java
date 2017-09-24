package com.tappe.move.MovePath;

 
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;

public class TestFile {

	public static void main(String[] args) throws Exception {

		File file = new File("src/com/tappe/move/movefile/path");
		System.out.println(file.getAbsolutePath());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String read = null;
		while ((read = br.readLine()) != null) {
			 
		}

		br.close();
		fr.close();
	}
}
