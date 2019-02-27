package br.com.estudos_tesseract.leitor_de_imagem;

import java.io.File;
import java.io.FileFilter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LeitorImagem {
	public static void main(String[] args) {

		String caminho = "C:\\Teste";
		String extension = ".png";
		
		// lista os arquivos do diretorio (caminho, extensão)
				dumpFiles(getAllFiles(caminho, extension));

			}

			private static void dumpFiles(File[] files) {
				for (File file : files) {
					lerImagem(file);
				}
			}

			private static File[] getAllFiles(String caminho, final String extension) {
				File dir = new File(caminho);
				// filtro pela extensão procurada
				FileFilter filter = null;
				if (extension != null) {
					filter = new FileFilter() {
						public boolean accept(File pathname) {
							return pathname.getAbsolutePath().endsWith(extension);
						}
					};
				}
				// lista os arquivos que correspondem ao match
				return dir.listFiles(filter);
			}

	private static void lerImagem(File file) {

		File imageFile = file;
		ITesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\dev04.TARGETIT\\eclipse-workspace\\leitor-de-imagem\\tessdata"); 
		instance.setLanguage("por");

		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}
}
