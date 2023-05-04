package edu.upc.dsa.services;


import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.dto.Login;
import edu.upc.dsa.models.dto.RegistroTO;
import edu.upc.dsa.models.dto.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/Game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {

    private GameManager manager;

    public GameService() {
        this.manager = GameManagerImpl.getInstance();
        if (manager.size() == 0) {
            this.manager.addObjeto("pokeball", "Captura Pokemon", 5.00);
            this.manager.addUsuario("Jose", "jose@gmail.com", "Ji");
            this.manager.addUsuario("Prueba", "Sí", "También");
        }
    }

    //Registrar Usuario
    @POST
    @ApiOperation(value = "Registrar usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/RegistrarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RegistrarUsuario(RegistroTO usuario) {

        Usuario usuario1 = new Usuario(usuario.getNombre(),usuario.getCorreo(), usuario.getPassword());
        if (usuario1.getUsuario().isEmpty() || usuario1.getCorreo().isEmpty() || usuario1.getPassword().isEmpty()){
            return Response.status(500).build();

        }

        Usuario name = this.manager.getUsuarioPorNombre(usuario.getNombre());
        Usuario correo = this.manager.getUsuarioPorCorreo(usuario.getCorreo());
        if (name != null || correo != null){
            return Response.status(500).build();

        }
        else{
            this.manager.addUsuario(usuario1.getUsuario(), usuario1.getCorreo(), usuario1.getPassword());
            return Response.status(200).build();
        }


       /* if (usuario.getNombre()==null) return Response.status(500).entity(usuario).build();
        this.manager.addUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getPassword());
        return Response.status(201).entity(usuario).build();*/
    }

    //Añadir objeto
    @POST
    @ApiOperation(value = "crear objeto nuevo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objeto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addObjeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addObjeto(Objeto objeto) {

        if (objeto.getNombre()==null || objeto.getDescripcion()==null || objeto.getPrecio()==0.00)  return Response.status(500).entity(objeto).build();
        this.manager.addObjeto(objeto.getNombre(), objeto.getDescripcion(),objeto.getPrecio());
        return Response.status(201).entity(objeto).build();
    }



    //login
    @POST
    @ApiOperation(value = "login usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Login.class),
            @ApiResponse(code = 404, message = "No existe")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Login credencials) {
        Usuario u = this.manager.getUsuarioPorCorreo(credencials.getCorreo());
        if (u != null) {
            if (u.getPassword().equals(credencials.getPassword())) {
                return Response.status(201).entity(u).build();
            }
        }
        return Response.status(404).build();
    }


    // comprar objetos por parte de un usuario
    /*@POST
    @ApiOperation(value = "crear objeto nuevo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/{Usuario}/{nombreObjeto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerCompra(@PathParam("Usuario")  String Usuario, @PathParam("nombreObjeto")  String nombreObjeto) {
        Objeto objeto = this.manager.getObjetoPorNombre(nombreObjeto);
        UsuarioTO usuario = this.manager.getUsuarioPorNombre(Usuario);
        if (objeto.getNombre()==null || objeto.getDescripcion()==null)  return Response.status(500).build();
        this.manager.hacerCompra(usuario.getNombre(), objeto.getNombre());
        return Response.status(201).entity(objeto).build();
    }*/

}