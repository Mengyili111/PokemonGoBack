package comp354.team9.model;

import comp354.team9.model.audit.DateAudit;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Proxy(lazy = false)
@Table(name = "user_decks")
public class UserDeck extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Size(max = 40)
    private String deckName;

    @NotBlank
    @Size(max = 200)
    private String content;

    public UserDeck() {

    }

    public UserDeck(User user, String deckName, String content) {
        this.user = user;
        this.deckName = deckName;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deck_name) {
        this.deckName = deck_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
