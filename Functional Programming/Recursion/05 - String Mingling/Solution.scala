object Solution extends App {

	def merge(p: String, q: String): String = {

		def combine(s1: List[Char], s2: List[Char]): List[(Char, Char)] = (s1, s2) match {
			case (x::xs, y::ys) => (x, y) :: combine(xs, ys)
			case (x::xs, Nil) => throw new IllegalArgumentException
			case (Nil, y::ys) => throw new IllegalArgumentException
			case (Nil, Nil) => List()
		}

		combine(p.toList, q.toList).map {
			case (x, y) => x.toString + y.toString
		}.mkString("")
	}

	val p = scala.io.StdIn.readLine()
	val q = scala.io.StdIn.readLine()

	println(merge(p, q))

}
