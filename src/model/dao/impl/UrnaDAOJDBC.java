package model.dao.impl;

import db.DB;
import model.dao.UrnaDAO;
import model.entities.Eleitor;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UrnaDAOJDBC implements UrnaDAO {

    Connection conn = null;

    public UrnaDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void votar(Eleitor eleitor, Integer numeroDoCandidato) {

        PreparedStatement stVote = null;
        PreparedStatement stElei = null;
        EleitorDAOJDBC dc = new EleitorDAOJDBC(conn);

        try {
            conn.setAutoCommit(false);
            if (!dc.hasVoted(eleitor)){
                stVote = conn.prepareStatement("UPDATE candidatos "
                        +"SET Votos = Votos + 1 "
                        +"WHERE "
                        +"(Numero = ?)");
                stVote.setInt(1, numeroDoCandidato);
                stElei = conn.prepareStatement(
                        "UPDATE eleitores "
                        +"SET hasVoted = hasVoted + 1 "
                        +"WHERE "
                        +"(Titulo = ?)");
                stElei.setInt(1, eleitor.getTitulo());
                stVote.executeUpdate();
                stElei.executeUpdate();
                conn.commit();
            }else{
                System.out.println("Você já votou");
            }
        } catch (SQLException e) {
            try{
                conn.rollback();
                System.out.println("rollback");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } finally {
            DB.closeStatement(stElei);
            DB.closeStatement(stVote);
            DB.closeConnection();
        }

    }

    @Override
    public void boletimDeUrna() {

        Statement st = null;
        ResultSet set = null;

        try{
            st = conn.createStatement();
            st.executeQuery("SELECT * FROM candidatos");
            set = st.getResultSet();
            while (set.next()){
                System.out.println(set.getInt("Numero") + "," + set.getInt("Votos"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
