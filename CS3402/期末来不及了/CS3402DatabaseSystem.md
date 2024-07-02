# CS3402 Database System

content

**Lec2: ER, relational data model**










**Lec3: Integrity Constraints**
- **Domain** constraints
- **Key** constraints
- **Entity integrity** constraints
- **Referential integrity** constraints
- Functional Dependency



**Lec4: Normal Forms**

- First Normal form

	- Disallow multi-values attributes, composite attributes
	- domain of an attribute must be atomic (simple and indivisible)
- Second Normal form

	- Non-prime attributes are associated only with the part of the primary key on which they are fully functional dependent.

- Third normal form

	- No non-prime attribute is transtively dependent on the primary key

- BCNF




**Lec5,6: SQL**

**Lec7: Relational Algebra**

**Lec8: Files and Hashed Files**
- Basic concepts:

	- Memory Hierarchy
	- Disk Storage Device
- Records:

	- Blocking, Blocking factor(bfr)

- Operations on files
- Unordered files

	- Inserted at the end of file
	- Searching needs linear search, O(n)

- Ordered files

	- Insertion O(n)
	- Searching, binary search used, O(logn)
- Hashed files

	- Extendible and Dynamic hashing

**Lec9: Indexing Techniques**
- Single Level index:
	- Primary index (ordered key field): 
		- Sparse: one index points to multiple records
		- one index entry for each block in the data file
		- binary search to find the index required
	- Cluster index (ordered non-key field): Sparse
		 - Sparse
		

- Secondary index (non-ordered field)
	- A secondary way to access the data file for which **some primary access** already exists
	- Normally dense index, every record has a pointer

- Dense index and Sparse index

- B-tree and B+-tree
	- B-tree: pointers to data records exist at all levels of the tree
	- B+-tree: pointers to records exists at leaf-level
		- Insertion
		- Deletion


**Lec10: Transaction Management**:
- Transaction
- Read and Write operations
- Interleaving and Parallel
- Consistency

	- Serializable
	- Conflict equivalent
	- Serialization Graphs

- Database Recovery

	- Recoverable: The read transaction commits before the write transaction
	- Cascadeless: Reads only the items that written by committed transactions
	- Strict: Reads and writes only the items that written by committed transactions

**Lec11: Concurrency Control**
- Locking techniques
- Basic Two-Phase Locking (B2PL)

	- Growing phase and Shrinking phase
	- Enforce serializability but may produce deadlock

- Conservative Two-phase Locking (C2PL)
	- Deadlock free
	- obtain all the locks, release all the locks

- Strict Two-phase Locking (S2PL)
	- performance + Security
	- Lock obtains gradually, lock release at the same time

- Deadlock Prevention:
	- wait-die
	- would-wait

