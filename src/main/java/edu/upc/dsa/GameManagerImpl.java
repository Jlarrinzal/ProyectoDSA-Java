package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManagerImpl implements GameManager {

    HashMap<String, Usuario> Usuarios;
    List<Usuario> listaUsuarios;
    HashMap<String, Objeto> Objetos;
    List<Objeto> listaObjetos;

    private static GameManager instance;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    public GameManagerImpl(){
        this.listaUsuarios = new ArrayList<>();
        this.Usuarios = new HashMap<>();
        this.listaObjetos = new ArrayList<>();
        this.Objetos = new HashMap<>();
    }

    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImpl();
        return instance;
    }

    @Override
    public void addUsuario(String nombre, String apellido, String apellido2, String fecha, String correo, String password) {

        if (Usuarios.get(correo) == null){

            this.listaUsuarios.add(new Usuario(nombre, apellido, apellido2, fecha, correo, password));

            logger.info("Se ha realizado correctamente");
        }
        else
            logger.info("El correo ya existe con un usuario");
    }

    @Override
    public void addObjeto(String nombre, String descripcion, double precio) {

        this.listaObjetos.add(new Objeto(nombre, descripcion, precio));
        logger.info("Se ha añadido correctamente");
    }

    @Override
    public void login(String correo, String password) {

        Usuario usuario = this.listaUsuarios.get(correo);
        if(usuario != null && usuario.getPassword().equals(password)){
            logger.info("Login con éxito");
        }
        logger.info("Contraseña incorrecta");
    }

    @Override
    public Objeto hacerCompra(String Usuario, String nombreObjeto) {

        Usuario usuario = getUsuarioPorNombre(Usuario);
        if (usuario == null) {
            logger.info("Usuario " + Usuario + " no existe");
        }
        else {
            Objeto objeto = getObjetoPorNombre(nombreObjeto);
            if (usuario.getDsaCoins() < objeto.getPrecio()) {
                logger.info("No tienes money");
            }
            else{
                usuario.getListaObjetosComprados().add(objeto);
                double saldo = usuario.getDsaCoins() - objeto.getPrecio();
                usuario.setDsaCoins(saldo);
                logger.info("Objeto " + nombreObjeto + " comprado");
                logger.info(Usuario + " ahora tienes: " + saldo + " dsaCoins");
                return objeto;
            }
        }
        return null;
    }

    //extras

    public Usuario getUsuarioPorNombre(String nombre){
        for (Usuario u: this.listaUsuarios) {
            if(u.getNombre().equals(nombre)){
                return u;
            }
        }
        return null;
    }

    public Objeto getObjetoPorNombre(String nombre){
        for (Objeto o: this.listaObjetos) {
            if(o.getNombre().equals(nombre)){
                return o;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    // public int size() {
     //   int ret = this.tracks.size();
       // logger.info("size " + ret);

        //return ret;
    //}

}