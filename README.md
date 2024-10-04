# MultiThreaded Webserver Using Java

This project implements and compares the performance of three different server implementations in Java: Single-threaded, Multi-threaded, and Multi-threaded with Thread Pool. The performance is tested using Apache JMeter.

## Server Implementations

1. **Single-threaded Server**: Handles client requests sequentially.
2. **Multi-threaded Server**: Creates a new thread for each client connection.
3. **Multi-threaded Server with Thread Pool**: Uses a fixed thread pool to handle client requests.

## Performance Testing

Performance testing was conducted using Apache JMeter, sending 60,000 requests in 30 seconds. The key performance metrics analyzed are:

- **Throughput**: The number of requests that can be handled per unit of time (requests/minute).
- **Deviation**: Measures the variability or dispersion in response times.
- **Median**: The middle value of response times when sorted.
- **Average**: The mean response time.

### Test Results

| Server Type | Throughput (req/min) | Deviation (ms) | Median (ms) | Average (ms) |
|-------------|----------------------|----------------|-------------|--------------|
| Single-threaded | 60,004 | 177 | 14 | 93 |
| Multi-threaded | 60,000 | 262 | 6 | 118 |
| Thread Pool | 59,533,653 | 356 | 45 | 176 |

### Analysis

1. **Throughput**: 
   - The Thread Pool implementation significantly outperforms the others, handling about 59 million requests per minute.
   - Single-threaded and Multi-threaded servers have similar throughput, around 60,000 requests/minute.

2. **Deviation**:
   - The Thread Pool server shows the highest deviation (356 ms), indicating more variability in response times.
   - The Single-threaded server has the lowest deviation (177 ms), suggesting more consistent response times.

3. **Median**:
   - The Multi-threaded server has the lowest median response time (6 ms), indicating faster responses for the majority of requests.
   - The Thread Pool server has a higher median (45 ms), possibly due to thread management overhead.

4. **Average**:
   - The Single-threaded server has the lowest average response time (93 ms).
   - The Thread Pool server has the highest average (176 ms), likely due to the extreme throughput it's handling.

### Interpretation

- **Single-threaded Server**: Offers consistent performance but may not scale well with increased load.
- **Multi-threaded Server**: Provides good median response times but shows higher variability.
- **Thread Pool Server**: Delivers exceptional throughput at the cost of higher average response times and variability.

## Impact of Thread Pool Size

The size of the thread pool can significantly affect server performance:

- **Smaller pool**: May limit concurrency but reduce overhead.
- **Larger pool**: Can handle more concurrent requests but may increase resource consumption and context switching overhead.

Optimal thread pool size depends on factors like server hardware, expected load, and the nature of client requests. Experimentation is key to finding the right balance for your specific use case.

## Conclusion

Each server implementation has its strengths and trade-offs. The choice depends on your specific requirements:

- For consistent, predictable performance: Single-threaded server
- For a balance of responsiveness and scalability: Multi-threaded server
- For handling extremely high loads: Thread Pool server (with carefully tuned pool size)

Further optimization and testing with various load patterns and server configurations are recommended for production use.
