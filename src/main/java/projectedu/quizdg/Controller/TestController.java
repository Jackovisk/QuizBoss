package projectedu.quizdg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projectedu.quizdg.entity.Boss;
import projectedu.quizdg.entity.Item;
import projectedu.quizdg.entity.Player;
import projectedu.quizdg.repository.BossRepository;
import projectedu.quizdg.repository.ItemRepository;
import projectedu.quizdg.repository.PlayerRepository;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private BossRepository bossRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/ping")
    public String ping() {
        return "Quiz Boss API está online e pronta para a batalha!";
    }

    @GetMapping("/test-db")
    public Boss testDatabase() {
        Boss boss = new Boss();
        boss.setName("Dragão do Conhecimento");
        boss.setMaxHealth(1000);
        boss.setDifficultyLevel(3);
        boss.setImageUrl("https://link.da.imagem/dragao.png");
        return bossRepository.save(boss);
    }

    // Rota para testar a criação do Jogador
    @GetMapping("/test-player")
    public Player testPlayer() {
        Player player = new Player();
        player.setUsername("MagoQuiz");
        player.setEmail("mago@quizboss.com");
        player.setPassword("senhaSegura123");

        // Atributos iniciais de RPG Nível 1
        player.setLevel(1);
        player.setExperience(0);
        player.setMaxHealth(100);
        player.setCurrentHealth(100);
        player.setCoins(50);

        return playerRepository.save(player);
    } // <-- O ERRO ESTAVA AQUI: Esta chave estava faltando!

    // Rota para testar a criação dos Itens
    @GetMapping("/test-items")
    public List<Item> testItems() {
        // Criando a Poção de Cura
        Item potion = new Item();
        potion.setName("Poção de Vida Menor");
        potion.setDescription("Recupera 30 pontos de vida do jogador.");
        potion.setPrice(15);
        potion.setEffectType("HEAL");
        potion.setEffectValue(30);

        // Criando o Escudo
        Item shield = new Item();
        shield.setName("Escudo de Energia");
        shield.setDescription("Bloqueia 20 pontos de dano do próximo ataque do Boss.");
        shield.setPrice(25);
        shield.setEffectType("SHIELD");
        shield.setEffectValue(20);

        // Salvando os dois no banco de dados de uma vez só
        return itemRepository.saveAll(List.of(potion, shield));
    }
}