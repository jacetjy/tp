package seedu.address.model.flashcard;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Flashcard in Bagel list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Flashcard {

    // Identity fields
    private final Title title;
//    private final Name name;
//    private final Phone phone;
//    private final Email email;

    // Data fields
    private final Description description;
//    private final Address address;
//    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Flashcard(Title title, Description description) {
        requireAllNonNull(title, description);
        this.title = title;
        this.description = description;
    }

    public Title getTitle() {
        return this.title;
    }

    public Description getDescription() {
        return this.description;
    }

//    /**
//     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
//     * if modification is attempted.
//     */
//    public Set<Tag> getTags() {
//        return Collections.unmodifiableSet(tags);
//    }

    /**
     * Returns true if both flashcards of the same title have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two flashcards.
     */
    public boolean isSameFlashcard(Flashcard otherFlashcard) {
        if (otherFlashcard == this) {
            return true;
        }

        return otherFlashcard != null
                && otherFlashcard.getTitle().equals(getTitle())
                // temporarily uses Description to check for same flashcard.
                && (otherFlashcard.getDescription().equals(getDescription()));
    }

    // temporarily the same as isSameFlashcard
    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Flashcard)) {
            return false;
        }

        Flashcard otherFlashcard = (Flashcard) other;
        return otherFlashcard.getTitle().equals(getTitle())
                // temporarily uses Description to check for same flashcard.
                && otherFlashcard.getDescription().equals(getDescription());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Description: ")
                .append(getDescription());
        return builder.toString();
    }

}
