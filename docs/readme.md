# typesize
A typeclass that provides the number of inhabitants of common types.

### Add the dependency:
 - libarary for Scala @SCALA@ (JS, JVM, and Native platforms)
 
```scala
"com.julianpeeters" %% "typesize" % "@VERSION@"
```

### Description:
Calling `SizeOf[A].size` returns ~an `Int`~ a `Cardinality` of three flavors:
 - `Finite`: backed by a `BigInt`
 - `NonFinite`: for types like `List[A]`
 - `TooBigToCompute`: for types like `String`

Built-in typeclass instance are provided for common primitive and complex
types, calculated by the following operations:
  - `+`: take the sum of the members of a sealed trait
  - `*`: take the product of the members of a tuple
  - `pow`: take the exponentiation of the members of a function

### Example:

```scala mdoc
import typesize.{Cardinality, SizeOf, given}

val c: Cardinality = summon[SizeOf[Option[Boolean]]].size
```

### Supported types:

<details><summary>click to expand</summary>

##### Primitive:
 - `Boolean`
 - `Byte`
 - `Char` (assumption: decoded from utf8, e.g. `fs2.text`)
 - `Int`
 - `Long`
 - `Nothing`
 - `String`
 - `Unit`

##### Complex:
 - `Array`
 - `Either`
 - `Function` (1-9)
 - `List`
 - `Option`
 - `Tuple` (2-9)

</details>