import tkinter

from realspeechtotext import STT
from miclist import ML

class manager (object):

    def __init__ (self):
        self.root = tkinter.Tk()
        self.current_screen = None
        self.mic_index = None
    
    def setup_first (self):
        # Changes the window's title
        self.root.title ("Speech to text")
        # Creates and displays a Character Selection screen
        self.current_screen = STT(master = self.root, callback_on_selected = self.switch, mic_index = self.mic_index)

    def switch (self):
          
        # Destroys the Character Selection window
        self.current_screen.destroy()

        # Continue on - set up the Prepare To Battle screen!
        self.setup_miclist()

    def setup_miclist (self):
        '''
        This method is called to set up the Character Selection screen. 
        This also initializes the character_roster property.
        '''
        # Changes the window's title
        self.root.title ("Mic list")
        # Creates and displays a Character Selection screen
        self.current_screen = ML(master = self.root, returnn = self.return_to_character
                                                        )
    
    def return_to_character (self, selected_mic_index):
        # return mic index
        self.mic_index = selected_mic_index
        
        # Destroys the Character Selection window
        self.current_screen.destroy()

        # Continue on - set up the Prepare To Battle screen!
        self.setup_first()


def main():
    # Create the battle manager, which creates the tkinter window.
    battle = manager()
    # The program begins with the Character Selection screen!
    battle.setup_first()
    # Run the program!
    battle.root.mainloop()
 
main()