package model.dao.impl;

import db.DB;
import model.dao.UrnaDAO;
import model.entities.Eleitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UrnaDAOJDBC implements UrnaDAO {

    Connection conn = null;

    public UrnaDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void votar(Eleitor eleitor, Integer numeroDoCandidato) {

        PreparedStatement st = null;
        EleitorDAOJDBC dc = new EleitorDAOJDBC(conn);
        try {
            st = conn.prepareStatement(
                    "UPDATE candidatos "
                            +"SET Votos = Votos + 1 "
                            +"WHERE "
                            +"(Numero = ?)"
            );
            if (!dc.hasVoted(eleitor)){
                st.setInt(1, numeroDoCandidato);
                st.executeUpdate();
                dc.updateVote(eleitor);
            }else{
                System.out.println("Você já votou");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }

}
