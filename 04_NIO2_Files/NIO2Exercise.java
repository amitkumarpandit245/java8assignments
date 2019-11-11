package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIO2Exercise {
	
	public static Tablet getTabletDetails(String file)
	{
		String[] ar=file.split(",");
		Tablet obj=new Tablet(ar[0],ar[1],LocalDate.of(Integer.parseInt(ar[2].split("/")[2]),Integer.parseInt(ar[2].split("/")[0]),Integer.parseInt(ar[2].split("/")[1])),LocalDate.of(Integer.parseInt(ar[2].split("/")[2]),Integer.parseInt(ar[2].split("/")[0]),Integer.parseInt(ar[2].split("/")[1])));
		return obj;
		
	}
	
	public static boolean isExpired(int date,int month, int year) {
		LocalDate currentDate=LocalDate.now();
		LocalDate expiryDate=LocalDate.of(year, month, date);
		boolean res=expiryDate.isBefore(currentDate);
		return res;
	}
	public static boolean isCompany(String comp , String manufacturer) {
		return comp.equalsIgnoreCase(manufacturer);
	}

	
	  public static Map<String,LocalDate> getExpiredTablets(String filename, String manufacturer)
	  { 
		  Map<String,LocalDate> res=new LinkedHashMap<>();
	  try(Stream<String> data=Files.lines(Paths.get("data",filename))){
		  res=data.map(NIO2Exercise::getTabletDetails)
				  .filter(f -> f.getManufacturer().equalsIgnoreCase(manufacturer)).filter(d-> d.expiryDate.isBefore(LocalDate.now()))
				  .collect(Collectors.toMap(Tablet::getTabletName,Tablet::getExpiryDate));
	 
	 } catch(IOException e) {
	 
	 } return null;
	  
	 }
	 
	public static void listAllJavaFiles() {
		try(Stream<Path> data=Files.walk(Paths.get("src"))){
			data.filter(f -> f.toString().contains(".java"))
			.forEach(System.out::println);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void searchFile(String fileName,String dir) {
		try(Stream<Path> data=Files.walk(Paths.get(dir))){
			data.filter(f -> f.toString().contains(fileName))
			.forEach(System.out::println);
		}
		catch(IOException e) {
			System.out.println("Files cannot be found");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		listAllJavaFiles();
		searchFile("hidden.txt","src//file//data//");
		Map<String,LocalDate> res=getExpiredTablets("tablet_details.txt", "mno");
		System.out.println(res);
	}

}