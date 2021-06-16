import tkinter

from realspeechtotext import STT
from miclist import ML
from filename import FL

class manager (object):

    def __init__ (self):
        self.root = tkinter.Tk()
        self.current_screen = None
        self.mic_index = None
        self.file_name = None
    
    def get_filename(self):
        self.root.title ("Choose file")
        # Creates and displays a Character Selection screen
        self.current_screen = FL(master = self.root, returnn = self.move_on)

    def move_on(self, filename):
        self.file_name = filename
        for i in filename:
            if i == ".":
                filename = filename.split(".")
                self.file_name = filename[0]

        self.current_screen.destroy()

        # Continue on - set up the Prepare To Battle screen!
        self.setup_first()

    def setup_first (self):
        # Changes the window's title
        self.root.title ("Speech to text")
        # Creates and displays a Character Selection screen
        self.current_screen = STT(master = self.root, callback_on_selected = self.switch, mic_index = self.mic_index, file_name=self.file_name)

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
        self.root.title ("mic list")
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
    battle.get_filename()
    # Run the program!
    battle.root.mainloop()
 
main()