package olympia.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import olympia.sports.entity.Player;
import olympia.sports.service.PlayerService;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService service;

    // CREATE
    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return service.savePlayer(player);
    }

    // READ ALL
    @GetMapping
    public List<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return service.getPlayerById(id);
    }

    // ✅ UPDATE (FULL WORKING)
    @PutMapping("/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player) {

        return service.updatePlayer(id, player);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        return service.deletePlayer(id);
    }
}