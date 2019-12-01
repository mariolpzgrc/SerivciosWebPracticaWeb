/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import pojos.Alumno;

/**
 * REST Web Service
 *
 * @author mariolpzgrc
 */
@Path("alumnos")
public class AlumnosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosWS
     */
    public AlumnosWS() {
    }

    @Path("obtenerAlumnos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> getAllAlumno() {
        List<Alumno> list = null;
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            list = conn.selectList("Alumno.obtenerAlumnos");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    @POST
    @Path("autenticacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno autenticarAlumno(
            @FormParam("matricula") String matricula,
            @FormParam("curp") String curp
    ) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("matricula", matricula);
        param.put("curp", curp);
        Alumno alumno = null;
        SqlSession conn = null;

        try {
            conn = MyBatisUtils.getSession();
            alumno = conn.selectOne("Alumno.buscarAlumno", param);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(conn != null){
                conn.close();
            }
        }
        return alumno;
    }

}
