// breadth first - iterative approach
const hasPathBF = (graph, source, dest) => {
  const queue = [source];

  while (queue.length > 0) {
    const current = queue.shift();

    if (current === dest) return true;

    for (let neighbor of graph[source]) {
      queue.push(neighbor);
    }
  }

  return false;
};

// depth first
const hasPath = (graph, source, dest) => {
  if (source === dest) return true;

  for (let neighbor of graph[source]) {
    if (hasPath(graph, neighbor, dest)) {
      return true;
    }
  }

  return false;
};

// directed acyclic graph
const graph = {
  f: ['g', 'i'],
  g: ['h'],
  h: [],
  i: ['g', 'k'],
  j: ['i'],
  k: [],
};

console.log(hasPath(graph, 'f', 'k'));
console.log(hasPathBF(graph, 'f', 'k'));
