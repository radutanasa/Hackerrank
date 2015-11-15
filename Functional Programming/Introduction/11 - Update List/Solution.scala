object Solution extends App {

	def f(arr: List[Int]): List[Int] = arr.map(Math.abs(_))

	println(f(List(1, 2, 3, 4, -5, -1, 10)))
}
