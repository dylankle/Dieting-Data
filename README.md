# CISC 191 Final Project

## Project Proposal

**Overview**

Tracking what you put in your body is important, but no one has the time to note or jot down every meal, snack, and drink they have in a day. DietingData will be an application where the user can add what they eat in a day. Each food will be organized chronologically based on user's input of time. A water counter will be included as well.

**Development Tasks:**

- [x] Get user input as "food or water"
- [x] If "food" add item with attached details / If "water" add amount of water and update progress bar
- [x] Add  -> Attach additional details to input such as time and details (meat, carb, vegetable, fruit, dairy)
- [x] User can edit previously added items, view and expand items to see details, or export data to .txt file
- [x] Edit -> Select an item and change the name, type, or details
- [ ] View -> See and sort items based on the user's choices
- [x] Done -> Export data as .txt file

**UML Diagram/CRC Cards/GUI Wireframe**

![DylanLe - Final Project UML_CRC (CISC 191) (2)](https://github.com/dylankle/Dieting-Data/assets/68560708/3cb3f12f-1338-4d46-8c85-e177a48a8a4f)
![Dylan Le - Final Project GUI Wireframe (CISC 191) (3)](https://github.com/dylankle/Dieting-Data/assets/68560708/25778eab-cd63-40c4-8f68-d14930e223f1)



## Project Checkpoints:

**Week 1**

UML Diagram with CRC cards completed. Class interactions and implementations are clear. Project is concise enough to begin coding, slight adjustments to capabilities or additional features can easily be edited before final submission. Early draft can begin coding.

**Week 2**

Asking for inital date, setting up intial startup frame including layout and components. Will finish a few test cases before moving to Week 3. Finishing the buttons, labels, and progressbar. No listeners have been connected. Also mapped out the chronologial order of pop-ups, squencing, and actions (on paper)

**Week 3**

I revised the pathways as to how the program would progress. The UML diagram will stay the same for the most part, but the initial start of the program will utilize file I/O to lower the amount of JOptionPanes. This way I can avoid to many pop-ups.

**Week 4**

The edited pathway has been solidified. Implenting the new methods has been quite the task, but have been moving steadily. The adding method is working properly. The food items are added to the menu and the water progress bar updates itself.

**Week 5**

I have revised the food item class to increase connectivity by making it extend the Jbutton class. This way each button can be interacted with and easily access stored data within its class' field. The intial pane was removed and now the program will take the date from a the worldtimeapi as in the module 9 lab.

**Week 6**

The program is practically finished. I have completed the add, edit, and view modes. The add food mode prompts for a name, type, details, and adds it to the food menu as a JButton. The add water mode takes an amount and updates the water progress bar. The edit mode allows the user to select a button and change the name, type, or details. The view mode allows the user to select a button and a JOptionPane will show the name, type, and details of the item. The final feature is that the program can export all the items to the user's download folder.

**Week 7**

I have commented the program, organized the methods, and cleaned up the headers of each class. I revised and fixed a few details from the UML diagram.  I wanted to check practicality, exceptions, and weak points in the code, but navigating the project was difficult because I got lazy with my naming and commenting. Test cases have also been completed apart from expected exceptions.

**Week 8**

