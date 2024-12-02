package services.serializar;

import model.dto.PokedexDTO;
import model.entity.Pokedex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscrituraFicheros {

    public void writeFilePokedex(List<PokedexDTO> pokedexList, String path) {
        File file = new File(path);

        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    auxWriteFileSerializadoPokedex(pokedexList, path);
                }
            } else {
                if (file.isFile()) {
                    auxWriteFileSerializadoPokedex(pokedexList, path);
                }
            }
        } catch (IOException e) {
            System.out.println("Ups, error al escribir en el fichero serializado de pokedex");
        }
    }

    private void auxWriteFileSerializadoPokedex(List<PokedexDTO> pokedexList, String path) throws IOException {
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));

        for (int i = 0; i < 2; i++) {
            ous.writeObject(pokedexList.get(i));
        }
        ous.close();
        System.out.println("2 entradas de pokedex serializadas correctamente");
    }

    public List<PokedexDTO> getPokedexDtoFromFile(String path) {
        File file = new File(path);
        List<PokedexDTO> pokedexList = new ArrayList<>();
        if(file.exists() && file.isFile()){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

                PokedexDTO pokedexDTO;

                while((pokedexDTO = (PokedexDTO) ois.readObject()) != null){
                    pokedexList.add(pokedexDTO);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Ups, archivo para serializar pokedex no encontrada");
            } catch (IOException e) {
                System.out.println("Ups, ha ocurrido un error en la lectura del fichero serializado pokedex");
            } catch (ClassNotFoundException e) {
                System.out.println("Ups, clase PokedexDTO no encontrada");
            }
        }
        return pokedexList;
    }

}

