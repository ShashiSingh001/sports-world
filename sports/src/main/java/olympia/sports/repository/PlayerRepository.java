package olympia.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import olympia.sports.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}