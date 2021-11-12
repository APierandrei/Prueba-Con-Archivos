//probando visual studio code
package filework;

import java.io.*;

public class CreandoArchivos {

	public static void creandoArchivo(String ruta, String unTexto) throws IOException {
		File fopen = new File(ruta); // este forma de creaci�n sobreescribe el archivo si existe, pero no puede crear
									// las carpeta si no existen previamente.

		FileWriter fw = new FileWriter(fopen);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(unTexto);

		bw.close();
	}

	public static String leyendoArchivo(String ruta) throws IOException {
		String linea = "";
		if (chkFile(ruta)) {
			File fopen = new File(ruta);
			FileReader fr = new FileReader(fopen);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			br.close();
		} else {
			return "no hay archivo";
		}

		return linea;
	}

	public static void borrarArchivo(String ruta) {
		File fopen = new File(ruta);
		fopen.delete();
	}

	public static boolean chkFile(String ruta) throws IOException {

		File fopen = new File(ruta);
		return fopen.exists();
	}

	public static void main(String[] args) throws IOException {
		// archivo creado en la ruta por defecto del proyecto si no se agrega ninguna
		// ruta. Para indicar las carpetas se usa "/" en lugar de "\".
		String ruta = "Archivo de Ejemplo (borrar).txt";
		String unTexto = "0";
		boolean borrar = true;

		for (int i = 0; i <= 5000; i++) {
			unTexto += " - ";
			unTexto += (int) (Math.random() * 5000);
		}

		creandoArchivo(ruta, unTexto);

		System.out.println(leyendoArchivo(ruta));

		if (leyendoArchivo(ruta).equals(unTexto)) {
			System.out.println("Seeeee");
		} else {
			System.out.println("some problem here");
		}

		if (chkFile(ruta) && borrar) {
			borrarArchivo(ruta);
		}

	}
}