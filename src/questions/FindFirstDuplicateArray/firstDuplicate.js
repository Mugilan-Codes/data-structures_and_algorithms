// Time Complexity: O(n) time or Linear Time
// Space Complexity: O(n) time or Linear Space
function firstDuplicate(a) {
  // intialize a empty object
  let dict = {};

  // loop through the array
  // check whether the value is already in the object. if not add to it
  for (let i = 0; i < a.length; i++) {
    // check for presence of the element in object
    if (dict[a[i]]) {
      return a[i];
    }

    // add the item and set its value to true
    dict[a[i]] = true;
  }

  // value not found
  return -1;
}

let a = [2, 1, 3, 5, 3, 2];
console.log(firstDuplicate(a));

a = [2, 2];
console.log(firstDuplicate(a));

a = [2, 4, 3, 5, 1];
console.log(firstDuplicate(a));
