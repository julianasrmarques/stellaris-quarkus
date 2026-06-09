package br.com.fiap.resource;

import br.com.fiap.bo.ReservaBO;
import br.com.fiap.entities.Reserva;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/reserva")
public class ReservaResource {

    private ReservaBO reservaBO = new ReservaBO();

    // Selecionar todas
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Reserva> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Reserva>) reservaBO.selecionarBo();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva buscarPorIdRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        return (Reserva) reservaBO.buscarPorIdBo(id);
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Reserva reserva, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        reservaBO.inserirBo(reserva);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(reserva.getId()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Reserva reserva) throws ClassNotFoundException, SQLException {
        reservaBO.atualizarBo(reserva);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        reservaBO.deletarBo(id);
        return Response.ok().build();
    }
}
