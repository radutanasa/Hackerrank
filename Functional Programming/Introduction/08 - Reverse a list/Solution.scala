object Solution extends App {

	def f(arr: List[Int]): List[Int] = arr match {
		case x :: xs => f(xs) ::: List(x)
		case Nil => Nil
	}

	println(f(List(1, 2, 3, 4)))
}
