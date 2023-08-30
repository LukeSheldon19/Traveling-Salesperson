Programming Assignment: Traveling Salesperson Problem


/**********************************************************************
 * All teammates' names Luke Sheldon                                          *
 **********************************************************************/


/**********************************************************************
 * Approximate number of hours to complete this assignment     6       *
 **********************************************************************/

Number of hours for 1st TEAMMATE's NAME:

Number of hours for 2nd TEAMMATE's NAME:


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/

Originally I used the do while loop to iterate through the linked list and chech the distance between p and each point.
This however did not work for less than 4 nodes. From here I adjusted my code creating a new linked path depending on the length
of the given linked list and using the size method as a reference to this size.



/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/
The difference between this function and the last is the method in calculating distances. This function calculated a delta distance
between the new point and 2 others. This was calculated using a reference node which used the head not as the first and then finding the
difference. This was then compared to when iterating through the linked list.



/**********************************************************************
 *  First, explain why it is better to use a linked list instead of   *
 *  an array. Second, explain what is the advantage of using a        *
 *  *circularly* linked list instead of a normal linked list.
 **********************************************************************/

1. Linked lists are advantageous to arrays as they can grow dynamically and do not require a complete shift when adding new elements


2. In a circular linked list any node is accessible from any other through looping through the list. This is not possible in a regular linked list


/**********************************************************************
 *  Did you receive help from classmates, past CSCI 121 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no? From a TA both Monday and Wednesday


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no? no


/***********************************************************************
 ***   Do you attest that this work is your own, in accordance with  ***
 ***   the statement on academic integrity in the syllabus?          ***
 ***********************************************************************/

Yes or no? yes



/**********************************************************************
 *  List any other comments here.
 **********************************************************************/

