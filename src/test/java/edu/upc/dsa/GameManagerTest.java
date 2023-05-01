package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GameManagerTest {

    GameManager manager = GameManagerImpl.getInstance();

    Logger logger = Logger.getLogger(GameManagerTest.class);
    @Before
    public void Inicializar() {

        manager = new GameManagerImpl();
        manager.addUsuario("Jose", "Larrinzal", "Jimenez", "090700", "algo@gmail.com", "supersegura1");
        manager.addUsuario("Pedro", "Lopez", "Lopez", "140200", "prueba@gmail.com", "supersegura2");

        manager.addObjeto("pikachu","tipo electrico", 59.99);
        manager.addObjeto("charmander","tipo fuego", 45.99);

    }

    @Test
    public void addUsuario() {
        manager.addUsuario("Hola","Prueba","xd", "090909","asdsd","asd");
    }

    @Test
    public void addObjeto(){
        manager.addObjeto("torchic","tipo fuego",49.99);
    }

    @Test
    public void Compra(){
        manager.hacerCompra("Jose", "charmander");
        manager.hacerCompra("Jose", "pikachu");
        manager.hacerCompra("Pedro", "pikachu");
        manager.hacerCompra("Juan", "pikachu");
        manager.addUsuario("Juan","Prueba","xd", "090909","asdsd","asd");
        manager.hacerCompra("Juan", "pikachu");
    }

    @Test
    public void login(){
        manager.login("DSA@gmail.com","1234");
        manager.login("algo@gmail.com","supersegura1");
    }
}
