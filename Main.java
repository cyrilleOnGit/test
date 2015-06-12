package activiteGit;

public class Main {

	public static void main(String[] args) {
		
		DataIO fichierReadMe = new DataIO();
		String data = "Ce fichier est rempli avec un DataOutputStream et lu avec un DataInputStream";
		
		fichierReadMe.writeMessage(data);
		System.out.println(fichierReadMe.readMessage());
	}

}
