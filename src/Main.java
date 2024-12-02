import controller.Controller;
import services.crud.HibernateCrud;
import services.metodosclases.MetodosAdestrador;
import services.metodosclases.MetodosPokedex;
import services.metodosclases.MetodosPokemon;
import services.serializar.LecturaEscrituraFicheros;
import services.xml.LecturaEscrituraXml;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        HibernateCrud crud = new HibernateCrud();
        LecturaEscrituraFicheros lef = new LecturaEscrituraFicheros();
        LecturaEscrituraXml leXML = new LecturaEscrituraXml();

        Controller controller = new Controller();

        //controller.inserccionDatosDB(crud, metodosPokedex, metodosAdestrador, metodosPokemon);

        //controller.lecturaDatosDB(crud, metodosPokedex, metodosAdestrador, metodosPokemon);

        String path = "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Examen2PrimeraEvaAD/pokedex.dat";

        //controller.serializarFicheroPOkedex(lef, metodosPokedex.pokedexDTOList(crud.getPokedexFromDB()), path);


        //controller.escribirLerrXml(leXML, crud.getAdestradorFromDB(), "adestradores.xml");

        //controller.actualizacionDatosAdestrador(crud,1, "liko", LocalDate.of(2022, 4, 10));
        //controller.actualizacionDatosAdestrador(crud, 2, "polo", LocalDate.of(2010, 9, 25));

        //controller.actualizacionDatosPokedex(crud, 1, "nidoking", BigDecimal.valueOf(62.0), "cornudo");
        //controller.actualizacionDatosPokedex(crud,2, "vaporeon", BigDecimal.valueOf(29.0), "sireno");

        //controller.actualizacionDatosPokemon(crud, 1, "annihilape", LocalDate.of(2021, 2, 25));
        //controller.actualizacionDatosPokemon(crud, 2, "alomomola", LocalDate.of(2013, 4, 12));
        //controller.actualizacionDatosPokemon(crud, 3, "excadrill", LocalDate.of(2016, 12, 1));
        //controller.actualizacionDatosPokemon(crud, 4, "greninja", LocalDate.of(2018, 9, 13));


        //metodosPokedex.auxUptadePokedexDB(crud, lef, path);
        //metodosAdestrador.auxUpdateAdestradorDB(crud, leXML, "adestradores.xml");

        controller.deleteDatosDB(crud, "DELETE FROM Pokemon");
        controller.deleteDatosDB(crud, "DELETE FROM Pokedex");
        controller.deleteDatosDB(crud, "DELETE FROM Adestrador");

    }
}

/*

1. Insertar Datos (Save o Persist)
Tu implementación ya utiliza session.save(), que es el método nativo para insertar objetos en la base de datos. Este enfoque es adecuado y no requiere cambios.

java
Copiar código
public void insertar10PokemonsInPokedex(List<Pokedex> pokedexList) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        for (Pokedex pokedex : pokedexList) {
            session.save(pokedex); // Método nativo
        }
        transaction.commit();
    }
}
2. Obtener Todos los Registros
Puedes usar el método session.get() o session.load() en lugar de escribir consultas HQL explícitas para recuperar registros individuales. Sin embargo, para obtener todos los registros, necesitas CriteriaQuery o la consulta que ya tienes.

Con Criteria API, puedes evitar HQL:

java
Copiar código
public List<Pokedex> getPokedexFromDB() {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.createCriteria(Pokedex.class).list(); // Sin HQL
    }
}
Aunque createCriteria() es más declarativo, tiene menos flexibilidad que HQL para consultas más complejas.

3. Actualizar Datos
En lugar de usar HQL para actualizaciones, puedes cargar el objeto, modificar sus propiedades y luego guardarlo nuevamente. Hibernate detectará los cambios y realizará la actualización automáticamente:

java
Copiar código
public void update2EntradasPokedex(Integer id, String newNome, BigDecimal newPeso, String newMisc) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();

        // Cargar el objeto desde la base de datos
        Pokedex pokedex = session.get(Pokedex.class, id);
        if (pokedex != null) {
            pokedex.setNome(newNome);  // Actualizar propiedades
            pokedex.setPeso(newPeso);
            pokedex.setMisc(newMisc);
            session.update(pokedex); // Hibernate detecta los cambios
        }

        transaction.commit();
    }
}
Ventaja: No necesitas escribir la consulta HQL.
Desventaja: Es menos eficiente para actualizaciones masivas.
4. Eliminar Datos
Para eliminar registros, puedes cargar el objeto por su ID y usar session.delete() en lugar de escribir una consulta HQL:

java
Copiar código
public void deletePokemonById(Integer id) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();

        // Cargar el objeto
        Pokemon pokemon = session.get(Pokemon.class, id);
        if (pokemon != null) {
            session.delete(pokemon); // Método nativo para eliminar
        }

        transaction.commit();
    }
}
Si necesitas eliminar múltiples registros, HQL sigue siendo más eficiente.



 */