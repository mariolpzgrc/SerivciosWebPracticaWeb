/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import pojos.Alumno;
import pojos.Documentos;

/**
 * REST Web Service
 *
 * @author mariolpzgrc
 */
@Path("documentos")
public class DocumentosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DocumentosWS
     */
    public DocumentosWS() {
    }

    @Path("obtenerDocumentos/{idAlumno}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Documentos> obtenerDocumentosPorAlumno(
            @PathParam("idAlumno") Integer idAlumno
    ) {
        List<Documentos> list = null;
        SqlSession conn = null;

        try {
            conn = MyBatisUtils.getSession();
            list = conn.selectList("Documentos.obtenerDocumentosPorAlumno", idAlumno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    @Path("subirDocumentos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje subirDocumentos(
            @FormParam("idAlumno") Integer idAlumno,
            @FormParam("identificacionOficial") String identificacionOficial,
            @FormParam("actaNacimiento") String actaNacimiento,
            @FormParam("comprobanteDomicilio") String comprobanteDomicilio,
            @FormParam("fotoInfatil") String fotoInfatil,
            @FormParam("certificadoBachillerato") String certificadoBachillerato) {

        Mensaje resultado = new Mensaje();
        HashMap<String, Object> param = new HashMap<>();
        param.put("idAlumno", idAlumno);
        param.put("identificacionOficial", identificacionOficial);
        param.put("actaNacimiento", actaNacimiento);
        param.put("comprobanteDomicilio", comprobanteDomicilio);
        param.put("fotoInfatil", fotoInfatil);
        param.put("certificadoBachillerato", certificadoBachillerato);
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.insert("Documentos.subirDocumentos", param);
            conn.commit();
            resultado.setMensaje("Se subieron los documentos con exito");
        } catch (Exception e) {
            resultado.setError(true);
            resultado.setMensaje("Error al subir los documentos" + e.getMessage());
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }

}
