object Solution extends App {

	def f(arr: List[Int]): List[Int] = {
		def removeOddPositions(ls: List[Int], idx: Int): List[Int] = ls match {
			case x :: xs => if (idx % 2 == 0) removeOddPositions(xs, idx + 1) else x :: removeOddPositions(xs, idx + 1)
			case Nil => Nil
		}
		removeOddPositions(arr, 0)
	}

	println(f(List(1, 2, 3, 4, 5, 6, 7, 8)))
}
