Applying concurrency to genetic algorithm solution for Travelling Salesman Problem. Based on solution from The Project Spot: http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5

Concurrency is applied via ExecutorService. It's much slowe than the original solution to be honest but the goal itself was to implement some kind of concurrency and not to improve algorithm speed.

Additionally, lastest version offers simple client-server solution allowing to send data between two machines. In order to run the program in its current state, you need to follow these steps:
1. Decide which PC will act as a server (the other one obviously will become a client then).
2. In **TSP.java** you'll have to change value of _**ip**_ variable to match your server's actual IPv4 address. So for example if your IPv4 address is 192.153.0.52 your variable should look like this: ```String ip = "192.153.0.52";``` You can easily check your address by typing _**ipconfig**_ in Windows CMD or _**ifconfig**_ in Linux Terminal.
3. **Launch server first** by running program and choosing '1' when prompted.
4. Launch client by running program and choosing '2' when prompted.

If you can't connect to other PC it probably means that either your firewall or router is blocking connection. You'll have to either disable it/exculde this application or alternatively you can change variable _**port**_ in order to change network port (default: 3333).
