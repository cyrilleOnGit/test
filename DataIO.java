package activiteGit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataIO {
	private File file;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String message;
	
	public DataIO(){
		this.dis = null;
		this.dos = null;
		this.message = "";
		this.file = new File("");
		String path = "";
		char reponse = 'N';
		Scanner scanPath = new Scanner(System.in);
		
		//Détermination du path de README.TXT
		while(reponse != 'O'){
			path = file.getAbsolutePath();
			System.out.println("Le chemin courrant est \"" + path 
					+ ".\nComplétez le au besoin :");
			path=path.concat(scanPath.nextLine());
			System.out.println("Le path du fichier README.TXT sera : " +path
								+"\nS'il n'existe pas il sera créé !\n"
								+ "Veuillez confirmer en saisissant 'O' :");
			reponse = scanPath.nextLine().charAt(0);
		}
		scanPath.close();
		System.out.println("Fait");
		
		if(path.charAt(path.length()-1)!='/'){
			path = path.concat("/");
		}
		
		//Création de README.txt
		this.file = new File(path + "README.txt");
		if(!this.file.exists()){
			try {
				file.createNewFile();
				System.out.println("Création de " + this.file.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println(this.file.getPath() + " existe déjà");
		}
	}
	
	//méthode qui lit le Fichier README.txt
	public String readMessage(){
		//Ouverture du flux en lecture
		try {
			this.dis = new DataInputStream (
							new BufferedInputStream (
									new FileInputStream (this.file)));
			
			//lecture de la chaîne de caractères;
			try {
				this.message = dis.readUTF();
			} catch (IOException e) {
				System.out.println("fichier vide !");
			} 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//fermeture du flux
		}finally{
			
			if(this.dis != null){
				try {
					this.dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return this.message;
	}
	
	public void writeMessage (String message){
		//Ouverture du flux en écriture
		try {
			
			this.dos = new DataOutputStream (
					new BufferedOutputStream (
							new FileOutputStream (this.file)));
			
			this.message = this.message.concat(message);
			//Écriture dans README.txt;
			try {
				this.dos.writeUTF(this.message);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//fermeture du flux
		}finally{
			
			if(this.dos != null){
				try {
					this.dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
