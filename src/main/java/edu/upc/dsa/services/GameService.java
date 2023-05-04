package edu.upc.dsa.services;


import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.dto.Credencials;
import edu.upc.dsa.models.dto.UsuarioTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    //Añadimos usuario
    @POST
    @ApiOperation(value = "Añadir usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= UsuarioTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuario(UsuarioTO usuario) {

        if (usuario.getNombre()==null) return Response.status(500).entity(usuario).build();
        this.manager.addUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getPassword());
        return Response.status(201).entity(usuario).build();
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
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "No existe")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credencials credencials) {
        UsuarioTO u = this.manager.getUsuarioPorCorreo(credencials.getCorreo());
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