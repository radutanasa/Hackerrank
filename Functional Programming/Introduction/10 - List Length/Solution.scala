object Solution extends App {

	def f(arr: List[Int]): Int = arr.foldLeft(0)((sum, elem) => sum + 1)

	println(f(List(1, 2, 3, 4, -5, -1, 10)))
}
