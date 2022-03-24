package de.iteratec.kotlin.playground.solutions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StringEmitter {
    public @Nullable  String giveMeAString() {
        return null;
    }

    // Using @NotNull results in Kotlin getting the type String from the Java call instead of a platform type.
/*    public @NotNull
    String giveMeAString() { return ""; }*/
}
