package Files;

import java.io.*;

public class TransformaImagen {
    File f = null;

    public TransformaImagen(File fEnt) throws FileNotFoundException {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        try {
            if (fEnt.getName().endsWith(".bmp")) {
                FileInputStream arch = new FileInputStream(fEnt);
            } else {
                System.out.println("Extension incorrecta.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe, compruebe la ruta.");
        }
        f=fEnt;
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
        if (f == null){
            System.out.println("No se puede realizar la transformacion, compruebe el archivo o la ruta");
            return;
        }
        FileInputStream arch = new FileInputStream(f);
        byte[] byteInicial = new byte[54];
        arch.read(byteInicial);
        String nombre = f.getName().substring(0, f.getName().lastIndexOf(".")) + "_n.bmp";
        FileOutputStream arch_n = new FileOutputStream(new File(f.getParent(), nombre));
        arch_n.write(byteInicial);
        int resto;
        while((resto = arch.read()) != -1){
            resto = 255 - resto;
            arch_n.write(resto);
        }
        arch.close();
        arch_n.close();

        getNombreSinExtension();
    }

    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
        if(f == null){
            System.out.println("No se puede realizar la transformacion, compruebe el archivo o la ruta.");
            return;
        }
        FileInputStream arch = new FileInputStream(f);
        byte[] byteInicial = new byte[54];
        arch.read(byteInicial);
        String nombre = f.getName().substring(0, f.getName().lastIndexOf(".")) + "_o.bmp";
        FileOutputStream arch_o = new FileOutputStream(new File(f.getParent(), nombre));
        arch_o.write(byteInicial);
        int resto;
        while((resto = arch.read()) != -1){
            resto /= 2;
            arch_o.write(resto);
        }
        arch.close();
        arch_o.close();

        getNombreSinExtension();
    }

    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
        if(f == null){
            System.out.println("No se puede realizar la transformacion, compruebe el archivo o la ruta.");
            return;
        }
        FileInputStream arch = new FileInputStream(f);
        byte[] byteInicial = new byte[54];
        arch.read(byteInicial);
        String nombre = f.getName().substring(0, f.getName().lastIndexOf(".")) + "_bn.bmp";
        FileOutputStream arch_bn = new FileOutputStream(new File(f.getParent(), nombre));
        arch_bn.write(byteInicial);
        int r, g, b;
        while((b = arch.read()) != -1){
            r = arch.read();
            g = arch.read();
            int media = (r + g + b) /3;
            arch_bn.write(media);
            arch_bn.write(media);
            arch_bn.write(media);
        }
        arch.close();
        arch_bn.close();

        getNombreSinExtension();

    }

    private String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        String nom_f = f.getName().substring(0, f.getName().lastIndexOf("."));
        System.out.println("Nombre Archivo: " + nom_f);

        return nom_f;
    }
}