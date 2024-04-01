package com.example.pastebin;

import com.example.pastebin.entity.DateStamp;
import com.example.pastebin.entity.Language;
import com.example.pastebin.entity.Pastebin;
import com.example.pastebin.repository.PastebinRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@DataJpaTest(properties = {
        "spring.jpa.properties.javax.persistence.validation.mode=none"
})
class PastebinRepositoryTest {
    @Autowired
    PastebinRepository underTest;

    @Test
    void itShouldSelectPastebinById() {
        UUID id = UUID.randomUUID();

        Pastebin pastebin = new Pastebin(id, "Anton Smirnov1", "Smirnov title1", Language.PLAIN_TEXT, "Text for book", DateStamp.ONE_DAY);

        underTest.save(pastebin);

        Optional<Pastebin> optionalPaste = underTest.findById(id);

        assertThat(optionalPaste).isPresent().hasValueSatisfying(c -> assertThat(c)
                .usingRecursiveComparison()
                .isEqualTo(pastebin));
    }

    @Test
    void itShouldSelectPastebinByAuthor() {
        UUID id = UUID.randomUUID();

        Pastebin pastebin = new Pastebin(id, "Anton Smirnov", "Smirnov title", Language.PLAIN_TEXT, "Text for book", DateStamp.ONE_DAY);
        underTest.save(pastebin);

        Optional<Pastebin> optionalPaste = underTest.findByAuthor("Anton Smirnov");

        assertThat(optionalPaste).isPresent().hasValueSatisfying(c -> assertThat(c).usingRecursiveComparison().isEqualTo(pastebin));
    }

    @Test
    void itShouldSelectPastebinByText() {
        UUID id = UUID.randomUUID();

        Pastebin pastebin = new Pastebin(id,
                "Thomas Andersen",
                "This is a bok about testing",
                Language.PLAIN_TEXT,
                "Text for testing",
                DateStamp.ONE_DAY);

        underTest.save(pastebin);

        Optional<Pastebin> optionalPaste = underTest.findByText("testing");

        assertThat(optionalPaste).isPresent().hasValueSatisfying(c -> assertThat(c).usingRecursiveComparison().isEqualTo(pastebin));
    }

    @Test
    void itShouldSelectPastebinByTitle() {
        UUID id = UUID.randomUUID();

        Pastebin pastebin = new Pastebin(id, "Andy Gard", "Book title", Language.PLAIN_TEXT, "Text for you", DateStamp.ONE_DAY);

        underTest.save(pastebin);

        Optional<Pastebin> optionalPaste = underTest.findByTitle("Book title");

        assertThat(optionalPaste).isPresent().hasValueSatisfying(c -> assertThat(c).usingRecursiveComparison().isEqualTo(pastebin));
    }

    @Test
    void itNotShouldSelectPastebinByAuthorWhenAuthorDoesNotExist() {
        UUID emptyId = UUID.fromString("c1a7000c-5795-496b-b6ae-c58fc9170ade");
        Optional<Pastebin> optionalPaste = underTest.findById(emptyId);

        assertThat(optionalPaste).isNotPresent();
    }

    @Test
    void itShouldNotSavePastebinWhenAuthorIsNull() {
        UUID id = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(id, null,
                "Book title",
                Language.PLAIN_TEXT,
                "Text for you",
                DateStamp.ONE_DAY);

        assertThatThrownBy(() -> underTest.save(pastebin))
                .hasMessage("not-null property references a null or transient value : com.example.pastebin.entity.Pastebin.author")
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void itShouldNotSavePastebinWhenTitleIsNull() {
        UUID id = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(id, "Alex",
                null,
                Language.PLAIN_TEXT,
                "Text for you",
                DateStamp.ONE_DAY);

        assertThatThrownBy(() -> underTest.save(pastebin))
                .hasMessage("not-null property references a null or transient value : com.example.pastebin.entity.Pastebin.title")
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void itShouldNotSavePastebinWhenLanguageIsNull() {
        UUID id = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(id, "Alex",
                "Book",
                null,
                "Text for you",
                DateStamp.ONE_DAY);

        assertThatThrownBy(() -> underTest.save(pastebin))
                .hasMessage("not-null property references a null or transient value : com.example.pastebin.entity.Pastebin.language")
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void itShouldNotSavePastebinWhenTextIsNull() {
        UUID id = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(id, "Alex",
                "Book title",
                Language.PLAIN_TEXT,
                null,
                DateStamp.ONE_DAY);

        assertThatThrownBy(() -> underTest.save(pastebin))
                .hasMessage("not-null property references a null or transient value : com.example.pastebin.entity.Pastebin.text")
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void itShouldNotSavePastebinWhenStampIsNull() {
        UUID id = UUID.randomUUID();
        Pastebin pastebin = new Pastebin(id, "Alex",
                "Book title",
                Language.PLAIN_TEXT,
                "This is a text",
                null);

        assertThatThrownBy(() -> underTest.save(pastebin))
                .hasMessage("not-null property references a null or transient value : com.example.pastebin.entity.Pastebin.stamp")
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}