package Controlador;

import java.sql.Connection;
import java.util.Scanner;

import Erabilgarriak.Mendiak;
import Erabilgarriak.konexioa;
import Erabilgarriak.Monte;

public class Controlador {

	public static void main(String[] args) {
		Mendiak mendiak = new Mendiak();
		konexioa k1 = new konexioa();
		menua(k1, mendiak);
	}

	private static void menua(konexioa k1, Mendiak mendiak) {
		Connection saioa = null;
		Scanner sc = new Scanner(System.in);
		int aukera = -1;
		do {
			System.out.println("1.- Cargar montes (txt)\r\n" + "2.- Cargar montes (bd)\r\n" + "3.- Añadir monte\r\n"
					+ "4.- Mostrar montes\r\n" + "5.- Mostrar monte por nombre\r\n" + "6.- Eliminar monte\r\n"
					+ "7.- Guardar montes (bd)\r\n" + "0.- Fin");
			aukera = balidatuZenbakia(sc, "Sartu aukera (0-7)", 0, 7);
			switch (aukera) {
			case 1:
				break;
			case 2:
				saioa = kargatu(k1, mendiak);
				break;
			case 3:
				gehitu(sc, mendiak);
				break;
			case 4:
				agendaPantailaratu(mendiak);
				break;
			case 5:
				bilatu(sc, mendiak);
				break;
			case 6:
				ezabatu(sc, mendiak);
				break;
			case 7:
				gorde(saioa, k1, mendiak);
				break;
			}
		} while (aukera != 0);

	}

	private static void ezabatu(Scanner sc, Mendiak mendiak) {
		System.out.println("Sartu izena");
		String Izena = sc.nextLine();
		mendiak.kenduMendiaIzena(Izena);
	}

	private static void gehitu(Scanner sc, Mendiak mendiak) {
		String altuera = "";
		System.out.println("Sartu izena");
		String izenburu = sc.nextLine();
		System.out.println("Sartu probintzia");
		String isbn = sc.nextLine();

		do {
			System.out.println("Sartu altuera");
			altuera = sc.nextLine();
		} while (balidatuZenbakia(sc, "100 eta 2000 artean", 100, 2000) == -1);

		System.out.println("Sartu koordenadak");
		String kor = sc.nextLine();
		System.out.println("Sartu macizo");
		String macizo = sc.nextLine();
		System.out.println("Sartu ruta");
		String ruta = sc.nextLine();
		Monte monte = new Monte(izenburu, isbn, Integer.valueOf(altuera), kor, macizo, ruta);
		mendiak.sartuMendia(monte);
	}

	private static void agendaPantailaratu(Mendiak mendiak) {
		System.out.println(mendiak.aurkeztuDenak());
	}

	private static void bilatu(Scanner sc, Mendiak mendiak) {
		System.out.println("Sartu titulua");
		String tit = sc.nextLine();
		System.out.println(mendiak.aurkeztuIzena(tit));
	}

	private static int balidatuZenbakia(Scanner sc, String string, int min, int max) {
		int aukera = -1;
		boolean error = true;
		do {
			System.out.println(string);
			String textua = sc.nextLine();
			try {
				aukera = Integer.valueOf(textua);
				if (aukera >= min && aukera <= max)
					error = false;

			} catch (Exception ex) {
				error = true;
			}
		} while (error);
		return aukera;
	}
	private static void gorde(Connection saioa, konexioa k1, Mendiak mendiak) {
		k1.gorde(saioa, mendiak);
	}

	private static Connection kargatu(konexioa k1, Mendiak mendiak) {
		Connection saioa = k1.hasi();
		mendiak = k1.mendiaLoadbd(saioa, mendiak);
		System.out.println("Kargatuta datubasetik");
		return saioa;
	}
}