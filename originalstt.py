import tkinter

from speechtotext import STTT

class manager (object):

    def __init__ (self):
        self.root = tkinter.Tk()
        self.current_screen = None
        self.mic_index = None
    
    def setup_first (self):
        # Changes the window's title
        self.root.title ("Speech to text")
        # Creates and displays a Character Selection screen
        self.current_screen = STTT(master = self.root)



def main():
    # Create the battle manager, which creates the tkinter window.
    battle = manager()
    # The program begins with the Character Selection screen!
    battle.setup_first()
    # Run the program!
    battle.root.mainloop()
 
main()