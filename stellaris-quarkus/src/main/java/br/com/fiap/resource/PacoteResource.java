package br.com.fiap.resource;

import br.com.fiap.bo.PacoteBO;
import br.com.fiap.entities.Pacote;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/pacote")
public class PacoteResource {

    private PacoteBO pacoteBO = new PacoteBO();

    // Selecionar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Pacote> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Pacote>) pacoteBO.selecionarBo();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacote buscarPorIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        return (Pacote) pacoteBO.buscarPorIdBo(id);
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Pacote pacote, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        pacoteBO.inserirBo(pacote);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(pacote.getId()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Pacote pacote) throws ClassNotFoundException, SQLException {
        pacoteBO.atualizarBo(pacote);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        pacoteBO.deletarBo(id);
        return Response.ok().build();
    }
}
