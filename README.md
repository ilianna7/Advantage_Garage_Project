# Advantage_Garage_Project
This is the code for the mini garage project for advantage FSE. It simulates a very symplified garage system.



The program runs with the user's input, who gets to decide most of the variables in the simulation and the events that take place.

More specifically, besides the default values the system has for quick runs, the user can specify the garage's prices about each vehicle type and how many parking spaces it has. The user can also add more employees to the 'database' and more cutomers, both of which he can fully customise.

It's important to note that the project in order to keep it at a syplified version, has a lot of limitations. For example there is max amount of money you can charge per hour depending on the vehicle and there is a max amount of parking spaces the garage can have. In addition, each customer can have only up to two vehicles.

The program is very strict over the user's input, meaning it only accepts values that correspon to its tasks and it has restrictions on string inputs (e.g. names can't have numbers in them). It is also, very careful not to have any duplicates at cases it shouldn't, such as employee's IDs, vehicles plates and customer's driver's licenses (which function as the customer's IDs). As a side note, both IDs are 5 digits, randomly generated numbers.

The most important thing to address though is, that the program DOESN'T RUN IN REAL TIME. Instead, in order to simoulate a quick and simple version of how a garage works, we opted to consider seconds as minutes and minutes as hours. This way, the user doesn't need to actually wait an hour to see the garage make any profit.
As an example, 1 minute in real life is 1 hour in the program, 1 second in real life is a minute in the program and vise versa. 

During the simulation, the user can decide which event is going to happen, or they can choose for a max number of ten random events.
They also have the choice to see the stats of the garage, which include its capacity and the amount of money it has earned. 

Last but not least, the user can navigate everything mentioned about by the program's menu, which is very simple to operate. When asked to enter an input, all they need to do is type the number of their choice's action.

For any further questions you can contact me at: iliannakli@gmail.com
