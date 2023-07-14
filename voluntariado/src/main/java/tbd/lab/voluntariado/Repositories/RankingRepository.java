package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Ranking;

import java.util.List;

public interface RankingRepository {
    public Ranking createRanking(Ranking ranking);
    public int countAllRanks();
    public int newID();
    public List<Ranking> getAll();
    public List<Ranking> showRankingById(long id);
    public void deleteRankingById(long id);
    public void updateRanking(Ranking ranking);


}
