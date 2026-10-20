# LAB1: 

## task2:discuss Timing results and the get() visibility
why does making only increment() synchronized but not get() still leave a bug?
+ Answer: Making only increment() synchronized protects updates from concurrent modification but unsynchronized get() does not acquire the same lock this making Java does not guarantee that the reading thread sees the latest updated value it cause a problem so Synchronizing both methods ensures that updates made by one thread are visible to another thread that subsequently acquires the same lock.


## task3: explains why while + notifyAll() is required.
+ Answer: 
    1. use while because a thread may wake up when the buffer is still full or empty another thread might have changed the buffer before the awakened thread gets the lock. The while loop checks the condition again and makes the thread wait if necessary. 
    2.We use notifyAll() because both producers and consumers wait on the same buffer if use just notify() may wake the wrong type of thread. 

## challenge


### Performance Report

### 1. Scaling Benchmark

Dataset: 200 files × 50,000 words = 10,000,000 words.

| Worker Mode | Workers | Elapsed Time (ms) |
|---|---:|---:|
| Platform Threads | 1 | TODO |
| Platform Threads | 2 | TODO |
| Platform Threads | 4 | TODO |
| Platform Threads | 8 | TODO |
| Virtual Threads | Virtual | TODO |

### 2. LongAdder / merge vs synchronized

LongAdder reduces contention when multiple threads update the same counter. ConcurrentHashMap supports concurrent updates to different keys. This can be faster than synchronized, which makes threads wait for the same lock. merge() is also a thread-safe way to update map values.

### 3. Coffman Conditions and Deadlock Prevention

My design prevents the circular wait condition by acquiring shared locks in a consistent order. This prevents threads from waiting on each other in a cycle, avoiding deadlock. Breaking any one of the four Coffman conditions is sufficient to prevent deadlock.


