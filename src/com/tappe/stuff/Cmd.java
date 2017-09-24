package com.tappe.stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cmd {

	public static void main(String[] args) throws IOException {
		String[] cmd = new String[] { "cmd.exe", "/C", "wmic process get name" };
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			Dar dar = new Dar(process.getInputStream());
			new Thread(dar).start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(sc.nextLine());
		}
		File file=new File("tt.txt");
		if(!file.exists()){
			file.createNewFile();
		}else{
			file.delete();
			file.createNewFile();
		}
	
	}

}

class Dar implements Runnable {
	private InputStream ins;

	public Dar(InputStream ins) {
		this.ins = ins;
	}

	public Dar() {
	}

	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
