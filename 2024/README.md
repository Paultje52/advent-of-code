This year, I will try to solve all the problems in Java. I'm a bit experienced in Java, but I'm not a professional. I'm doing this to improve my Java skills and to learn new things. I will try to write clean and efficient code, but I'm not an expert in Java. If you see any mistakes or have any suggestions, please let me know. I'm always open to feedback.

<details>
  <summary>Day 1</summary>
  
  For the distance challenge, I decided to read the input as a string. After that, the code is going through each line and adds both values in an arraylist, exactly on the correct place. Because of this, the arraylist is immediately sorted and I can just loop through all the values and calculate the distance using `Math.abs`.

  _Distance answer: 2580760_

  For the similarity, I don't have to sort the input. I'm just going through the first column and then counting how many times the number appears in the second column.

  _Similarity answer: 25358365_
</details>

<details>
  <summary>Day 2</summary>

  First, I wrote a simple `isSafe` method to check if a report is safe. There were two rules provided to check if a solution was safe.
  - The levels are either all increasing or all decreasing.
  - Any two adjacent levels differ by at least one and at most three.

  _First answer: 269_

  For the second challenge, I decided to loop over the amount of elements in each report and remove the level at that index.
  For example: the report `[1,3,5]` will have three checks: `[3,5]`, `[1,5]` and `[1,3`. For each report, I'm using the original method to check if the new report is safe. When it is, I know only one level was broken, thus the rule is valid using the Problem Dampener.

  _Second answer: 337_
</details>

<details>
  <summary>Day 3</summary>

  My first thought when reading the challenge was regex. We have to find a pattern `mul(x,y)`, where x and y can be one, two or three digits.
  Normally, I'm letting ChatGPT write my regex, but this time I decided to write it myself. <br/>
  I started with matching the `mul()`. After that I found a [stackoverflow solution](https://stackoverflow.com/a/8020991/13074865) to match to one, two or three digits and ended up with the following regex: `mul\([0-9]{1,3},[0-9]{1,3}\)`.

  After using the regex to extract all the valid `mul` instructions, I just looped through them and calculated the result using string splitting.

  _First answer: 173419328_

  For adding the `do()` and `don't()` instructions, I just appended it to my regex and added a simple if statement and boolean to check if the multiplication should be done. <br/>
  Updated regex: `mul\([0-9]{1,3},[0-9]{1,3}\)|don't\(\)|do\(\)`

  _Second answer: 90669332_
</details>

<details>
  <summary>Day 4</summary>
  
  When looking at the word search, I thought about a 2D matrix. Using this matrix, I could easily navigate and find the right word. For the first challenge, I could find every `X` and go from there to find the full `XMAS` word in every direction.

  _First answer: 2633_

  For the second challenge, I could just find every `A` and look at the top left, top right, bottom left and bottom right to find the `MAS word.

  _Second answer: 1936_

  _This is an incredibly inefficient solution with very ugly code. I'm curious to see how others solved this problem, so I can learn from it._
</details>