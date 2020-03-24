package easy

func twoSum(nums []int, target int) []int {
	indexMap := make(map[int]int)
	for index, num := range nums {
		indexMap[num] = index
	}
	for i := 0; i < len(nums); i++ {
		if value, ok := indexMap[target-nums[i]]; ok {
			if i == value {
				continue
			}
			return []int{i, value}
		}
	}
	return nil
}
