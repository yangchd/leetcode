package easy

import "math"

func reverse(x int) int {
	negative := false
	if x < 0 {
		negative = true
		x = 0 - x
	}
	res := 0
	for x > 0 {
		i := x % 10
		x = x / 10
		res = res*10 + i
	}
	if math.MinInt32 < res && res < math.MaxInt32 {
		if negative {
			res = 0 - res
		}
	} else {
		res = 0
	}
	return res
}
