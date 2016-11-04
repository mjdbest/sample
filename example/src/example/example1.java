package example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class example1 {
	public static void main(String args[]){
	String hostname = ""; 
	String username = ""; 
	String password = ""; 
	//Connect to SFTP server location as below 
	SshParameters params = new SshParameters(hostname,username,password); 
	Sftp sftp = new Sftp(params); 
	sftp.connect(); 
	//Once connected to server get InputStream as below 

	InputStream io = sftp.getInputStream(fileName,0L)// File name i.e to be read and second argument is offset 
	DataInputStream in = new DataInputStream(io); 
	BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
	//Read line by line as below 
	String record=""; 
	while((record=br.readLine()) != null){ 
	// What ever you required 
	} }
}
