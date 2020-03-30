package medium

import (
	"math"
	"strings"
)

func myAtoi(str string) int {
	str = strings.TrimSpace(str)
	if len(str) <= 0 {
		return 0
	}
	index := float64(1)
	if string(str[0]) == "-" {
		index = -1
		str = str[1:]
	} else if string(str[0]) == "+" {
		index = 1
		str = str[1:]
	}
	res := float64(0)
	for i := 0; i < len(str); i++ {
		if str[i] >= 48 && str[i] <= 57 {
			res = res*10 + float64(str[i]) - 48
		} else {
			break
		}
	}
	res = index * res
	if res > math.MaxInt32 {
		res = math.MaxInt32
	}
	if res < math.MinInt32 {
		res = math.MinInt32
	}
	return int(res)
}
