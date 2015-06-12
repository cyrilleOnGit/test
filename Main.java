package activiteGit;

public class Main {

	public static void main(String[] args) {
		
		DataIO fichierReadMe = new DataIO();
		String data = " Simple vérification du bon chargement du fichier à l'appel du constructeur";
		
		fichierReadMe.writeMessage(data);
		System.out.println(fichierReadMe.readMessage());
	}

}
