object Solution extends App {

	def f(arr: List[Int]):Int = arr.foldLeft(0)((sum, elem) => if (Math.abs(elem % 2) == 1) sum + elem else sum)

	println(f(List(1, 2, 3, 4, -5, -1, 10)))
}
