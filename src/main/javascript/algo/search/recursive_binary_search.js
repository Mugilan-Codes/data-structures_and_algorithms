function recursiveBinarySearch(
  array,
  target,
  start = 0,
  end = array.length - 1
) {
  if (start <= end) {
    const mid = Math.floor((start + end) / 2);

    if (array[mid] === target) {
      return mid;
    }

    if (array[mid] > target) {
      // left side of midpoint
      return recursiveBinarySearch(array, target, start, mid - 1);
    } else {
      // right side of midpoint
      return recursiveBinarySearch(array, target, mid + 1, end);
    }
  } else {
    return -1;
  }
}

function verify(index) {
  if (index === -1) {
    console.log('Target not found in array');
  } else {
    console.log(`Target found at index: ${index}`);
  }
}

let result;
const numberArr = [1, 2, 3, 4, 5, 6, 7];

result = recursiveBinarySearch(numberArr, 8);
verify(result);

result = recursiveBinarySearch(numberArr, 5);
verify(result);
