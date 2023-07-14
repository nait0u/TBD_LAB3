package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Ranking;
import tbd.lab.voluntariado.Repositories.RankingRepository;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingService {
    private final RankingRepository rankingRepository;


    RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    @GetMapping
    public List<Ranking> getAll() {
        return rankingRepository.getAll();
    }


    @GetMapping("/count")
    public String countRanking(){
        int total = rankingRepository.countAllRanks();
        return String.format("Se tienen %s rankings.", total);
    }


    @PostMapping("/create")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking newRanking = rankingRepository.createRanking(ranking);
        return newRanking;
    }


    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteRanking(@PathVariable long id) {
        rankingRepository.deleteRankingById(id);
    }


    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateRanking(@RequestBody Ranking ranking) {
        rankingRepository.updateRanking(ranking);
    }


    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Ranking> getRankingById(@PathVariable long id) {
        return rankingRepository.showRankingById(id);
    }



}
