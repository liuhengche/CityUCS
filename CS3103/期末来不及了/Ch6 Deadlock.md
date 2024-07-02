# Ch6 Deadlock

DeadLock: 
- A set of blocked process each holding a resource and waiting to acquire a resource held by another process (**resource allocation graph**)
Necessary Conditions of Deadlock:
- **Mutual Exclusion**
- **Hold and wait**
- **No resource preemption**
- **Circular wait**

## Resource Allocation Graph
- Request Edge: **Pi -> Rj** 
- Assignment Edge: **Rj -> Pi**
### **Circular wait does not necessarily lead to deadlock!**
- Deadlock=>Circular wait, but not vice versa
- no cycles=>no deadlock
- **one** instance per resource type -> deadlock
- **several** instances per resource type -> possibility of deadlock

## Deadlock Prevention