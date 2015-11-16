object Solution extends App {

	// This function will be used while invoking "Summation" to compute
	// The area under the curve.
	def f(coefficients: List[Int], powers: List[Int], x: Double): Double = (coefficients, powers) match {
		case (Nil, Nil) => 0d
		case (c::cs, p::ps) => c * Math.pow(x, p) + f(cs, ps, x)
	}


	// This function will be used while invoking "Summation" to compute
	// The Volume of revolution of the curve around the X-Axis
	// The 'Area' referred to here is the area of the circle obtained
	// By rotating the point on the curve (x,f(x)) around the X-Axis
	def area(coefficients: List[Int], powers: List[Int], x:Double): Double = {
		Math.PI * Math.pow(f(coefficients, powers, x), 2)
	}

	// This is the part where the series is summed up
	// This function is invoked once with func = f to compute the area         // under the curve
	// Then it is invoked again with func = area to compute the volume
	// of revolution of the curve
	def summation(func: (List[Int], List[Int], Double) => Double,
				  upperLimit: Int,
				  lowerLimit: Int,
				  coefficients: List[Int],
				  powers: List[Int]): Double = {

		var sum = 0d
		for(i <- lowerLimit.toDouble to upperLimit.toDouble by 0.001) {
			sum = sum + (func(coefficients, powers, i) * 0.001)
		}
		sum
	}

	// 1*x^0 + 2*x^1
	println(summation(area, 20, 2, List(1, 2), List(0, 1)))
}
