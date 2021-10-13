const depthFirstPrintRecursion = (graph, srcNode) => {
  console.log(srcNode);

  for (let neighbor of graph[srcNode]) {
    depthFirstPrintRecursion(graph, neighbor);
  }
};
const depthFirstPrint = (graph, srcNode) => {
  const stack = [srcNode];

  while (stack.length > 0) {
    const current = stack.pop();
    console.log(current);

    for (let neighbor of graph[current]) {
      stack.push(neighbor);
    }
  }
};

const breadthFirstPrint = (graph, srcNode) => {
  const queue = [srcNode];

  while (queue.length > 0) {
    const current = queue.shift();
    console.log(current);

    for (let neighbor of graph[current]) {
      queue.push(neighbor);
    }
  }
};

const graph = {
  a: ['b', 'c'],
  b: ['d'],
  c: ['e'],
  d: ['f'],
  e: [],
  f: [],
};

depthFirstPrintRecursion(graph, 'a'); // abdfce;
depthFirstPrint(graph, 'a'); // acebdf

breadthFirstPrint(graph, 'a'); // abcdef
