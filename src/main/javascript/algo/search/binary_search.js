function binarySearch(array, key) {
  let left = 0;
  let right = array.length - 1;

  while (left <= right) {
    const mid = left + Math.floor((right - left) / 2);

    if (array[mid] === key) {
      return mid;
    }

    if (array[mid] < key) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return -1;
}

function verify(index) {
  if (index === -1) {
    console.log('key not found in array');
  } else {
    console.log(`Key found at index: ${index}`);
  }
}

let result;
const numberArr = [1, 2, 3, 4, 5, 6];

result = binarySearch(numberArr, 8);
verify(result);

result = binarySearch(numberArr, 5);
verify(result);
