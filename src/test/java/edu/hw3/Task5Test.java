package edu.hw3;

import edu.hw3.Task5.Contact;
import edu.hw3.Task5.ContactsMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] arguments() {

        return new Arguments[] {
            Arguments.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC",
                new Contact[] {new Contact("Thomas", "Aquinas"), new Contact("Rene", "Descartes"),
                    new Contact("David", "Hume"), new Contact("John", "Locke")}
            ),
            Arguments.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC",
                new Contact[] {new Contact("Carl", "Gauss"), new Contact("Leonhard", "Euler"),
                    new Contact("Paul", "Erdos")}
            ),
            Arguments.of(new String[] {"Aboba", "Leonardo DiCaprio", "Bob", "Robert Anthony De Niro"}, "DESC",
                new Contact[] {new Contact("Leonardo", "DiCaprio"), new Contact("Robert", "Anthony De Niro"), new Contact("Bob"), new Contact("Aboba")}
            ),
            Arguments.of(new String[0], "ASC", new Contact[0]),
            Arguments.of(null, "ASC", new Contact[0])
        };
    }

    @ParameterizedTest
    @MethodSource("arguments")
    @DisplayName("Список контактов")
    void parseContactsTest(String[] names, String order, Contact[] expected) {
        // given
        // input

        // when
        Contact[] contacts = ContactsMethods.parseContacts(names, order);

        // then
        assertThat(contacts).isEqualTo(expected);
    }
}
