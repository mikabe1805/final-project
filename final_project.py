import tkinter
import os

from choose import Choose
from games import Games

class manager (object):

    def __init__ (self):
        self.root = tkinter.Tk()
        self.current_screen = None
    
    def choose(self):
        self.root.title ("Choose a program")
        # Creates and displays a Character Selection screen
        self.current_screen = Choose(master = self.root, returnn = self.move_on)

    def move_on(self, choice):
        self.choice = choice

        self.current_screen.destroy()

        # Continue on - set up the Prepare To Battle screen!
        self.setup_first()

    def setup_first (self):
        if self.choice == "speechtotext":
            os.system('python speechtotextgui.py')
        elif self.choice == "games":
            self.switch()
        elif self.choice == "sudoku":
            os.system('python GUI.py')
        elif self.choice == "snake":
            os.system('python snake.py')
        elif self.choice == "gradecalculator":
            os.system('java --module-path C:/Users/mikus/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media gradecalculator')
        elif self.choice == "pomodoro":
            os.system('java --module-path C:/Users/mikus/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media pomodoro')
        self.choose()

    def switch (self):
          
        # Destroys the Character Selection window

        self.current_screen.destroy()

        # Continue on - set up the Prepare To Battle screen!
        self.games()

    def games (self):
          
        self.root.title ("Choose game")
        # Creates and displays a Character Selection screen
        self.current_screen = Games(master = self.root, returnn = self.move_on)

def main():
    # Create the battle manager, which creates the tkinter window.
    battle = manager()
    # The program begins with the Character Selection screen!
    battle.choose()
    # Run the program!
    battle.root.mainloop()
 
main()