package assembleur;

/**
 * Classe pour convertir des nombre dans une autre base
 * 
 * @author Thomas
 *
 */
public class Converter {

	/**
	 * Convertit une chaine binaire en chaine hexa
	 * 
	 * @param binaryString - La chaine en binaire
	 * @return
	 */
	public static String binaryToHexa(String binaryString) {
		int i = Integer.parseUnsignedInt(binaryString, 2);
		return Integer.toHexString(i);
	}

	/**
	 * Convertit un nombre en hexa
	 * 
	 * @param number - Le nombre
	 * @return
	 */
	public static String integerToHexa(int number) {
		return Integer.toHexString(number);
	}

	/**
	 * Convertit un entier en une chaine binaire d'une longueur définie. Complète le
	 * chaine avec des 0.
	 * 
	 * @param number - L'entier a convertir
	 * @param length - La longueur de la chaine binaire en sortie
	 * @return
	 */
	public static String integerToBinary(int number, int length) {
		String s = Integer.toBinaryString(number);
		final int NB_0_MANQUANTS = length - s.length();

		String zero = "";
		for (int i = 0; i < NB_0_MANQUANTS; i++) {
			zero += '0';
		}

		return zero + s;
	}
}