# Minotaur Problems - Srignan Paruchuru
## Problem One:
The leader is the first person to go in. If the plate is empty, the leader counts it using a counter. Once the counter hits N(the guest number), the program breaks. Since there is a q implemented, all of the guests will be entered in the first iteration but the leader would not know that. It seems like something a sneaky Minotaur would do to troll the guests. I could have made a function where the guest who enter are randomized but the end result is the same as the leader counts to N number either way.

There are print statements that track the progress and show what is going on. Basically the number of guests are tracked by a queue representing the order of in which they go in. They are iterated through different threads in the array and break when the leader counts the broken plates. The print statements counts all the guest so the user can see how many have eaten already. But the main idea is that the counter records the N number of empty plates.
## Problem Two:
I chose option three.
Same idea as before in that you add a queue. There is a loop that removes every index in the q in order. Threads are used to multiply the number of people going in and out at a time. There is a hardcoded 50% chance that a guest will choose to go back in line to reduce variation in the program. I could have made it random but I felt that it would caused to much variation. Time is recorded similarly.
## Runtime Data
I did run both programs in Intellij, since it is easier to reload text outputs which made it easier to record the times, so the runtimes may differ depending on if you are using an IDE or terminal.
I have a text file named "RunningTimes" that shows the avg result between three trials for three different times. The Birthday problem had the most variation especially as the guest(N) input grew larger. The Crystal Vase seems more optimal and it can definetly run a higher number of guests.
