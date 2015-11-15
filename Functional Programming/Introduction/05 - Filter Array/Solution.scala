object Solution extends App {

	def f(delim: Int, arr: List[Int]): List[Int] = arr match {
		case x :: xs => if (x < delim) x :: f(delim, xs) else f(delim, xs)
		case Nil => Nil
	}

	println(f(5, List(8, 1, 2, 3, 4)))
}
