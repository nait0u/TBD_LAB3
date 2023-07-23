package tbd.lab.voluntariado.Repositories;

import org.springframework.data.mongodb.core.MongoTemplate;
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
        private MongoTemplate mongoTemplate;

        @Override
        public Ranking createRanking(Ranking ranking) {
                return null;
        }

        @Override
        public int countAllRanks() {
                return 0;
        }

        @Override
        public int newID() {
                return 0;
        }

        @Override
        public List<Ranking> getAll() {
                return null;
        }

        @Override
        public List<Ranking> showRankingById(long id) {
                return null;
        }

        @Override
        public void deleteRankingById(long id) {

        }

        @Override
        public void updateRanking(Ranking ranking) {

        }
}
