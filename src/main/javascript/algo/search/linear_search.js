function linearSearch(array, key) {
  // loops through the entire array and finds the first instance of the key
  for (let i = 0; i < array.length; i++) {
    if (array[i] === key) {
      return i;
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

result = linearSearch(numberArr, 8);
verify(result);

result = linearSearch(numberArr, 5);
verify(result);
