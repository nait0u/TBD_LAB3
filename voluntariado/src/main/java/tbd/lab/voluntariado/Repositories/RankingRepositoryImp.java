package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Table;
import tbd.lab.voluntariado.Models.Ranking;
import tbd.lab.voluntariado.Services.TareaService;
import tbd.lab.voluntariado.Services.VoluntarioService;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RankingRepositoryImp implements RankingRepository{

        @Autowired
        private Sql2o sql2o;

        @Override
        public Ranking createRanking(Ranking ranking){
                Connection conn = sql2o.open();

                String SQL_INSERT = "INSERT INTO ranking(porcentaje, id_tarea, id_voluntario)" +
                        "VALUES (:porcentaje, :id_tarea2, :id_voluntario2)";

                try{
                        conn.createQuery(SQL_INSERT)
                                .addParameter("porcentaje", ranking.getPorcentaje())
                                .addParameter("id_tarea2", ranking.getId_tarea())
                                .addParameter("id_voluntario2", ranking.getId_voluntario())
                                .executeUpdate();

                        ranking.setId(newID());

                        return ranking;

                } catch(Exception e) {
                        System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el ranking\n");
                        return null;
                }
        }


        @Override
        public int countAllRanks() {
                int total = 0;
                String sql = "SELECT COUNT(*) FROM ranking";
                try (Connection conn = sql2o.open()) {
                        total = conn.createQuery(sql).executeScalar(Integer.class);
                        return total;
                }
        }


        @Override
        public int newID() {
                int id = 0;
                String sql = "SELECT MAX(id) FROM ranking";
                try (Connection conn = sql2o.open()) {
                        id = conn.createQuery(sql).executeScalar(Integer.class);
                        return id;
                }
        }


        @Override
        public List<Ranking> getAll() {
                try(Connection conn = sql2o.open()){
                        return conn.createQuery("SELECT * FROM ranking ORDER BY Ranking.id ASC")
                                .executeAndFetch(Ranking.class);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return null;
                }
        }


        @Override
        public List<Ranking> showRankingById(long id) {

                try(Connection conn = sql2o.open()){
                        return conn.createQuery("SELECT * FROM ranking WHERE ranking.id = :id")
                                .addParameter("id", id)
                                .executeAndFetch(Ranking.class);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return null;
                }
        }


        @Override
        public void deleteRankingById(long id) {
                Connection conn = sql2o.open();
                String SQL_DELETE = "DELETE FROM ranking WHERE ranking.id = :id";

                try{
                        conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

                } catch(Exception e) {
                        System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el Ranking\n");
                }
        }


        @Override
        public void updateRanking(Ranking ranking) {
                String SQL_UPDATE = "UPDATE ranking SET porcentaje = :porcentaje2, id_voluntario = :id_voluntario2, id_tarea = :id_tarea2, id = :id2 WHERE id = :id2";

                try(Connection conn = sql2o.open()) {

                        conn.createQuery(SQL_UPDATE)
                                .addParameter("porcentaje2", ranking.getPorcentaje())
                                .addParameter("id_voluntario2", ranking.getId_voluntario())
                                .addParameter("id_tarea2", ranking.getId_tarea())
                                .addParameter("id2", ranking.getId())
                                .executeUpdate();

                } catch(Exception e) {
                        System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el Ranking\n");
                }
        }

}
