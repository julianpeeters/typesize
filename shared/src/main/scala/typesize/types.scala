package typesize

export types.complex.array.given
export types.complex.either.given
export types.complex.function.given
export types.complex.list.given
export types.complex.option.given
export types.complex.tuple.given
export types.primitive.boolean.given
export types.primitive.byte.given
export types.primitive.char.given
export types.primitive.int.given
export types.primitive.long.given
export types.primitive.nothing.given
export types.primitive.string.given
export types.primitive.unit.given

object types:
  
  object primitive:

    object boolean:
      given SizeOf[Boolean] =
        new SizeOf[Boolean]:
          def size: Cardinality = Finite(2)

    object byte:
      given SizeOf[Byte] =
        new SizeOf[Byte]:
          def size: Cardinality = Finite(256)

    object char:
      given SizeOf[Char] =
        new SizeOf[Char]:
          def size: Cardinality = Finite(256) // assume utf8

    object int:
      given SizeOf[Int] =
        new SizeOf[Int]:
          def size: Cardinality = Finite(BigInt("4294967296"))

    object long:
      given SizeOf[Long] =
        new SizeOf[Long]:
          def size: Cardinality = Finite(BigInt("18446744073709551616"))

    object nothing:
      given SizeOf[Nothing] =
        new SizeOf[Nothing]:
          def size: Cardinality = Finite(0)

    object string:
      given SizeOf[String] =
        new SizeOf[String]:
          def size: Cardinality = TooBigToCompute

    object unit:
      given SizeOf[Unit] =
        new SizeOf[Unit]:
          def size: Cardinality = Finite(1)

  object complex:

    object array:
      given [T] : SizeOf[Array[T]] =
        new SizeOf[Array[T]]:
          def size: Cardinality = NonFinite

    object either:
      given [L, R] (using L: SizeOf[L], R: SizeOf[R]): SizeOf[Either[L, R]] =
        new SizeOf[Either[L, R]]:
          def size: Cardinality = L.size + R.size
      given [L, R] (using L: SizeOf[L], R: SizeOf[R]): SizeOf[Left[L, R]] =
        new SizeOf[Left[L, R]]:
          def size: Cardinality = L.size
      given [L, R] (using L: SizeOf[L], R: SizeOf[R]): SizeOf[Right[L, R]] =
        new SizeOf[Right[L, R]]:
          def size: Cardinality = R.size

    object function:
      given [T, R] (using T: SizeOf[T], R: SizeOf[R]): SizeOf[Function1[T, R]] =
        new SizeOf[Function1[T, R]]:
          def size: Cardinality = R.size.pow(T.size)
      given [T1, T2, R] (using T1: SizeOf[T1], T2: SizeOf[T2], R: SizeOf[R]): SizeOf[Function2[T1, T2, R]] =
        new SizeOf[Function2[T1, T2, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size)
      given [T1, T2, T3, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3],  R: SizeOf[R]): SizeOf[Function3[T1, T2, T3, R]] =
        new SizeOf[Function3[T1, T2, T3, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size)
      given [T1, T2, T3, T4, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4],  R: SizeOf[R]): SizeOf[Function4[T1, T2, T3, T4, R]] =
        new SizeOf[Function4[T1, T2, T3, T4, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size)
      given [T1, T2, T3, T4, T5, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4], T5: SizeOf[T5], R: SizeOf[R]): SizeOf[Function5[T1, T2, T3, T4, T5, R]] =
        new SizeOf[Function5[T1, T2, T3, T4, T5, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size * T5.size)
      given [T1, T2, T3, T4, T5, T6, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4], T5: SizeOf[T5], T6: SizeOf[T6], R: SizeOf[R]): SizeOf[Function6[T1, T2, T3, T4, T5, T6, R]] =
        new SizeOf[Function6[T1, T2, T3, T4, T5, T6, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size * T5.size * T6.size)
      given [T1, T2, T3, T4, T5, T6, T7, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4], T5: SizeOf[T5], T6: SizeOf[T6], T7: SizeOf[T7], R: SizeOf[R]): SizeOf[Function7[T1, T2, T3, T4, T5, T6, T7, R]] =
        new SizeOf[Function7[T1, T2, T3, T4, T5, T6, T7, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size * T5.size * T6.size * T7.size)
      given [T1, T2, T3, T4, T5, T6, T7, T8, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4], T5: SizeOf[T5], T6: SizeOf[T6], T7: SizeOf[T7], T8: SizeOf[T8], R: SizeOf[R]): SizeOf[Function8[T1, T2, T3, T4, T5, T6, T7, T8, R]] =
        new SizeOf[Function8[T1, T2, T3, T4, T5, T6, T7, T8, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size * T5.size * T6.size * T7.size * T8.size)
      given [T1, T2, T3, T4, T5, T6, T7, T8, T9, R] (using T1: SizeOf[T1], T2: SizeOf[T2], T3: SizeOf[T3], T4: SizeOf[T4], T5: SizeOf[T5], T6: SizeOf[T6], T7: SizeOf[T7], T8: SizeOf[T8], T9: SizeOf[T9], R: SizeOf[R]): SizeOf[Function9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]] =
        new SizeOf[Function9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]]:
          def size: Cardinality = R.size.pow(T1.size * T2.size * T3.size * T4.size * T5.size * T6.size * T7.size * T8.size * T9.size)

    object list:
      given [T] (using C: SizeOf[::[T]], N: SizeOf[Nil.type]): SizeOf[List[T]] =
        new SizeOf[List[T]]:
          def size: Cardinality = C.size  + N.size 
      given [T] (using T: SizeOf[T]): SizeOf[::[T]] =
        new SizeOf[::[T]]:
          def size: Cardinality = NonFinite
      given SizeOf[Nil.type] =
        new SizeOf[Nil.type]:
          def size: Cardinality = Finite(1)

    object option:
      given [T] (using S: SizeOf[Some[T]], N: SizeOf[None.type]): SizeOf[Option[T]] =
        new SizeOf[Option[T]]:
          def size: Cardinality = S.size + N.size
      given [T] (using T: SizeOf[T]): SizeOf[Some[T]] =
        new SizeOf[Some[T]]:
          def size: Cardinality = T.size
      given SizeOf[None.type] =
        new SizeOf[None.type]:
          def size: Cardinality = Finite(1)

    object tuple:
      given [_1, _2] (using _1: SizeOf[_1], _2: SizeOf[_2]): SizeOf[Tuple2[_1, _2]] =
        new SizeOf[Tuple2[_1, _2]]:
          def size: Cardinality = _1.size * _2.size
      given [_1, _2, _3] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3]): SizeOf[Tuple3[_1, _2, _3]] =
        new SizeOf[Tuple3[_1, _2, _3]]:
          def size: Cardinality = _1.size * _2.size * _3.size
      given [_1, _2, _3, _4] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4]): SizeOf[Tuple4[_1, _2, _3, _4]] =
        new SizeOf[Tuple4[_1, _2, _3, _4]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size
      given [_1, _2, _3, _4, _5] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4], _5: SizeOf[_5]): SizeOf[Tuple5[_1, _2, _3, _4, _5]] =
        new SizeOf[Tuple5[_1, _2, _3, _4, _5]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size * _5.size
      given [_1, _2, _3, _4, _5, _6] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4], _5: SizeOf[_5], _6: SizeOf[_6]): SizeOf[Tuple6[_1, _2, _3, _4, _5, _6]] =
        new SizeOf[Tuple6[_1, _2, _3, _4, _5, _6]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size * _5.size * _6.size
      given [_1, _2, _3, _4, _5, _6, _7] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4], _5: SizeOf[_5], _6: SizeOf[_6], _7: SizeOf[_7]): SizeOf[Tuple7[_1, _2, _3, _4, _5, _6, _7]] =
        new SizeOf[Tuple7[_1, _2, _3, _4, _5, _6, _7]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size * _5.size * _6.size * _7.size
      given [_1, _2, _3, _4, _5, _6, _7, _8] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4], _5: SizeOf[_5], _6: SizeOf[_6], _7: SizeOf[_7], _8: SizeOf[_8]): SizeOf[Tuple8[_1, _2, _3, _4, _5, _6, _7, _8]] =
        new SizeOf[Tuple8[_1, _2, _3, _4, _5, _6, _7, _8]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size * _5.size * _6.size * _7.size * _8.size
      given [_1, _2, _3, _4, _5, _6, _7, _8, _9] (using _1: SizeOf[_1], _2: SizeOf[_2], _3: SizeOf[_3], _4: SizeOf[_4], _5: SizeOf[_5], _6: SizeOf[_6], _7: SizeOf[_7], _8: SizeOf[_8], _9: SizeOf[_9]): SizeOf[Tuple9[_1, _2, _3, _4, _5, _6, _7, _8, _9]] =
        new SizeOf[Tuple9[_1, _2, _3, _4, _5, _6, _7, _8, _9]]:
          def size: Cardinality = _1.size * _2.size * _3.size * _4.size * _5.size * _6.size * _7.size * _8.size * _9.size
