# Test data for BFS
graph.add_edge('A', 'B', 100)
graph.add_edge('A', 'C', 200)
graph.add_edge('B', 'C', 150)
graph.add_edge('C', 'D', 100)

# Test data for Hash Table
hash_table = HashTable(10)
hash_table.insert('JFK', 'John F. Kennedy International Airport')
hash_table.insert('LAX', 'Los Angeles International Airport')

# Test data for Heap Sort
routes = [
    (['A', 'B', 'D'], 200),
    (['A', 'C', 'D'], 300),
    (['A', 'B', 'C', 'D'], 250)
]
