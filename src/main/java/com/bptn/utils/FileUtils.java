package com.bptn.utils;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


public class FileUtils {
	public static String HOME = System.getProperty("user.dir");
	
	public static boolean isFileExist(Path p) throws IOException {
		 return Files.exists(p);
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
	
	public static void readFile(Path p) {
		try {
			Scanner scan = new Scanner(p);
			while(scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static void deleteFile(Path p) {
		try {
			if(Files.notExists(p)) {
				Files.delete(p);							
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void writeFile(Path p) throws IOException {
		if(Files.exists(p)){
		     FileWriter writer = new FileWriter(new File(p.toUri()));
		     writer.write("Writting to file- exercise 7.5");
		     writer.close();
		 }
	}

	public static void updateFile(Path p, String update) throws IOException {
		if(Files.exists(p)){
		     FileWriter writer = new FileWriter(new File(p.toUri()));
		     writer.write(update);
		     writer.close();
		 }
	}
	
	public static void main(String[] args) throws IOException {  
		
		Path p = Paths.get(HOME + "/tests.txt");
		System.out.println(p.toUri());
		
		isFileExistsWithExceptionHandling(p);
		createFileIfNotExists(p);
		System.out.println(isFileExist(p));
				
	}
}





























