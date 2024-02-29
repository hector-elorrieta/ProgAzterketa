package Erabilgarriak;

public class Mendiak {

	private Monte[] Mendiak = new Monte[30];
	private int daude = 0;

	public String aurkeztuDenak() {
		String info = "";
		for (int i = 0; i < getDaude(); i++) {
			info += Mendiak[i].toString() + "\n";
		}
		return info;
	}
	
	public String aurkeztuIzena(String izena) {
		String info = "";
		for (int i = 0; i < getDaude(); i++) {
			if (Mendiak[i].getNombre().equals(izena)) {
				info += Mendiak[i].toString() + "\n";
			}
		}
		return info;
	}

	public void sartuMendia(Monte mendia) {
		if (!beteta()) {
			this.Mendiak[daude] = mendia;
			daude++;
		}
	}
	
	public boolean beteta() {
		boolean bete = false;
		if (this.daude == 30) {
			bete = true;
		}
		return bete;
	}

	public void kenduMendiaIzena(String izena) {
		boolean eginda = false;
		for (int i = 0; i < this.daude && eginda == false; i++) {
			if (Mendiak[i].getNombre().equals(izena)) {
				eginda = kenduMendia(i);
			}
		}

	}

	public boolean kenduMendia(int pos) {
		boolean eginda = false;
		if (pos <= this.daude) {
			for (int i = pos; i < this.daude; i++) {
				Mendiak[i] = Mendiak[i + 1];
			}
			eginda = true;
			daude--;
		}
		return eginda;
	}

	public Monte[] getMendiak() {
		return Mendiak;
	}

	public void setMendiak(Monte[] mendiak) {
		Mendiak = mendiak;
	}

	public int getDaude() {
		return daude;
	}

	public Mendiak() {
	}

}