object Solution extends App {

	def f(n:Int, xs:List[Int]): List[Int] = xs.flatMap(x => repeatElement(n, x))

	def repeatElement(n:Int, elem:Int): List[Int] =
		if (n == 0) List()
		else elem :: repeatElement(n - 1, elem)

	println(f(2, List(1, 2, 3)))
}
