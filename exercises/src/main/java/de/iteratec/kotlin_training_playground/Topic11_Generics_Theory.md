# Generics

In general, Kotlin generics work similar to Java generics. The main advantage lies in the fact that Kotlin handles variance a bit different.

## Variance

Normally generics are invariant:

If <b> Child </b> is a subclass of <b> Parent </b>,  
neither <b> MyGenericClasss&lt;Child&gt; </b> is a subclass of <b> MyGenericClass&lt;Parent&gt; </b> (this would be covariance)  
nor is <b> MyGenericClasss&lt;Parent&gt; </b> is a subclass of <b> MyGenericClass&lt;Child&gt; </b> (this would be contravariance). 

This is normally quite disappointing because there is no reason why for instance a <b> Comparator&lt;Object&gt; </b> could not be used as a <b> Comparator&lt;String&gt; </b> for example. If you can compare two objects, you can certainly compare strings.

Java solves this problem by introducing extra types, so-called bounded wildcards. <b> Comparator&lt;String&gt; </b> is a subtype of <b> Comparator&lt;? extends Object&gt;</b>. The latter one can therefore be used as String comparator or object comparator.

Kotlin basically allows you to mark generic variables as covariant (<b> &lt;out T&gt; </b>) or contravariant (<b> &lt;in T&gt; </b>) simplifying the usage of generic classes.

Generic classes in <b> T </b> whose methods and setters only return types involving <b> T </b> but never take something of type <b> T </b> as input (read-only in <b> T </b>) can be declared covariant.

Generic classes in <b> T </b> whose methods and getters only take types involving <b> T </b> as input but never return something of type <b> T </b> (write-only in <b> T </b>) can be declared contravariant.





