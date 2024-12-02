package services.crud;

import config.HibernateConfig;
import model.entity.Adestrador;
import model.entity.Pokedex;
import model.entity.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class HibernateCrud {

    public void insertar10PokemonsInPokedex(List<Pokedex> pokedexList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Pokedex pokedex : pokedexList) {
                session.save(pokedex);
            }
            transaction.commit();
            System.out.println("Pokemons guardados en la base de datos pokedex correctamente");
        }
    }

    public void insertar2AdestradoresInAdestrador(List<Adestrador> adestradorList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Adestrador adestrador : adestradorList) {
                session.save(adestrador);
            }

            transaction.commit();

            System.out.println("Adestradores guardados en la base de datos adestradores correctamente");
        }
    }

    public void insertar12PokemonsInPokemonDB(List<Pokemon> pokemonList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Pokemon pokemon : pokemonList) {
                session.save(pokemon);
            }
            transaction.commit();

            System.out.println("Pokemons insertados en la base pokemon correctamente");
        }
    }

    public List<Pokedex> getPokedexFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokedex> pokedexList = session.createQuery("from Pokedex", Pokedex.class).getResultList();
            transaction.commit();

            return pokedexList;
        }
    }

    public List<Adestrador> getAdestradorFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Adestrador> adestradorList = session.createQuery("from Adestrador", Adestrador.class).getResultList();

            transaction.commit();

            return adestradorList;
        }
    }

    public List<Pokemon> getPokemonFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokemon> pokemonList = session.createQuery("from Pokemon", Pokemon.class).getResultList();

            transaction.commit();

            return pokemonList;
        }
    }

    public void update2EntradasPokedex(Integer id, String newNome, BigDecimal newPeso, String newMisc){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("UPDATE Pokedex p SET p.nome = :newNome, p.peso = :newPeso, p.misc = :newMisc WHERE id = :id")
                    .setParameter("id", id)
                    .setParameter("newNome", newNome)
                    .setParameter("newPeso", newPeso)
                    .setParameter("newMisc", newMisc)
                    .executeUpdate();

            transaction.commit();

            System.out.println("Dato de pokedex actualizada con éxito");
        }
    }

    public void update2EntradasAdestrador(Integer id, String newNome, LocalDate newNacemento){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("UPDATE Adestrador p SET p.nome = :newNome, p.nacemento = :newNacemento WHERE id = :id")
                    .setParameter("id", id)
                    .setParameter("newNome", newNome)
                    .setParameter("newNacemento", newNacemento)
                    .executeUpdate();

            transaction.commit();

            System.out.println("Dato de adestrador actualizada con éxito");
        }
    }

    public void update4EntradasPokemons(Integer id, String newNome, LocalDate newNacemento){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("UPDATE Pokemon p SET p.nome = :newNome, p.nacemento = :newNacemento WHERE id = :id")
                    .setParameter("id", id)
                    .setParameter("newNome", newNome)
                    .setParameter("newNacemento", newNacemento)
                    .executeUpdate();

            transaction.commit();

            System.out.println("Dato de pokemon actualizada con éxito");
        }
    }

    public void deleteDataDB(String query){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery(query).executeUpdate();

            transaction.commit();

            System.out.println("Datos de la tabla eliminados correctamente");
        }
    }








}
