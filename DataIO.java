package activiteGit;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataIO {
	private File file;
	
	public DataIO(){
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
}
