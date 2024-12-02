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