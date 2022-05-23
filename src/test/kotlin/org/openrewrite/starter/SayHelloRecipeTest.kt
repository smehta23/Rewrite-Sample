package org.openrewrite.starter

import org.junit.jupiter.api.Test
import org.openrewrite.Recipe
import org.openrewrite.java.JavaRecipeTest

class SayHelloRecipeTest: JavaRecipeTest {
    override val recipe: Recipe
        get() = SayHelloRecipe("com.yourorg.A")

    @Test
    fun addsHelloToA() = assertChanged(
            before = """
            package com.yourorg;

            class A {
            }
        """,
            after = """
            package com.yourorg;

            class A {
                public String hello() {
                    return "Hello from com.yourorg.A!";
                }
            }
        """
    )

    @Test
    fun doesNotChangeExistingHello() = assertUnchanged(
            before = """
            package com.yourorg;

            class A {
                public String hello() { return ""; }
            }
        """
    )

    @Test
    fun doesNotChangeOtherClass() = assertUnchanged(
            before = """
            package com.yourorg;

            class B {
            }
        """
    )
}