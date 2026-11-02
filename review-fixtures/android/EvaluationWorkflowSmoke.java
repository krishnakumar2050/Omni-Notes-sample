package it.feio.android.omninotes.reviewfixture;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Standalone workflow verification fixture, outside Android build source sets. */
public final class EvaluationWorkflowSmoke {
    private EvaluationWorkflowSmoke() {}

    /** Returns the floor of mean UTF-16 code units per note, or zero for an empty list.
     * Null collections and null elements are rejected with NullPointerException.
     */
    public static int averageLength(List<String> notes) {
        Objects.requireNonNull(notes, "notes");
        if (notes.isEmpty()) {
            return 0;
        }
        long total = 0;
        for (String note : notes) {
            total += Objects.requireNonNull(note, "note").length();
        }
        return (int) (total / notes.size());
    }

    public static void main(String[] args) {
        if (averageLength(Collections.<String>emptyList()) != 0) {
            throw new AssertionError("Empty lists must return zero");
        }
        if (averageLength(Collections.singletonList("note")) != 4) {
            throw new AssertionError("Single-note average must match its length");
        }
    }
}
