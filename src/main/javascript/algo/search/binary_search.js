// the array passed in must be sorted from ascending to descending
function binarySearch(array, target) {
  // track leftmost and rightmost of the array
  let left = 0;
  let right = array.length - 1;

  // run the loop as long as the leftmost element is not bigger than rightmost element
  while (left <= right) {
    // find the mid point in the array
    // console.log(Math.floor((left + right) / 2));
    const mid = left + Math.floor((right - left) / 2);

    // return index if the mid is the target
    if (array[mid] === target) {
      return mid;
    }

    // choose which side of array should be evaluated next
    if (array[mid] < target) {
      // right side of mid
      left = mid + 1;
    } else {
      // left side of mid
      right = mid - 1;
    }
  }

  // target not found
  return -1;
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

result = binarySearch(numberArr, 8);
verify(result);

result = binarySearch(numberArr, 5);
verify(result);
