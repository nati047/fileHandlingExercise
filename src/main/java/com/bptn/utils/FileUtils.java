package com.bptn.utils;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileUtils {
	public static String HOME = System.getProperty("user.dir");
	
	public static boolean isFileExist(Path p) throws IOException {
		boolean fileExists = Files.exists(p);
		return fileExists;
	}
	
	public static boolean isFileExistsWithExceptionHandling(Path p) {
		try {
			Scanner input = new Scanner(new File(p.toUri()));
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void createFileIfNotExists(Path p) {
		try {
			if(!Files.exists(p)) {
				Files.createFile(p);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {  
		
		Path p = Paths.get(HOME + "/test.txt");
		System.out.println(p.toUri());
		
		createFileIfNotExists(p);
		File f1 = new File(p.toUri());
		System.out.println(isFileExist(p));
	}
}





























