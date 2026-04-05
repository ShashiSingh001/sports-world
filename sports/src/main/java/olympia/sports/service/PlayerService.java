package olympia.sports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import olympia.sports.entity.Player;
import olympia.sports.repository.PlayerRepository;
import olympia.sports.exception.ResourceNotFoundException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    // ✅ CREATE
    public Player savePlayer(Player player) {
        return repo.save(player);
    }

    // ✅ READ ALL
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    // ✅ READ BY ID
    public Player getPlayerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player not found with id: " + id));
    }

    // ✅ UPDATE
    public Player updatePlayer(Long id, Player updatedPlayer) {

        Player existing = getPlayerById(id);

        existing.setName(updatedPlayer.getName());
        existing.setSport(updatedPlayer.getSport());
        existing.setAge(updatedPlayer.getAge());

        return repo.save(existing);
    }

    // ✅ DELETE
    public String deletePlayer(Long id) {

        Player existing = getPlayerById(id);

        repo.delete(existing);
        return "Player deleted successfully";
    }
}