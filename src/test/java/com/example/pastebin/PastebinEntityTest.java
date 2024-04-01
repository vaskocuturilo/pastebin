package com.example.pastebin;

import com.example.pastebin.entity.DateStamp;
import com.example.pastebin.entity.Language;
import com.example.pastebin.entity.Pastebin;
import com.example.pastebin.repository.PastebinRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.UUID;

@DisplayName("Test Item JPA Entity")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PastebinEntityTest {

    @Autowired
    PastebinRepository underTest;

    @Autowired
    private TestEntityManager em;

    @Test
    @Transactional
    void testEntityCreation() {
        UUID uuid = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(uuid, "Anton Smirnov1", "Smirnov title1", Language.PLAIN_TEXT, "Text for book", DateStamp.ONE_DAY);

        underTest.save(pastebin);
        em.flush();
    }
}
