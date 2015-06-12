package activiteGit;

public class Main {

	public static void main(String[] args) {
		
		DataIO fichierReadMe = new DataIO();
		String data = " La classe DataIO permet de lire et écrire dans le ce fichier."
				+ "DataIO utilise Un DataInputStream il est faut donc éditer ce fichier avec la classe prévue à cet effet!";
		
		fichierReadMe.writeMessage(data);
		//fichierReadMe.clean();
		System.out.println(fichierReadMe.readMessage());
	}

}
