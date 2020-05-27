/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Tipodocumento;
import entities.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.DataConnect;

public class PersonaDAO {

    private final static DateFormat FORMATO_FINAL = new SimpleDateFormat("yyyy-MM-dd");

    public static void registrar(Persona persona) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String fechaNacimientoFormatoFinal = FORMATO_FINAL.format(persona.getFechaNacimiento());
            con = DataConnect.getConnection();
            ps = con.prepareStatement(
                    "Insert into persona (nombres, apellidos, tipoDocumento, " +
                        "numeroDocumento, email, telefono, fechaNacimiento) " +
                    "values ('"
                        + persona.getNombres() + "', '"
                        + persona.getApellidos() + "', '" 
                        + persona.getTipoDocumento().getIdTipoDocumento() + "', '"
                        + persona.getNumeroDocumento() + "', '"
                        + persona.getEmail() + "', '"
                        + persona.getTelefono() + "', '"
                        + fechaNacimientoFormatoFinal
                    + "')"
            );

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Registro Persona error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
        }
    }

}
