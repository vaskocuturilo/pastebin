package com.example.pastebin;

import com.example.pastebin.entity.DateStamp;
import com.example.pastebin.entity.Language;
import com.example.pastebin.entity.Paste;
import com.example.pastebin.repository.PastebinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(properties = {
        "spring.jpa.properties.javax.persistence.validation.mode=none"
})
class PastebinRepositoryTest {

    @Autowired
    PastebinRepository underTest;

    @Test
    void findByAuthor() {

        //Given
        UUID id = UUID.randomUUID();

        //When
        Paste paste = new Paste(id, "Test1", "Book title", Language.PLAIN_TEXT, "Text for you", DateStamp.ONE_DAY);
        underTest.save(paste);
        //Then
        Optional<Paste> optionalPaste = underTest.findByAuthor("Test1");
        assertThat(optionalPaste)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).isEqualToComparingFieldByField(paste);
                });
    }
}