/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:05]
*     Last Modified       :     [2015-09-29 20:08]
*     Description         :     Sort Big File 
*
*     Imagine you have a 20 GB file with one string per line. Explain how you
*     would sort the file. 
*
*     *. if the string is very long, can first tranlate the string into
*     integers and index pairs before sorting, then restore the string using
*     the index mapping
*     0. use a distributed system to process the file, like Hadoop or Spark
*     1. split the file into small chuncks and sort each chunks, then merge
*     them into larger chunks
**********************************************************************************/
