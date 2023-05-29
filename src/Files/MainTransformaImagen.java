package Files;

import java.io.File;

import java.io.IOException;

public class MainTransformaImagen {
    public static void main(String[] args) throws IOException {

        File f = new File("/home/INFORMATICA/alu12559412/IdeaProjects/Tema7Ficheros/src/Files/penyagolosa.bmp");

        TransformaImagen ti = new TransformaImagen(f);

        ti.transformaNegativo();
        ti.transformaOscuro();
        ti.transformaBlancoNegro();

    }
}
