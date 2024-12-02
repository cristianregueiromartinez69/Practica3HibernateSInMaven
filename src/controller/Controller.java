package controller;

import model.dto.PokedexDTO;
import model.entity.Adestrador;
import model.entity.Pokedex;
import services.crud.HibernateCrud;
import services.metodosclases.MetodosAdestrador;
import services.metodosclases.MetodosPokedex;
import services.metodosclases.MetodosPokemon;
import services.serializar.LecturaEscrituraFicheros;
import services.xml.LecturaEscrituraXml;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    private void inserccionDatosPokedex(HibernateCrud crud, MetodosPokedex metodosPokedex) {
        crud.insertar10PokemonsInPokedex(metodosPokedex.getPokemonsList());
    }

    private void inserccionDatosAdestrador(HibernateCrud crud, MetodosAdestrador metodosAdestrador) {
        crud.insertar2AdestradoresInAdestrador(metodosAdestrador.getAdestradoresList());
    }

    private void inserccionDatosPokemon(HibernateCrud crud, MetodosPokemon metodosPokemon) {
        crud.insertar12PokemonsInPokemonDB(metodosPokemon.getPokemonList(crud.getPokedexFromDB(), crud.getAdestradorFromDB()));
    }

    public void inserccionDatosDB(HibernateCrud crud, MetodosPokedex metodosPokedex, MetodosAdestrador metodosAdestrador, MetodosPokemon metodosPokemon) {
        inserccionDatosPokedex(crud, metodosPokedex);
        inserccionDatosAdestrador(crud, metodosAdestrador);
        inserccionDatosPokemon(crud, metodosPokemon);
    }

    public void lecturaDatosDB(HibernateCrud crud, MetodosPokedex mePdex, MetodosAdestrador mAdes, MetodosPokemon mPok) {
        lecturaDatosPokedexDb(crud, mePdex);
        lecturaDatosAdestradorDb(crud, mAdes);
        lecturaDatosPokemonDb(crud, mPok);
    }

    public void actualizacionDatosPokedex(HibernateCrud crud, Integer id, String nome, BigDecimal peso, String misc) {
        crud.update2EntradasPokedex(id, nome, peso, misc);
    }

    public void actualizacionDatosAdestrador(HibernateCrud crud, Integer id, String nome, LocalDate nacemento) {
        crud.update2EntradasAdestrador(id, nome, nacemento);
    }

    public void actualizacionDatosPokemon(HibernateCrud crud, Integer id, String nome, LocalDate nacemento) {
        crud.update4EntradasPokemons(id, nome, nacemento);
    }




    public void lecturaDatosPokedexDb(HibernateCrud crud, MetodosPokedex metodosPokedex) {
        metodosPokedex.leerDatosPOkedexDB(crud.getPokedexFromDB());
    }

    public void lecturaDatosAdestradorDb(HibernateCrud crud, MetodosAdestrador metodosAdestrador) {
        metodosAdestrador.leerAdestradorList(crud.getAdestradorFromDB());
    }

    public void lecturaDatosPokemonDb(HibernateCrud crud, MetodosPokemon metodosPokemon) {
        metodosPokemon.leerDatosPokemons(crud.getPokemonFromDB());
    }

    public void serializarFicheroPOkedex(LecturaEscrituraFicheros lef, List<PokedexDTO> pokedexList, String path) {
        lef.writeFilePokedex(pokedexList, path);
    }

    public void escribirLerrXml(LecturaEscrituraXml leXML, List<Adestrador> adestradorList, String path) {
        leXML.writeXMLFile2EntradasAdestrador(adestradorList, path);
    }

    public void deleteDatosDB(HibernateCrud crud, String query){
        crud.deleteDataDB(query);
    }

}
